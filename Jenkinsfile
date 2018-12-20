
pipeline {
    agent any
    tools {
     maven 'Maven 3.6.0'   
     jdk 'jdk1.8.0_151'
    }
    stages {
    stage('Build'){
      steps {
        bat 'mvn clean install'
      }
        post{
            success{
                junit 'target/surefire-reports/**/*.xml'
            }
        }  
    }
    
    stage('Test'){
      steps {
        bat "mvn test"
      }
      post{
            success{
                junit 'target/surefire-reports/**/*.xml'
            }
        } 
    }

    stage('Coverage Code'){
      steps {
        bat "mvn cobertura:cobertura -Dcobertura.report.format=xml"
      }
      post{
            success{
                cobertura coberturaReportFile: '**/target/site/cobertura/coverage.xml'
            }
        }

    }

    stage('JavaDoc Generation'){
      steps {
        bat "mvn javadoc:javadoc"
      }
    }


    
    stage('Deploy'){
      steps {
        echo 'Deploying ..'
      }
    }
    
  }  
}
