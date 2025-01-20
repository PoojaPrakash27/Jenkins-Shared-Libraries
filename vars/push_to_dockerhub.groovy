def call(String dockerHubUser, String dockerHubPass, String image_name, String tag) {
        sh "docker login -u $dockerHubUser -p $dockerHubPass"
        sh "docker image tag $image_name:$tag $dockerHubUser/$image_name:$tag"
        sh "docker push $dockerHubUser/$image_name:$tag"
        echo "pushed image to docker hub"
}