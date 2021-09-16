def call(Map config = [:]) {
    sh "echo RELEASE_VERSION ${config.release}"
    sh "echo SERVICE NAME ${config.service_name}"
    //sh "mvn clean install docker:build -Ddocker.image.name=esputnik/${config.service_name} -Ddocker.image.tag=${config.release}"
   if ("${config.skipTests}" == "false"){
      sh """
         #mvn clean install -Ddocker.image.tag=${config.release}"-skip-tests -Dmaven.test.skip=true
         echo ${config.release}-skip-tests
      """
   } else {
      sh """
         echo ${config.release}
      """
   }
   

    /* sh (
        script: '''
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
      ''',
          returnStdout: true
    ) */
    
}
