# DPolls API

This is a simple api for fetching user polls. Choice of technologies is based on simplicity of creating such project for demonstration purposes.

  - MongoDB - it gives us flexibility and ease of importing existing json to db
  - Java Srping Boot - it gives us ease of configuration and connectivity
  
Everything was kept as simple as possible to stay within time limits. In other circumstances more time should be spent analyzing data model and modeling the database, but this depends also on other requirements in the project. Also, test coverage, exception handling and use of abstracions could be improved.

# How to run

  - Build the Java project
  - Run containers with docker-compose
  - Initiate the database with data
  - Call API endpoint

# Building Java project
We need this to get executable jar
```
mvn clean package
```
# Run containers
This will run mongodb and java api service containers
```
docker-compose up -d
```
# Initiate the database with data
This will populate data with json from polls.json file. If you want to update data just replace this json file with fresh data and initiate again. 
```
database/init-db.sh
```

# Call API endpoint
Sample cURL request
```
curl -X POST \
  http://localhost:8080/polls \
  -H 'Accept: application/json' \
  -H 'Content-Length: 53' \
  -H 'Content-Type: application/json' \
  -H 'Host: localhost:8080' \
  -d '{"searchTerm": "John Doe", "afterDate":"2017-01-26", "beforeDate":"2020-01-26"}'
```
