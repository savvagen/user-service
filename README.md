#How to build the project

1. Clone project:

        $ git clone https://github.com/savvagen/user-service.git

        $ cd user-service


2. Create mysql database 

        $ mysql -u root -p 
        $ create database usersdb;
        $ exit;

3. Restore mysql-dump to your local mysql server:

        $ mysql usersdb < usersdb.sql
 
4. Run the project 

        $ cd user-service $$ ./gradlew bootRun

