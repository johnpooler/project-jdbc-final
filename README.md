Inventory Management System


Getting Started
Inventory management system that has the functionality to read/add/delete/update the following customers/items and orders using MySQL,GCP(Google Cloud Platform),Jenkins and Github, Sonarqube, Nexus, Junit, Maven among other softwares and plugins.
##Prequisites FOR USAGE PURPOSES
```
In order to use this software you need to install the following
-Eclipse - (https://www3.ntu.edu.sg/home/ehchua/programming/howto/EclipseJava_HowTo.html)
-Java - (https://www3.ntu.edu.sg/home/ehchua/programming/howto/EclipseJava_HowTo.html)
-GCP(Google cloud platform)-(https://cloud.google.com/sql/docs/mysql/quickstart)
-MySQL-(https://dev.mysql.com/doc/mysql-installation-excerpt/8.0/en/windows-install-archive.html
-Maven-(https://howtodoinjava.com/maven/how-to-install-maven-on-windows/
-Git-(https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
```
```
Once everything is set up and ready, to run/use the Application you can do the following
1.	You can initiate a git pull request from the following github repo URL: https://github.com/Alimahad199/firstproject1/edit/test-branch/ 2)Use Eclipse to open the program
2.	Create a MySQL database 4)Run the Application to add update delete and read customers and items from your database.
```
##FOR CREATION PURPOSES-
```
To get you started you should do the following in addition to the above installation; -Ensure that when java is being installed you download both jdk and jre (mainly jdk).
-After downloading eclipse you should then install maven ensuring that it is added to your path file.
-Download MySQL workbench.
-Create a GCP Instance and use the ip address to connect to your database(MySQL).
-Add relevant plugins(mysql connecter,apache.maven,mockito,Junit..etc).
-Ensure that you connect your workspace to your database (via mysql connector plugin).
-Test the connection between your workspace and database by inserting data and querying data.
-Ensure that all relevant JDBC drivers are installed and contain your database name and GCP instance ip address.
```
###Unit Testing
```
Junit is the open source framework that is used to test each unit of code within each class.The main aim of this is to analyse whether the unit of code is "fit for purpose".To run such a test a Junit plugin is downloaded from https://mvnrepository.com/artifact/junit/junit.A test class will then be needed to test whatever method you require this can be seen further in--> https://courses.cs.washington.edu/courses/cse143/11wi/eclipse-tutorial/junit.shtml <--
```
Versioning We use SemVer for versioning.
##Authors
* **Christopher Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **John Pooler** - *Main body of work*- 
## License
This project is licensed under the MIT license - see the LICENSE.md file for details
Apache License, Version 2.0 (LICENSE-APACHE or http://www.apache.org/licenses/LICENSE-2.0)



##Acknowledgments
QA Software dev January intake 
Chris Perrins helped me greatly, along with code reference from https://github.com/christophperrins/ims-demo.
