def call() {
     sh """
         docker pull quay.io/testcontainers/ryuk:0.2.2
         docker pull quay.io/testcontainers/ryuk:0.2.3
         docker pull testcontainersofficial/ryuk:0.3.0
         docker pull alpine:3.5
     """
 
}
