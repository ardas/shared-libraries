def call() {
    sh(
                     script: '''
#!/bin/bash
 if [ $SHA != "master" ]
then
  CHECK=`git branch -r $SHA --contains origin/master`
  if [ -z "$CHECK" ]
  then
      GITDATA=`git name-rev --name-only --exclude=tags/* $SHA`
      DATA=`echo $GITDATA | rev | cut -d"/" -f1  | rev | cut -d"~" -f1 | sed -e 's/[^a-zA-Z0-9]/-/g'`
      EXP=`expr substr $SHA 1 7`
      VCS_REVISION_FULL=`date +"%Y%m%d-%H%M"`-$EXP-$DATA
      VCS_REVISION=`echo $VCS_REVISION_FULL | cut -c -30`
      echo "$VCS_REVISION"
  else
      echo `date +'%Y%m%d-%H%M'`-`git log -n 1 | head -n 1 | sed -e 's/^commit //' | head -c 7`
  fi
else
    echo `date +'%Y%m%d-%H%M'`-`git log -n 1 | head -n 1 | sed -e 's/^commit //' | head -c 7`
fi
                         ''',
                     returnStdout: true
                     )	
}
