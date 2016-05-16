# RoombaExercise
1. Download repository
2. . gradlew build
3. java -jar build/libs/lambda-roombla-1.0-SNAPSHOT.jar
4. Endpoint is available at http://localhost:8080/cleanroom
5. Test with curl:
curl -H "Content-Type: application/json" -X POST -d "{\"roomSize\" : [5, 5],\"coords\" : [1, 2],\"patches\" : [[1, 0],[2, 2],[2, 3]],\"instructions\" : \"NNESEESWNWWSE\"}" http://localhost:8080/cleanroom
