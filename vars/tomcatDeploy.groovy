def call(tomcatIP, warFileName, tomcatUserName, credID){
  sshagent([credID]){
    sh "scp target/${warFileName} tomcatUserName@tomcatIP:/opt/tomcat9/webapps/"
    sh "ssh tomcatUserName@tomcatIP /opt/tomcat9/bin/shutdown.sh"
    sh "ssh tomcatUserName@tomcatIP /opt/tomcat9/bin/startup.sh"
  }
}
