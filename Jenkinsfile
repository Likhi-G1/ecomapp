pipeline
{
agent any
    stages 
    {
        stage('Build')
        {
            steps
            {
                git "https://github.com/Likhi-G1/ecomapp.git"

                sh 'mvn clean install'

            }
        }

        stage('Test')
        {
            steps
            {
                sh mvn 'test'
            }
        }
        stage('Docker')
        {
            steps
            {
                sh 'docker build -t ecomapp:latest .'

                sh 'docker-compose up -d'
            }
        }

    }

}
