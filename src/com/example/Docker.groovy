#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "Building Docker image: ${imageName}..."

        // credentialsId muss in Jenkins hinterlegt sein
        script.withCredentials([script.usernamePassword(
            credentialsId: 'docker-hub-repo',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )]) {
            // Sicheres Login
            script.sh """
                echo "\$DOCKER_PASS" | docker login -u "\$DOCKER_USER" --password-stdin
            """

            // Docker Build & Push
            script.sh "docker build -t ${imageName} ."
            script.sh "docker push ${imageName}"
        }
    }
}

