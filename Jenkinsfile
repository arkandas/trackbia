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
        docker ps -aq --filter "name=trackbiafront-prod" | grep -q . && docker stop trackbiafront-prod && docker rm -fv trackbiafront-prod
        docker ps -aq --filter "name=trackbiaback-prod" | grep -q . && docker stop trackbiaback-prod && docker rm -fv trackbiaback-prod
        docker ps -aq --filter "name=trackbia_main-postgres-db-1" | grep -q . && docker stop trackbia_main-postgres-db-1 && docker rm -fv trackbia_main-postgres-db-1
        docker compose -f docker-compose-prod.yaml build
        docker compose -f docker-compose-prod.yaml up -d
        '''
      }
    }
  }
}
