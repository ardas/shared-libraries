def call() {
   sh(
       script: "git name-rev --name-only HEAD",
       returnStdout: true
 
   )
}
