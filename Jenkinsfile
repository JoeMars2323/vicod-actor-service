pipeline {
    agent any
    
    environment {
        dockerHome = tool "myDocker"
        mavenHome = tool "myMaven"
        PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
    }
    
    stages {
        stage ("Checkout") {
            steps {
                sh "mvn --version"
                sh "docker version"
                echo "Build"
                echo "PATH - $PATH"
                echo "JOB_NAME - $env.JOB_NAME"
                echo "BUILD_NUMBER - $env.BUILD_NUMBER"
                echo "BUILD_ID - $env.BUILD_ID"
                echo "BUILD_TAG - $env.BUILD_TAG"
                echo "BUILD_URL - $env.BUILD_URL"
            }
        }
        
        stage ("Compile") {
            steps {
                sh "mvn clean compile"
            }
        }
        
        stage ("Test") {
            steps {
                sh "mvn test"
            }
        }
        
        stage ("Integration Test") {
            steps {
                sh "mvn failsafe:integration-test failsafe:verify"
            }
        }
        
        stage ("Package") {
            steps {
                sh "mvn package -DskipTests"
            }
        }
        
        stage ("Build docker image") {
            steps {
                script {
                    dockerImage = docker.build("joeymars2323/vicod-actors-service:${env.BUILD_TAG}");
                }
            }
        }
        
        stage ("Push docker image") {
            steps {
                script {
                    docker.withRegistry("", "dockerhub") {
                        dockerImage.push();
                        dockerImage.push("latest");
                    }
                }
            }
        }
    }
    
    post {
        always {
            echo "execute always"
        }
        success {
            echo "execute in success"
        }
        failure {
            echo "execute in failure"
        }
        changed {
            echo "execute when the status change"
        }
    }
}
