pipeline {
    agent any
    environment {
        JDBC_DRIVER    = 'com.mysql.cj.jdbc.Driver'
    }
    tools {
        gradle 'Gradle 7.6.1'
    }
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Test-env') {
            steps {
               echo env.JDBC_DRIVER
               echo env.JDBC_URL
               echo env.JDBC_USER
               echo env.JDBC_PASSWORD
            }
        }
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
                //sh 'gradle docker'
                sh 'docker build --tag ca1-backend .'
            }
        }
        stage('Run Docker Image') {
            steps {
                //sh 'gradle dockerRun'
                sh 'docker run -p 5000:8080 ca1-backend'
            }
        }
    }
}