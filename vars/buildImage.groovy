#!/user/bin/env groovy

<<<<<<< HEAD
import com.example.Docker

def call(String imageName) {
    return new Docker(this).buildDockerImage(imageName)
  }

