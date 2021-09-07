def call() {
    sh(
                     script: '''
#!/bin/bash
    
echo "--= Looks like git =--"
VCS_REVISION=`date +"%Y%m%d-%H%M"`-`expr substr $GIT_COMMIT 1 7`
if [ "$SHA" != "master" ] && [ "$SHA" != "main" ]; then
   CHECK=`git branch -r --contains $SHA origin/master`
if [ -z "$CHECK" ]; then
   echo "$CHECK not in master"
   echo `git name-rev --name-only --exclude=tags/* $SHA` | rev | cut -d"/" -f1  | rev | cut -d"~" -f1
   GITDATA=`git name-rev --name-only --exclude=tags/* $SHA`
   DATA=`echo $GITDATA | rev | cut -d"/" -f1  | rev | cut -d"~" -f1 | sed -e 's/[^a-zA-Z0-9]/-/g'`
   VCS_REVISION_FULL=`date +"%Y%m%d-%H%M"`-`expr substr $GIT_COMMIT 1 7`-$DATA
   VCS_REVISION=`echo $VCS_REVISION_FULL | cut -c -30`
 else
  echo "$CHECK in master"
 fi
 fi	                         
      ''',
                     returnStdout: true
                     )	
}
