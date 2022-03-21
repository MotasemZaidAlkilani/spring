# How to run 

1- first u must have database called albums in postgres 

2 - maybe u need to change the "application.propeties" to fit your postgres
like the username and password.

3- run command "./gradlew bootRun" on your terminal

4- enter this url in your browser "http://localhost:8080/albums"


-here my "application.propeties" , to match it with your setting:

server.port=8080
spring.datasource.platform=postgres
spring.datasource.url=jdbc:postgresql://localhost:5432/albums
spring.datasource.username=student
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=create
spring.datasource.initialization-mode=always


