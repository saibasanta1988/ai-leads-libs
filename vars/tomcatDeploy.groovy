def call(tomcatIP, warFileName, tomcatUserName, credID){
  sshagent(['tomcat-dev']){
    sh "scp target/${warFileName} tomcatUserName@tomcatIP:/opt/tomcat9/webapps/"
    sh "ssh tomcatUserName@tomcatIP /opt/tomcat9/bin/shutdown.sh"
    sh "ssh tomcatUserName@tomcatIP /opt/tomcat9/bin/startup.sh"
  }
}
