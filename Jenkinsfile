pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                checkout scm // This will clone the repository
            }
        }
        stage('Test Maven Command') {
            steps {
                sh 'mvn -v' // Check Maven version to ensure it's set up
                sh 'mvn clean install' // Try building the project
                sh 'mvn test' // Try running tests
            }
        }
    }
}
