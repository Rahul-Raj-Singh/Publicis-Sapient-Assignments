node{

  stage('Git pull'){
    git 'https://github.com/Rahul-Raj-Singh/jenkins-hello'
    }
    
   stage('Build-Package'){
    def mvnHome = tool name: 'MAVEN3.3', type: 'maven'
    bat(/"${mvnHome}\bin\mvn" clean package/)
   }
   
   stage('Run'){
       bat 'java -cp target/hello-1.0-SNAPSHOT.jar com.assignment.hello.App'
   }
   
 }