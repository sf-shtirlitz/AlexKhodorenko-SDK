#!/bin/bash

# Pull the latest MySQL image from Docker Hub
docker pull mysql:latest

# Start a new Docker container named "movie_db" with MySQL and port forwarding
docker run --name mysql_container -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=movie_db -p 3306:3306 -d mysql

# Wait for the container to start up
sleep 10

# Connect to the MySQL server inside the container
#docker exec -it mysql_container mysql -uroot -ppassword -e "USE movie_db; CREATE TABLE movies (id INT NOT NULL AUTO_INCREMENT, movie_name VARCHAR(255), movie_quote VARCHAR(255), PRIMARY KEY (id));"

# Confirm that the table has been created
#docker exec -it mysql_container mysql -uroot -ppassword -e "USE movie_db; SHOW TABLES;"

echo "MySQL is now running inside a Docker container named movie_db with a table named movies and port forwarding to localhost."