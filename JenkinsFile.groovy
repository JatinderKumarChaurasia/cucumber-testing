echo 'hello jenkins'

void clone_repo() {
    println("cloning repo")
    checkout([$class           : 'GitSCM',
              branches         : [[name: '*/master']],
              userRemoteConfigs: [[url: 'https://github.com/jenkinsci/git-plugin.git']]])
}

pipeline{
    agent any
    tools {git "git"}

    stages {
        stage ('build'){
            steps{
                sh 'gradle --version'
                sh 'git --version'
                clone_repo()
            }
        }
    }
}
