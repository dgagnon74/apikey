# Api Key Service
This Micro-Service is an enabling system responsible to manage and provide api keys used by external applications.


## Interface Documentation
API Interface is described using Swagger. Which is available online: 
- Swagger console is available at http://localhost:8081/swagger-ui.html
- Swagger File is available at http://localhost:8081/v2/api-docs

Note: Does not mean we want this in production ... but handy for development and testing in lower level environments  

## Build Instruction
Execute: _mvnw clean package_

## Running the service locally
Execute: `mvnw spring-boot:run`

## Docker Image Instruction
The Dockerfile is included within in the maven project so run:
_docker build -t airgraft-assigment/api-access-service_ .

## Use the service
Please refer to swagger for detail about documentation but has examples 
- you can create a key using curl:
_curl -d '{"clientId":"abc"}' -H "Content-Type: application/json" -X POST http://localhost:8081/api/key/v1_
You will get the following JSON Response:
{"keyId":"77e6010d-7a17-4b4f-8780-0acdab5233eb","active":true}

- Then you can get key detail using
_curl -X GET http://localhost:8081/api/key/v1/77e6010d-7a17-4b4f-8780-0acdab5233eb_
You will get the following JSON Response:
{"keyId":"77e6010d-7a17-4b4f-8780-0acdab5233eb","active":true}

# Development
## tradeoffs/decisions I made during development and their reasoning
This is a simple and basic implementation for this assigment. 
We use an active boolean to deny access to an application/key and rely on service consumer to 
check if the key is active and flush its cached key periodically so that we can deny access in production.
A better implementation would be using a Pub/Sub and sent and event that Consumer Service will listen to.

## Use of postgresql
To get those extra points has described within the assigment