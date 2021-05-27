# shared-libraries


### releaseVersion.groovy

```
use in pipeline after pull from git repo

env.RELEASE_VERSION = releaseVersion().trim()

allowed to get release version as '20210527-1339-8d442b5' (example)
```