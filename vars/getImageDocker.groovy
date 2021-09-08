def call() {
    node {

        def registryCredentials1 = ""
        def protocol = "https://"
        def registryURL1 = "quay.io/repository"
        def registryURL2 = "testcontainersofficial"

        environment{
        sourceImageName1 = 'testcontainers/ryuk'
        sourceImageTag1 = '0.2.2'
        sourceImageName2 = 'testcontainers/ryuk'
        sourceImageTag2 = '0.2.3'
        sourceImageName3 = 'ryuk'
        sourceImageTag3 = '0.3.0'
        sourceImageName4 = 'alpine'
        sourceImageTag4 = '3.5'
       }
           
        stage('Pull source-image from quay.io') {
            steps {
                script {
                    //pull source-image from registry 1
                    docker.withRegistry(protocol + registryURL1, registryCredentials1) {
                        docker.image("${env.sourceImageName1}:${env.sourceImageTag1}").pull()
                    }
                }
                script {
                    //pull source-image from registry 1
                    docker.withRegistry(protocol + registryURL1, registryCredentials1) {
                        docker.image("${env.sourceImageName2}:${env.sourceImageTag2}").pull()
                    }
                }
                script {
                    //pull source-image from registry 2
                    docker.withRegistry(protocol + registryURL2, registryCredentials1) {
                        docker.image("${env.sourceImageName3}:${env.sourceImageTag3}").pull()
                    }
                }
                script {
                    //pull alpine
                    //docker.withRegistry(protocol + registryURL2, registryCredentials1) {
                        docker.image("${env.sourceImageName4}:${env.sourceImageTag4}").pull()
                    //}
                }
                
            }
        }
    }
}
