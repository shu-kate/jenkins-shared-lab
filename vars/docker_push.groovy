def call(String Project, String ImageTag, String dockerhubuser) {
  withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
    sh "docker login -u ${dockerhubuser} -p ${dockerHubPass}"
    sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
  }
}
