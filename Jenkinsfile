pipeline {
    agent none
    stages {
        stage('Back-end') {
           
            steps {
                sh 'mvn --version'
            }
        }
        stage('Front-end') {
          
            steps {
                sh 'node --version'
            }
        }
    }
}