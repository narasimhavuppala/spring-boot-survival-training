pipeline {
    agent any
	tools { 
        maven 'Maven 3.8.6' 
        jdk 'jdk-11' 
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