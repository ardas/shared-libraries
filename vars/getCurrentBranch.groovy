def call() {
   sh(
       script: "git rev-parse --abbrev-ref HEAD",
       returnStdout: true
 
   )
}
