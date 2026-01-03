# Jenkins Shared Library

## Project Description
This project demonstrates how to create and use a Jenkins Shared Library (JSL) 
to extract common CI/CD logic and reuse it across Jenkins pipelines.

## Technologies Used
- Jenkins
- Groovy
- Docker
- Git
- Java
- Maven

## Repository Structure


## Shared Library Functions
- `buildImage(imageName)` – builds a Docker image
- `dockerLogin()` – logs in to DockerHub using Jenkins credentials
- `dockerPush(imageName)` – pushes Docker image to DockerHub
- `deploy()` – deployment placeholder

## Usage in Jenkins Pipeline
The shared library can be loaded globally or per project.

Example usage in Jenkinsfile:

```groovy
@Library('jenkins-shared-library') _
pipeline {
    agent any
    stages {
        stage('Build Image') {
            steps {
                buildImage('asdhka/annirep:jma-3.0')
            }
        }
        stage('Push Image') {
            steps {
                dockerLogin()
                dockerPush('asdhka/annirep:jma-3.0')
            }
        }
    }
}



in Java-maven-app-ci:


Enthält:
- Java/Maven App
- `Jenkinsfile`, das die Shared Library nutzt

### Jenkinsfile (Beweis der Integration):
```groovy
@Library('jenkins-shared-library') _
pipeline {
    agent any
    stages {
        stage('Build & Push') {
            steps {
                buildImage('asdhka/annirep:jma-3.0')
                dockerLogin()
                dockerPush('asdhka/annirep:jma-3.0')
            }
        }
    }
}
