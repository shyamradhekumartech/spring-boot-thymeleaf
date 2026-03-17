pipeline {
    agent any

    tools {
        // Use the names you defined in Global Tool Configuration
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {
        stage('Checkout') {
            steps {
                // Pulls code from the GitHub repo configured in the Jenkins Job
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Compiles and packages the app into a JAR, skipping tests for now
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                // Runs unit and integration tests
                sh 'mvn test'
            }
            post {
                always {
                    // Archives test results in Jenkins UI
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                // Option A: Simple execution (for testing)
                // sh 'nohup java -jar target/*.jar &'

                // Option B: Docker deployment (Production standard)
                // sh 'docker build -t my-spring-app:${BUILD_NUMBER} .'
                // sh 'docker run -d -p 8080:8080 my-spring-app:${BUILD_NUMBER}'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check logs.'
        }
    }
}