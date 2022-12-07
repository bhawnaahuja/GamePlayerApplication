Game Player Application

The goal of this project is to create  directory of players, their geography, which games they play and the
level(INVINCIBLE, PRO, N00B) they are at in that game.



Technologies Used:

Swagger 2.6.1
Spring Boot 2.4.0
Spring Data
H2 Database
How to run?
Compile the project with the following command:

mvn clean install

To run the SpringBoot Application:

mvn spring-boot:run

Swagger URL

http://localhost:8080/swagger-ui.html

H2 Database/In-Memory Database

Go to: http://localhost:8080/contacts/h2-console
Setting the following parameters:
Driver class : org.h2.Driver
JDBC URL     : jdbc:h2:mem:test
User Name    : sa
Password     :
Click on Test Connection button, this should return Test successful
Click on Connect button.
Following Tables are created:
1.GAMES
2.PLAYERS
3.GAME_PLAYER

The Tables Games and Players are loaded with initial data.

