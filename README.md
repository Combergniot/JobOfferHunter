# JobOfferHunter

JobOfferHunter - scraps detailed job vacancies data from job-portals and save them in your SQL database

#Before you start
You need relational database (e.g. MySql, Postres) and Apache Tomcat server.

1.Set up correct data in application.properties file - specification of access to the database ("spring.datasource"). 
Optionally you can change number for server port. The view is set to localhost: 8094.

2. To download data from you should change the settings in the DataCollectorSetting abstract class. 
Set up PROXY_HOST and PROX_PORT or remove proxy line in connectWith() method.
