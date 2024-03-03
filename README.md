# simple-user-mgmt
Just an example application to play with spring-boot, spring-jpa, spring-security etc. Its not meant to be actually used.

## Prerequisites
Have a postgres DB running and listening on **port 5432**, have a db called **exam_db** in it owned by a user with name **examuser** and password **secretpass**.

## Setup for development
From the root of the project, run ```mvn clean install``` to compile the and  ```java -jar target/simple-user-mgmt-0.0.1-SNAPSHOT.jar``` to run the application.

Once running, it will listen on ```http://localhost:8080/```

## Usage
### Unsecured REST endpoints
Load the list of users: ```curl -X GET -i http://localhost:8080/users```. Please note that the API will never return the user password.

Get one particular user: ```curl -X GET -i http://localhost:8080/users/<user id>```

Create a new user: ```curl -X POST -i http://localhost:8080/users -H "Content-Type: application/json" -d '{"name":"John Smith","username":"myusername","password":"mypassword"}'```

Edit a user: ```curl -X PUT -i http://localhost:8080/users/<user id> -H "Content-Type: application/json" -d '{"name":"John Smith the Second","username":"myusername","password":"mypassword"}'```

Delete a user: This is on a different endpoint and requires authentication. By default, a few users are created in the DB you can use. For example: ```curl -X DELETE -i http://localhost:8080/users-protected/<user id> -u "un1:p1"```

## UI
The UI is very spartian. There is only one page with some functionality, to delete a user. Its on ```http://localhost:8080/protected-users-page```. It requires authentication.
