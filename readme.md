# Create REST API with JAVA Spring Boot Practice
## Information
### Exam agreement
- Before begin exam process turn camera around to show surrounding
- Use only one monitor
- Always turn on video and microphone
- Make sure you have stable internet
- Please be in private area that no one else will walk in (or make some noise) during test
- Please do the test in TDD way.
- Searching in Google is allowed. But we will always take note on what you searched.
- Sharing the exam to other people is prohibited

### Pre-requisites
- IntelliJ or any code editor https://www.jetbrains.com/idea/download/ 
- Java 8 https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
- Gradle https://gradle.org/install/ 
- Lombok https://projectlombok.org/download
- (MAC) Docker https://hub.docker.com/editions/community/docker-ce-desktop-mac
- (Windows) Docker https://docs.docker.com/desktop/windows/install/
- Postman https://www.postman.com/downloads/ 
- Github account https://github.com/

### Starting
Create Database using docker-compose that we provided

### Database
We already set connection to Database
- Database: MSSQL
- Account: SA
- Password: yourStrong(!)Password

### Table
- table1 name: electricity_bill
	- id
		- generated value
		- uuid
			- example1: b5ce4b08-34ef-47aa-ad78-d3b5d59e62e2
			- example2: a5d732a7-030a-45e4-b136-f9e11f0a3070
	- name
		- varchar(20)
            - example1: "John"
            - example2: "Adam"	
            - example3: "Mary"
	- billed_at
		- timestamp
			- example1: 2021-01-31T00:00:00.000
			- example2: 2021-02-28T00:00:00.000
			- example3: 2021-03-31T00:00:00.000
	- country
		- varchar(10)
			- example1: "Thailand"
			- example2: "Japan"
			- example3: "Singapore"
	- unit
		- decimal
			- example1: 50.57
			- example2: 40.23
			- example3: 60.00
	- created_at
		- generated value
		- timestamp
			- example1: 2021-01-31T12:00:00.000

- table2 name: cost_per_unit   (all in USD)
	- id
		- generated value
		- uuid
			- example1: b5ce4b08-34ef-47aa-ad78-d3b5d59e62e2
			- example2: a5d732a7-030a-45e4-b136-f9e11f0a3070
	- country
		- varchar(10)
			- example1: "Thailand"
			- example2: "Japan"
			- example3: "Singapore"
	- cost_per_unit
		- decimal
			- example1: 10.00
			- example2: 20.00
			- example3: 30.00
	- created_at
		- generated value
		- timestamp
			- example1: 2021-01-31T12:00:00.000
### Mocked Data in table1
![MockedData](https://github.com/scottbright/alpha-exam-v4/blob/main/image/image1.png?raw=true)

### Mocked Data in table2
![MockedData](https://github.com/scottbright/alpha-exam-v4/blob/main/image/image2.png?raw=true)

## Tasks

### 1. Create REST API for showing sum of electricity bill data with cost calculation when input is name, startdate and enddate
description:
name = name to query
startdate = start period to include billed_at
enddate = end period to include billed_at

input
```
GET: localhost:8080/v2/cost?name=John&startdate=20210101&enddate=20211231
```
response when country, startdate and enddate found (***the type must be the same as example***)
```
{
	"header": {
		"totalUnit": 123,  // sum of all unit in data
		"costPerUnit": 10, // from cost per unit table
		"totalCost": 1230 // multiplication of totalUnit and costPerUnit
	},
	"data": [
		{
			"id",
			"name",
			"billedAt",
			"country",
			"unit",
			"createdAt"
		}
	]
}

note: HTTP status 200
note2: createdAt always show 3 digits of milliseconds
```
response when name not found
```
{} or null

note: HTTP status 200
```