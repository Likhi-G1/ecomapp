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

    stage('Deploy') {
      environment {
        CONTAINER_NAME = 'ecomapp'
        KUBECONFIG = '/var/jenkins_home/credentials/k8sgroup/kube-config.txt'
      }
      steps {
        // Set up Kubernetes context using kubeconfig
        withKubeConfig([credentialsId: 'k8sgroup', kubeconfigFileVariable: 'KUBECONFIG']) {
          // Delete the existing EcomApp deployment and service if they exist
          //sh 'kubectl delete application-deployment.yml ${CONTAINER_NAME} || true'
          //sh 'kubectl delete application-service.yml ${CONTAINER_NAME} || true'

          // Build the Docker image and push it to Docker Hub
          sh 'docker build -t haneeshdevops/${CONTAINER_NAME}:latest .'
          sh 'docker login -u haneeshdevops -p intMega@95422'
          sh 'docker push haneeshdevops/${CONTAINER_NAME}:latest'

          // Deploy the application to Kubernetes using the deployment YAML file
          sh 'kubectl apply -f path/to/application-deployment.yml'

          // Start the service
          sh 'kubectl apply -f path/to/application-service.yml'

          // Create a service to expose the application
          //sh 'kubectl expose deployment/${CONTAINER_NAME} --port=8084 --target-port=8084 --type=LoadBalancer --name=${CONTAINER_NAME}'
        }
      }
    }
  }
}

