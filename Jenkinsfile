pipeline {
    agent any
	tools { 
        maven 'M3' 
        jdk 'java17' 
    }
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
