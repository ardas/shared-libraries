# shared-libraries


### releaseVersion.groovy

```
use in pipeline after pull from git repo

env.RELEASE_VERSION = releaseVersion().trim()

allowed to get release version as '20210527-1339-8d442b5' (example)
```

### buildMaven.groovy

```
use in pipeline like in example below

buildMaven(release:"${env.RELEASE_VERSION}",service_name:"rest-api")

```
make build with maven and push images into docker hub
```
    sh "mvn clean install docker:build -Ddocker.image.name=esputnik/${config.service_name} -Ddocker.image.tag=${config.release}"
    sh "docker tag esputnik/${config.service_name}:${config.release} esputnik/${config.service_name}:${config.release}-no-tested"
    sh "docker push esputnik/${config.service_name}:${config.release}-no-tested"
```