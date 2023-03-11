pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                sh 'gradle assemble'
            }
        }
         stage('Test') {
            steps {
                sh 'gradle test'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'gradle buildImageViaDockerfile'
            }
        }
        stage('Run Docker Image') {
            steps {
                sh 'gradle runDockerImage'
            }
        }
    }
}