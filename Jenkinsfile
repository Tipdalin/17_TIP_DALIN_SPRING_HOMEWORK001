pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Spring Boot') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t ticket-rest-api:latest .'
            }
        }

        stage('Deploy') {
            steps {
                bat 'docker stop ticket-rest-api || exit 0'
                bat 'docker rm ticket-rest-api || exit 0'
                bat 'docker run -d --name ticket-rest-api -p 8083:8083 ticket-rest-api:latest'
            }
        }
    }
}