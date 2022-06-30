# Java Connection to MySQL

This is a little project in Apache NetBeans with Java and the driver_mysql. This is part of the clase of Advanced Programming I of the **Technology University of Honduras (UTH)** with the master **Hector Conrado Lanza A**.

First is important to undestand than you have to install MySQL in your computer to test the system here created. You can download the installer [right here.](https://dev.mysql.com/downloads/installer/) Download the version of your operating system and install it.
> I recommend to use a software to check the structure of the DB in a graphic environment. You can download a software like [My SQL Workbench](https://dev.mysql.com/downloads/workbench/). The community version is absolutely for free.

Now, let start to create a system to **connect Java to MySQL**.

## 1. Make sure you have MySQL running on your computer.
_________________
MySQL is a service who has to be running on your local computer to test the system. You can check if this service is running just open a terminal or a console or CMD on Windows and white:

    mysql

Maybe you have to input the **user** and the **password** setting in the installation. If this works so your computer has the service running. 
> If you got another response,[ learn how to start the service in your operating system](https://www.tutorialspoint.com/starting-and-stopping-mysql-server).

If everything was ok, we can continue, to exit of the MySQL environment just write:

    exit()

## 2. Create a Java Project on Apache NetBeans
_____________
I think this is too basic, but I am trying to give the entire information. 

Just remember to create a project of Java with Maven > Java Application > Choose a name, a location, a groupId, version, package and click on Finish button. Easy and for all the family.

## 3. Add the dependencies to the project
________________
When we work with MySQL, we need to add some dependecies to the project to create a succesfully connetion. To add those dependecies just let edit the file __pom.xml__ locatited and the root folder or a Project files if you are in the Project view.

Then add the next text just after the \</version> tag.

    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.29</version>
        </dependency>
    </dependencies>

You can watch the complete file on the repositorie.

When you save the changes, Apache NetBeans will update the dependecies folder with the drivers that we need. The name of the driver is **mysql-connector-java-\<version>.jar** and the other is **protobuf-java-\<version>.jar both of them are need, the first one is the process to help to Java to understand the MySQL information, the second one is the librery to create a process client-server to some URL and Port. 

## 4. Create a Connection file.
____________________
In this repository you can watch the [Connection File](https://github.com/JoseGaldamez/Java-Connect-MySQL/blob/main/src/main/java/datos/Conexion.java) done. Check the comment to understand the reason for every line. 

> I apologize to white the comment in Spanish, but the comment are originally for my classmates who just speak Spanish. Maybe in the future I will change to English.

## 5. Create the model of data
In this case we will work with a simple example. Let's create a table in MySQL name "*clients*" and add the fields of the [Model Class Person](https://github.com/JoseGaldamez/Java-Connect-MySQL/blob/main/src/main/java/domain/Person.java), id, name, last_name, age, email, phone, with the same data type.

This is the kind of objects we will create when the DB return data.

## 5. Create a controller to get data.
_____________________________________
In this step we will call the data from the DB. Check the [Controller File](https://github.com/JoseGaldamez/Java-Connect-MySQL/blob/main/src/main/java/datos/PersonDAO.java) and read the comments to understand every line of code.

In this file you can add every query you want. But make sure the name of the table is ok. Really you can execute every query you wish, but in this example I call a simple **SELECT * FROM clients** 

This example will only work if the table **clients** is already created in the DataBase **test** of your MySQL.

You are allowed to create the table like you want, just make sure to call the information like you created it.

## 6. Finally test the system.
______________________________
To test the connection and the entire system, we need to create a file with the main method to run the Java project. In this case, I created a [Test File](https://github.com/JoseGaldamez/Java-Connect-MySQL/blob/main/src/main/java/test/TestDAO.java) and just call the main method that create an instance of the controller and call the method to get the clients from the DataBase.

> Obviously you have to create some registers on the table to get them with the Select query in the system.

The information will be shown on the console.

________________________________

If you have any question, let's write in the [Issues section](https://github.com/JoseGaldamez/Java-Connect-MySQL/issues) and I will be happy to help you. 

[José Galdamez](https://github.com/JoseGaldamez) at your service.