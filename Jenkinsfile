pipeline {
  agent any
  environment {
    HOME = '.'
  }
  stages {
    stage("run") {
      steps {
        sh '''
        which docker
        docker compose -f docker-compose-prod.yaml down
        docker compose -f docker-compose-prod.yaml build
        docker compose -f docker-compose-prod.yaml up -d
        '''
      }
    }
  }
}
