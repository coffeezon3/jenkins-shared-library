#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {

    def script

    Docker(script){
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "Building the Docker image: ${imageName}..."

        script.withCredentials([script.usernamePassword(
            credentialsId: 'docker-hub-repo', 
            passwordVariable: 'PASS', 
            usernameVariable: 'USER'
        )]) {
            // Docker build
            script.sh "docker build -t ${imageName} ."

            // Docker login securely
            script.sh "echo \$PASS | docker login -u \$USER --password-stdin"

            // Docker push
            script.sh "docker push ${imageName}"
        }
    }
}
