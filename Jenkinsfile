pipeline {
  agent any

  stages {
    stage('Build') {
      steps {
        // Checkout your source code from GitHub
        git 'https://github.com/Haneesh55/SpringBootEcommerceApplication.git'

        // Build your Spring Boot application
        sh 'mvn clean install'
      }
    }

    stage('Test') {
      steps {
        // Run tests on your Spring Boot application
        sh 'mvn test'
      }
    }

    stage('Deploy') {
      environment {
        // Set environment variables for deployment
        DOCKER_HOST='tcp://172.31.92.169:2375'
        CONTAINER_NAME = 'ecomapp'
      }
      steps {
        // Stop and remove the existing EcomApp container if it is running
        sh 'docker stop ${CONTAINER_NAME} || true'
        sh 'docker rm ${CONTAINER_NAME} || true'

        // Delete the EcomApp image if it exists
        sh 'docker rmi ${CONTAINER_NAME} || true'

        // Build a new Docker image for your Spring Boot application
        sh 'docker build -t ${CONTAINER_NAME} . -f Dockerfile'

        // Start the build process using docker-compose
        sh 'docker-compose up -d'
      }
    }
  }
}
