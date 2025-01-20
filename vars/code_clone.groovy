def call(String github_credentials, String git_url, String git_branch) {
    git credentialsId: github_credentials, url: git_url, branch: git_branch
    echo "Code clone successful"
}