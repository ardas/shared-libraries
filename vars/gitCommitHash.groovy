def call() {
  sh(
       script: "git log -n 1 | head -n 1 | sed -e 's/^commit //'",
       returnStdout: true
    )
}
