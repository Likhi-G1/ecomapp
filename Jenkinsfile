pipeline {
    agent {
        label 'your-agent-label' // Specify the label of the Jenkins agent you want to use
    }
    stages {
        stage('Build') {
            steps {
                // Clone the Git repository
                git 'https://github.com/Likhi-G1/ecomapp.git'
                
                // Build the project using Maven
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                // Run tests using Maven
                sh 'mvn test'
            }
        }
        stage('Docker') {
            steps {
                // Build a Docker image
                sh 'docker build -t ecomapp:latest .'
                
                // Start Docker containers using Docker Compose
                sh 'docker-compose up -d'
            }
        }
    }
}
