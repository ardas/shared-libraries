def call(Map config = [:]) {
    sh "echo RELEASE_VERSION ${config.release}"
    sh "echo SERVICE NAME ${config.service_name}"
    sh "mvn clean install docker:build -Ddocker.image.name=esputnik/${config.service_name} -Ddocker.image.tag=${config.release}"
    sh "docker tag esputnik/${config.service_name}:${config.release} esputnik/${config.service_name}:${config.release}-no-tested"
    sh "docker push esputnik/${config.service_name}:${config.release}-no-tested"
    
}
