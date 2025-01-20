def call(String image_name, String tag) {
        withCredentials([usernamePassword(
                    credentialsId:"dockerhub_credentials",
                    usernameVariable:"dockerHubUser", 
                    passwordVariable:"dockerHubPass")]){
                        push_to_dockerhub("dockerHubUser", "dockerHubPass", 'simple-flask-app', 'v2')
        sh "docker login -u $dockerHubUser -p $dockerHubPass"
        sh "docker image tag $image_name:$tag $dockerHubUser/$image_name:$tag"
        sh "docker push $dockerHubUser/$image_name:$tag"
        echo "pushed image to docker hub"
        
        }
        
}