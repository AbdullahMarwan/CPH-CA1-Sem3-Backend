pipeline {
    agent any
    tools {
        //gradle 'Gradle 8.0.2'
        gradle 'Gradle 7.6.1'
    }
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
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