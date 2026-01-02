def call() {
    withCredentials([usernamePassword(
        credentialsId: 'docker-hub-repo',
        usernameVariable: 'USER',
        passwordVariable: 'PASS'
    )]) {
        sh '''
          echo "$PASS" | docker login -u "$USER" --password-stdin
        '''
    }
}

