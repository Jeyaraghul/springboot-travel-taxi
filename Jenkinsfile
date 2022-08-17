node {
    
    def dockerImageTag = "springboot-deploy${env.BUILD_NUMBER}"

    try{

        stage('Clone Repo') {
            git url: 'https://github.com/Jeyaraghul/springboot-travel-taxi.git',
                credentialsId: 'Raghul1',
                branch: 'master'
        }

        stage('Build docker') {
            dockerImage = docker.build("springboot-deploy:${env.BUILD_NUMBER}")
        }

        stage('Deploy docker') {
            echo "Docker Image Tag Name: ${dockerImageTag}"

            sh "docker stop springboot-deploy || true && docker rm springboot-deploy || true"

            sh "docker run --name springboot-deploy -d -p 8081:8080 springboot-deploy:${env.BUILD_NUMBER}"
        }

    }catch(e){
        throw e
    }
}
