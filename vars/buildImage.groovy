def call(String imageName) {
    // Baut das Docker-Image
    sh "docker build -t ${imageName} ."
}


