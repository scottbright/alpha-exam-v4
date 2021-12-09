# Create REST API with JAVA Spring Boot Practice
## Information
### Exam agreement
- Before begin exam process turn camera around to show surrounding
- Use only one monitor
- Always turn on video and microphone
- Make sure you have stable internet
- Please be in private area that no one else will walk in (or make some noise) during test
- Please dp the test in TDD way.
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
- table name: country
	- id
		- generated value
		- uuid
			- example1: b5ce4b08-34ef-47aa-ad78-d3b5d59e62e2
			- example2: a5d732a7-030a-45e4-b136-f9e11f0a3070
	- name
		- varchar(20)
			- example1: "Brazil"
			- example2: "China"			
	- population
		- varchar(20)
			- example1: "213896253"
			- example2: "146171015"
	- continent
		- varchar(10)
			- example1: "asia"
			- example2: "Asia"
			- example3: "america"
	- average_age
		- varchar(3)
			- example1: "40"
			- example2: "70"
			- example3: "55"			
	- divisor
		- varchar(10)
			- example1: "2.5"
			- example2: "9"
	- created_at
		- generated value
		- timestamp
			- example1: 2021-02-11T15:45:01.123

### Prepared Data in table
![MockedData](https://github.com/scottbright/alpha-exam-rahul/blob/main/image/image2.png?raw=true)

## Tasks

### 1. Create REST API for showing countries related to input continent with insensitive case sorting by population ASC
input
```
GET: localhost:8080/v2/country?continent=asia
```
response  when country(s) found (***the type must be the same as example***)
```
[
    {
        "id": "d0149021-90e9-40c8-8969-85623b2ac9ae",
        "name": "India"
        "population": 1383887228,
        "continent": "asia",
        "averageAge": 40,
        "divisor": 4.999,
        "createdAt": "2021-01-02T00:00:00.123"
    },
    {
        "id": "b5ce4b08-34ef-47aa-ad78-d3b5d59e62e2",
        "name": "China"
        "population": 1400000000,
        "continent": "Asia",
        "averageAge": 50,
        "divisor": 2.5,
        "createdAt": "2021-01-01T00:00:00.000"
    }
]

note: HTTP status 200
note2: createdAt always show 3 digits of milliseconds
```
response when country not found
```
[]

note: HTTP status 200
```

### 2. Create REST API for adding new country
input (***the type must be the same as example***)
```
POST: localhost:8080/v2/country

{
    "name": "Thailand"
    "population": 77000000,
    "continent": "Asia",
    "averageAge": 30,
    "divisor": 9
}
```
response when create successful (***the type must be the same as example***)
```
{
    "id": "10149021-90e9-40c8-8969-85623b2ac999",
    "name": "Thailand"
    "population": 77000000,
    "continent": "Asia",
    "averageAge": 30,
    "divisor": 9,
    "createdAt": "2021-01-02T00:00:00.123"
}

note: HTTP status 201
note2: createdAt always show 3 digits of milliseconds
note3: createdAt is crated time in database
```

### 3. Modify REST API in (1) and (2) to show more field as below response
	1. field name = dividedValue
	2. field value = population ÷ divisor
	3. field decimal = always show 6 digits with rounding mode Floor (1.1234567 will be shown as 1.123456, 1.123 will be shown as 1.123000)
(1)
input
```
GET: localhost:8080/v2/country?continent=asia
```
response  when country(s) found (***the type must be the same as example***)
```
[
    {
        "id": "10149021-90e9-40c8-8969-85623b2ac999",
        "name": "Thailand"
        "population": 77000000,
        "continent": "Asia",
        "averageAge": 30,
        "divisor": 9,
        "createdAt": "2021-01-02T00:00:00.123",
        "dividedValue": 8555555.555555
    },
    {
        "id": "d0149021-90e9-40c8-8969-85623b2ac9ae",
        "name": "India"
        "population": 1383887228,
        "continent": "asia",
        "averageAge": 40,
        "divisor": 4.999,
        "createdAt": "2021-01-02T00:00:00.123",
        "dividedValue": 276832812.162432
    },
    {
        "id": "b5ce4b08-34ef-47aa-ad78-d3b5d59e62e2",
        "name": "China"
        "population": 1400000000,
        "continent": "Asia",
        "averageAge": 50,
        "divisor": 2.5,
        "createdAt": "2021-01-01T00:00:00.000",
        "dividedValue": 560000000.000000
    }
]

```
(2)
```
POST: localhost:8080/v2/country
```
```
{
    "name": "Thailand"
    "population": 77000000,
    "continent": "Asia",
    "averageAge": 30,
    "divisor": 9
}
```
response when create successful (***the type must be the same as example***)
```
{
    "id": "10149021-90e9-40c8-8969-85623b2ac999",
    "name": "Thailand"
    "population": 77000000,
    "continent": "Asia",
    "averageAge": 30,
    "divisor": 9,
    "createdAt": "2021-01-02T00:00:00.123",
    "dividedValue": 560000000.000000
}

note: HTTP status 200
note2: createdAt always show 3 digits of milliseconds
```
### 4. Create Unit Test for service
### 5. Additional Interview Part
