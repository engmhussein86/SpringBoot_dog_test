## Environment
- Java version: 17
- Maven version: 3.*
- Spring Boot version: 3.0.6

## Data
Example of a Dog data JSON object:
```json
{
    "id":1,
    
    "country":"MyCountry",
    
    "active":300000,
    
    "death":100000,

    "recovered": 7000
}
```

## Requirements
In this project, The dog data are provided for many countries with API endpoints for fetching specific information. Note that all the data are virtual.

Following REST Endpoints have been implemented.

`POST` request to `/dog`:
* accepts a dog object without id and returns status code 201
* if the dog object is provided with an id then status code 400 is returned.

`GET` request to `/dog/{id}`:
* returns the dog entry with given id and status code 200
* if the do with none existing id is requested, then status code 404 is returned
* if the dog with invalid id is requested, then status code 400 is returned

* `GET` request to `/dog`:
* returns all the dogs with status code 200
 
There are 6 tests already written and of which a few are failing due to the bug in the implementation of those endpoints. Your task is to find the bug and fix so that all the tests pass.

## Commands
- run: 
```bash
mvn clean spring-boot:run
```
- install: 
```bash
mvn clean install
```
- test: 
```bash
mvn clean test
```