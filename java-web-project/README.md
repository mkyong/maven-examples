# Maven - How to create a Java web application project
Project Link - http://www.mkyong.com/maven/how-to-create-a-web-application-project-with-maven/

Maven 3, Spring 5 MVC, JUnit 5, Logback and Jetty.

## How to run this web project?

### Test it with Jetty web server.
'''
$ git clone https://github.com/mkyong/maven-examples.git
$ cd java-web-project 
$ mvn jetty:run
'''
Access http://localhost:8080


### Create a WAR file for deployment :
'''
$ git clone https://github.com/mkyong/maven-examples.git
$ cd java-web-project 
$ mvn package or mvn war:war
'''
A WAR is generated at 'target/finalName'
