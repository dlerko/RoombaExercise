# RoombaExercise
## Introduced maven support.
### Please ensure that you have maven installed by typing mvn --version in the terminal.

## Install & run
1. Clone repository with: git clone https://github.com/dlerko/RoombaExercise.git
2. Run mvn clean verify
3. Run mvn spring-boot:run
4. Endpoint is available at http://localhost:8080/cleanroom
5. Test with curl:
curl -H "Content-Type: application/json" -X POST -d "{\"roomSize\" : [5, 5],\"coords\" : [1, 2],\"patches\" : [[1, 0],[2, 2],[2, 3]],\"instructions\" : \"NNESEESWNWWSE\"}" http://localhost:8080/cleanroom
6. Run localhost instance of mongodb
7. Uncomment com.pleasecompile.service.RoomblaRequestController.cleanRoom(RoomblaRequest) line 29 & line 37 to enable persistence.

##Implementation
What has been done:
###Algorithm brainstorming
http://pleasecompile.com/uncategorized/exercise-to-calculate-roombla-robot-path-and-collected-trash-algorithm/ (last option was chosen for implementation)
###AWS Lambda
Service was executed (without persistence) on AWS Lambda serverless service. More on it: http://pleasecompile.com/uncategorized/aws-lambda-with-java-8-wrapped-into-restful-api/ (final output is not of the expected form, but yields results inline with excercise criteria).
You can try Lambda service at: https://xr0bzw8bk1.execute-api.eu-west-1.amazonaws.com/prod/cleanroom
Using curl: curl -H “Content-Type: application/json” -X POST -d “{\”roomSize\” : [5, 5],\”coords\” : [1, 2],\”patches\” : [[1, 0],[2, 2],[2, 3]],\”instructions\” : \”NNESEESWNWW\”}” https://xr0bzw8bk1.execute-api.eu-west-1.amazonaws.com/prod/cleanroom

##Solution
* Using gradle as dependency management and build tool.
* Using strategy pattern to separate algorithm implementation.
* Has Jackson serialisation/deserialisation on key objects.
* Using spring boot and as rapid development framework.

##TODO
* Implement input validation
* Provide valid HTTP response codes e.g. invalid input
* Defensive checks in serialisation/deserialisation
* Json field names would be best standartetised within a single Enum, instead of maintaing as a strings
