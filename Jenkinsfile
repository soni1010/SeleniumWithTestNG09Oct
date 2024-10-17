pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                checkout scm // This will clone the repository
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install' // Use 'bat' for Windows
            }
        }
        stage('Run Tests') {
            steps {
                bat 'mvn test' // Use 'bat' for Windows
            }
        }
    }
}
