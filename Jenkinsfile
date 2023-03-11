pipeline {
    agent any
    tools {
        gradle '8.0.2'
    }
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                sh 'gradle --version'
                sh 'gradle assemble --stacktrace'
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