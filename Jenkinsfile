pipeline {
    agent any
    tools {
        maven 'Maven 3.1.0'
        jdk 'JDK 1.8.0'
    }
    stages {
        stage ('Compile Stage') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage ('Testing Stage') {
            steps {
                bat 'mvn test' 
            }
        }

        stage ('Deployment Stage') {
            steps {
                bat 'mvn deploy' 
            }
        }
    }
}
