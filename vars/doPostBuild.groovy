def call() {
   
         failure {
             build(
               job: 'failure-build-notification',
               parameters: [
                 [
                   $class: 'StringParameterValue',
                   name: 'FAIL_JOB_NAME',
                   value: "$JOB_NAME",
                ],
                 [
                   $class: 'StringParameterValue',
                   name: 'FAIL_BUILD_URL',
                   value: "$BUILD_URL",
                 ],
                 [
                   $class: 'StringParameterValue',
                   name: 'FAIL_GIT_COMMIT',
                   value: "$GIT_COMMIT",
                 ],
                 [
                   $class: 'StringParameterValue',
                   name: 'FAIL_GIT_URL',
                   value: "${GitURL}",
                 ],
               ]
             )
         } 
}

