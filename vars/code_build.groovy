def call(String image_name, String tag) {
    sh "docker build -t $image_name:$tag ."
    echo 'code built'
}