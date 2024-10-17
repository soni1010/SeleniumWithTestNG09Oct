pipeline {
    agent any

    tools {
        jdk 'JDK 21' 
        maven 'Maven 3.9.9'
    }

    stages {
        stage('Clone Repository') {
            steps {
                checkout scm // This will clone the repository
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install' // Build the project using Maven
            }
        }
        stage('Run Tests') {
            steps {
                sh 'mvn test' // Execute the tests
            }
        }
    }
    
    post {
        success {
            archiveArtifacts artifacts: 'extentReport.html', fingerprint: true // Archive the report on success
        }
        failure {
            archiveArtifacts artifacts: 'extentReport.html', fingerprint: true // Archive the report on failure
        }
    }
}
