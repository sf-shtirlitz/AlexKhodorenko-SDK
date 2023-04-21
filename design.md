<h1 align="center"> Lord of the rings API sample... <br />
The Lord Of The Rings API</h1>


<!-- PROJECT SHIELDS -->
<div align="center">

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]

</div>

<!-- MAIN BODY / DESCRIPTION -->
<p align="center">
    This repository holds the code base of <i>Lord of the rings API sample</i>, the Lord of the Rings API, which provides you with movie; and quotes JSON data.
    <br />
    <a href="https://the-one-api.dev"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/gitfrosh/lotr-api/issues">Report Bug</a>
    ·
    <a href="https://github.com/gitfrosh/lotr-api/issues">Request Feature</a>
</p>
<br />
<br />
<p align="center">
  <b>Built with</b> :heart: and some awesome technologies (amongst others!)
</p>

<div align="center">

[![MySQL][mysql.com]][MySQL-url]

</div>
___

<!-- ACKNOWLEDGEMENTS -->
## Steps to run, API description, SDK description - **all applicable to PC/Windows 11**

* The project is based and outlines the Spring Boot microservices architecture with one functional (movie) service:
  * Project contains the following modules:
    1. Registry service
    2. Config service (optional if you configure datasource in application.properties file in Movie service)
    3. Gateway service (optional)
    4. Movie service
    5. MovieAPI with Main class and main method to run to test the API - the original main task 
  * The project makes use of config service repository located here: https://github.com/sf-shtirlitz/config-server-repo-moviesdk to connect ot the MySQL DB
  * In order to run the lotr-movie-service module you need to run MySQL DB either locally (install MySQL as service) or in docker (deploy-mysql.sh file to run in bash is provided) or in cloud (AWS) and adjust the configuration in the .properties file
  * The notes on starting modules - after cloning the repository on your local drive:
    1. Registry service
    2. Config service
    3. Gateway service
    4. Movie service - after you've adjusted the config to point to your MySQL db and created the "movie_db" schema. The module will run and create the table "movies"
    5. Please refer to MovieController class for available API methods.
    6. The endpoints using Gateway-api: localhost:9191/movie/***
    7. The endpoints without running using Gateway-api: localhost:8081/movie/***
    8. Once the API is functional and is running on localhost:9191 (or 8081) you can run Main method of MovieAPI module in class: Main. It will return the list of movies as JSON string, Movie with id=1 and quote for movie with Id=1
    9. Fill up the table movies with the LOTR movie names and quotes either using API with postman: sending POST request: localhost:9191/movie with body like:
       {
       "movieName": "LOTR1",
       "movieQuote": "Quote1"
       }
      Or use the sql query to pre-fill the movies table with the values. Sql query is provided in the file: MySQL-movies-table.sql
    10. At this point you should have Movie service running, movies table pre-filled.
    11. Now you can run MovieAPI test with a command: "C:\Program Files\Java\jdk-17\bin\java.exe" -cp MovieAPI-1.0-SNAPSHOT.jar aksdk.movieapi.Main 
<!--
* []()
* []()
-->
<p align="right">(<a href="README.md#-the-one-api-to-rule-them-all-the-lord-of-the-rings-api">back to top</a>)</p>
