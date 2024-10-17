pipeline {
    agent any

    tools {
        jdk 'JDK 21' 
        maven 'Maven 3.9.9'
    }

    stages {
        stage('Clone Repository') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }
    }
    
    post {
        always {
            archiveArtifacts artifacts: '**/extentReport.html', fingerprint: true // Adjust path if necessary
        }
    }
}
