pipeline {
  agent any

  stages {
    stage('Build') {
      steps {
        // Checkout your source code from GitHub
        git 'https://github.com/HaneeshDevops/ecomapp.git'

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

    stage('Docker Build and Push') {
      steps {
        // Build the Docker image
        sh 'docker build -t haneeshdevops/ecomapp:latest .'

        // Push the Docker image to Docker Hub
        sh 'docker login -u haneeshdevops -p intMega@95422'
        sh 'docker push haneeshdevops/ecomapp:latest'
      }
    }

    stage('Deploy') {
      environment {
        CONTAINER_NAME = 'ecomapp'
        KUBECONFIG = credentials('k8sgroup')
      }
      steps {
        // Set up Kubernetes context using kubeconfig
        withKubeConfig([credentialsId: 'k8sgroup', kubeconfigFileVariable: 'KUBECONFIG']) {
          // Deploy the application to Kubernetes using the deployment YAML file
          sh 'kubectl apply -f application-deployment.yml'

          // Start the service
          sh 'kubectl apply -f application-service.yml'

          // Create a service to expose the application
          // sh 'kubectl expose deployment/${CONTAINER_NAME} --port=8084 --target-port=8084 --type=LoadBalancer --name=${CONTAINER_NAME}'
        }
      }
    }
  }
}
