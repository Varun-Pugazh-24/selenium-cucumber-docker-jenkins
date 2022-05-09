pipeline {
   agent any

   stages {    
      stage('Check Maven'){
          steps{
              bat 'mvn -v'
               }
      }
      stage('Test'){
          steps{
              bat 'mvn clean install'
               }
      }
   }
}