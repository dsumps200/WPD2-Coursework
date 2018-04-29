# WPD2-Coursework

## Milestone Planner

This is an application that allows a user to browse, create, edit and delete milestones if they are authorized to do so. Milestones can be created and saved, and then retrieved at a later date.

##Requirements

To run, you need: [Java 8][2], [Maven][3] and an appropriate IDE such as Intellij.

##Get started
To run the app, you must have Maven installed. If so, and if Maven has added to the OS's PATH variable, you can run the application with the <code>mvn</code> command in the directory with the application's pom.xml file (this should be the root directory).

Once Maven is installed and on the PATH, simply type
    'mvn clean package exec:java'
    
The first time you do this may be time-consuming, because Maven will need to do the initial install of any dependencies that the application has. Future runs will be quicker.

If successful, open a web browser and navigate to `http://localhost:8000` to see the homepage.


[2]:http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[3]:https://maven.apache.org/download.cgi