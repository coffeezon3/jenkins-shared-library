#!/user/bin/env groovy

<<<<<<< HEAD
import com.example.Docker

def call(String imageName) {
    return new Docker(this).buildDockerImage(imageName)
=======
def call(String imageName) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t $imageName ."
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker push $imageName"
>>>>>>> 0917cd26b1d16ef8b8bbe7720fa4c86cfcb8de51
    }

