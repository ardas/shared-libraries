def call() {
    sh(
                     script: '''
#!/bin/bash
    
echo "--= Looks like git =--"
EXP=`expr substr $SHA 1 7`
VCS_REVISION=`date +"%Y%m%d-%H%M"`-$EXP

if [ "$SHA" != "master" ] && [ "$SHA" != "main" ]; then
   CHECK=`git branch -r --contains $SHA origin/master`
if [ -z "$CHECK" ]; then
   echo "$CHECK not in master"
   echo `git name-rev --name-only --exclude=tags/* $SHA` | rev | cut -d"/" -f1  | rev | cut -d"~" -f1
   GITDATA=`git name-rev --name-only --exclude=tags/* $SHA`
   DATA=`echo $GITDATA | rev | cut -d"/" -f1  | rev | cut -d"~" -f1 | sed -e 's/[^a-zA-Z0-9]/-/g'`
   VCS_REVISION_FULL=`date +"%Y%m%d-%H%M"`-$EXP-$DATA
   VCS_REVISION=`echo $VCS_REVISION_FULL | cut -c -30`
 else
  echo "$CHECK in master"
 fi
 fi	                         
      ''',
                     returnStdout: true
                     )	
}
