def call(Map config = [:]) {
    sh "echo RELEASE_VERSION ${config.release}"
    sh "echo SERVICE NAME ${config.service_name}"
    //sh "mvn clean install docker:build -Ddocker.image.name=esputnik/${config.service_name} -Ddocker.image.tag=${config.release}"
    sh """
        #!/bin/bash

        if [ ${config.skipTests} = "false" ]; then
           SKIP="-Dmaven.test.skip=true"
           VCS_REVISION=${config.release}-"skip-tests"
           echo "Test skipped"
        else
           VCS_REVISION=${config.release}
        fi

        echo $VCS_REVISION

        #mvn clean install -Ddocker.image.tag=$VCS_REVISION -DskipTests=$SKIP
        #docker tag esputnik/${config.service_name}:${config.release} esputnik/${config.service_name}:${config.release}-no-tested
        #docker push esputnik/${config.service_name}:${config.release}-no-tested
      """
    
}
