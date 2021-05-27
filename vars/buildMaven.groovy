def call(Map config = [:]) {
    sh "echo ${config.release}"
    sh "mvn clean install docker:build -Ddocker.image.name=esputnik/rest-api -Ddocker.image.tag=${config.release}"
    sh "docker tag esputnik/rest-api:${config.release} esputnik/rest-api:${config.release}-no-tested"
    sh "docker push esputnik/rest-api:${config.release}-no-tested"
    
}
