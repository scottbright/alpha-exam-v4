#Create REST API with JAVA Spring Boot Practice
## Information
### Pre-requisites
- IntelliJ or any code editor https://www.jetbrains.com/idea/download/ 
- Java 8 https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
- Gradle https://gradle.org/install/ 
- Lombok https://projectlombok.org/download
- Docker https://hub.docker.com/editions/community/docker-ce-desktop-mac

### Table
- table name: product
	- id
		- generated value
		- uuid
			- example1: b5ce4b08-34ef-47aa-ad78-d3b5d59e62e2
			- example2: a5d732a7-030a-45e4-b136-f9e11f0a3070
	- price
		- varchar(20)
			- example1: 11.111111
			- example2: 10
	- continent
		- varchar(10)
			- example1: asia
			- example2: europe
			- example3: america
	- multiplier
		- varchar(10)
			- example1: 2.5
			- example2: 88.888888
	- created_at
		- generated value
		- timestamp
			- example1: 2021-02-11T15:45:01.123

### Mocked Data in table
![MockedData](https://github.com/scottbright/alpha-exam/blob/main/image/image.png?raw=true)

## Tasks

1. Create REST API for showing products related to input continent 
input
```
GET: localhost:8080/v1/product?continent=asia
```
response  when product(s) found (***the type must be the same as example***)
```
[
    {
        "id": "02d31878-829e-4c49-ac88-9894bbcdc67c",
        "price": 123.4567,
        "continent": "new",
        "multiplier": 10.0,
        "createdAt": "2021-02-10T18:30:30.137"
    },
    {
        "id": "19fdd65f-5e64-4163-b9d5-9c4b20d4898e",
        "price": 123.4567,
        "continent": "new",
        "multiplier": 10,
        "createdAt": "2021-02-10T18:30:51.297"
    }
]

note: HTTP status 200
```
response when product not found
```
[]

note: HTTP status 200
```

2. Create REST API for adding new product
input (***the type must be the same as example***)
```
POST: localhost:8080/v1/product

{
    "price": 123.4567,
    "continent": "new",
    "multiplier": 10
}
```
response when create successful (***the type must be the same as example***)
```
{
    "id": "ed2ae6f0-deba-4007-8e02-f46f4a7e388f",
    "price": 123.4567,
    "continent": "new",
    "multiplier": 10,
    "createdAt": "2021-02-10T18:33:37.394"
}

note: HTTP status 201
```

3. Modify REST API in (1) and (2) to show more field as below response
	1. field name = multipliedValue
	2. field value = price * multiplier
	3. field decimal = 6 with rounding mode Floor (1.1234567 will be shown as 1.123456, 1.123 will be shown as 1.123000)
input
```
GET: localhost:8080/v1/product?continent=asia
```
response  when product(s) found (***the type must be the same as example***)
```
[
    {
        "id": "5c65721f-c21b-824f-add3-4539a3be815b",
        "price": 555.123,
        "continent": "asia",
        "multiplier": 4,
        "createdAt": "2021-01-03T00:00:00.123",
        "multipliedValue": 2220.492000
    },
    {
        "id": "7af60e83-0882-8b4a-84ff-80cec174e9a4",
        "price": 10,
        "continent": "asia",
        "multiplier": 20,
        "createdAt": "2021-01-06T00:00:00.123",
        "multipliedValue": 200.000000
    },
    {
        "id": "219014d0-e990-c840-8969-85623b2ac9ae",
        "price": 1234,
        "continent": "asia",
        "multiplier": 4.999,
        "createdAt": "2021-01-02T00:00:00.123",
        "multipliedValue": 6168.766000
    },
    {
        "id": "1457d165-c2fd-ff45-97c6-9b23b155e50d",
        "price": 9999.999999,
        "continent": "asia",
        "multiplier": 555.555555,
        "createdAt": "2021-01-05T00:00:00.123",
        "multipliedValue": 5555555.549444
    },
    {
        "id": "084bceb5-ef34-aa47-ad78-d3b5d59e62e2",
        "price": 11.111111,
        "continent": "asia",
        "multiplier": 2.5,
        "createdAt": "2021-01-01T00:00:00",
        "multipliedValue": 27.777777
    },
    {
        "id": "5c405847-f1e5-274b-bd5b-d9df7db36bc3",
        "price": 456.123456,
        "continent": "asia",
        "multiplier": 4.123456,
        "createdAt": "2021-01-04T00:00:00.123",
        "multipliedValue": 1880.805001
    }
]

note: HTTP status 200
```
4. Please list on how can we improve the code? db, controller, etc. 
	1. example: add validation