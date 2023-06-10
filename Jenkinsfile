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
        DOCKER_HOST='tcp://172.31.93.144:2375'
        //DOCKER_IMAGE = 'springbootecommerceapplication_app:latest'
        //CONTAINER_NAME = 'SpringBootEcommerceApplication'
      }
      steps {
        // Stop and remove the existing application container if it exists
        sh 'docker stop springbootecommerceapplication_app || true'
        sh 'docker rm springbootecommerceapplication_app || true'
        
        // Stop and remove all running containers
        sh 'docker-compose down'
        
        // Delete all containers
        sh 'docker rm $(docker ps -aq)'
        
        // Delete all images
        sh 'docker rmi $(docker images -q)'
        
        // Build a new Docker image for your Spring Boot application
        //sh 'docker build -t springbootecommerceapplication_app . -f Dockerfile'
        
        // Run the new application container
        //sh 'docker run -d --name springbootecommerceapplication_app -p 9090:9090 springbootecommerceapplication_app'
        
        // Start the build process again using docker-compose
        sh 'docker-compose up -d'
      }
    }
  }
}
