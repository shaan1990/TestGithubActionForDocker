pipeline {

    agent any

    environment {
        IMAGE_NAME = "santanu/myapp:${BUILD_NUMBER}"
    }

    stages {

       stage('Checkout') {
           steps {
               git branch: 'main', url: 'https://github.com/shaan1990/TestGithubActionForDocker.git'
           }
       }


       stage('Build App') {
           steps {
               bat 'mvn clean package'
           }
       }

        stage('Build Docker Image') {
            steps {
                bat "docker build -t %IMAGE_NAME% ."
            }
        }

        stage('Push Docker Image') {

            steps {

                withCredentials([usernamePassword(
                    credentialsId: 'docker-creds',
                    usernameVariable: 'docker_santanu',
                    passwordVariable: 'Admin123$'
                )]) {

                    bat 'docker login -u %USER% -p %PASS%'
                    bat "docker push %IMAGE_NAME%"
                }
            }
        }

        stage('Deploy to Kubernetes') {

            steps {

                bat 'kubectl apply -f deployment.yaml'
                bat 'kubectl apply -f service.yaml'
            }
        }
    }
}