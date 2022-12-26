pipeline {
    agent {
	
	  docker {
            image 'maven:3.8.6-eclipse-temurin-11' 
            args '-v /root/.m2:/root/.m2' 
        }
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