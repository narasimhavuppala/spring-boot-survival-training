# spring-boot-survival-training

# Softwares Required
  - [Java 17](https://www.oracle.com/java/technologies/downloads/#java17)
  - [Intellij  IDE (Integrated Development Environment)](https://www.jetbrains.com/idea/download/#section=windows)
  - [Docker Desktop](https://www.docker.com/products/docker-desktop/)
  - [Maven Build tool](https://maven.apache.org/download.cgi)
  - [PostMan for Rest API Testing](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en)
  - [Git Bash](https://git-scm.com/downloads)
  - [Tortoise Git](https://tortoisegit.org/)
  - [Database Client](https://dbeaver.io/)
# Steps to Build this project
   ```
   mvn clean spring-boot:run
   
   ```
# Code coverage command
   ```
      mvn clean test
   ```

# Run these Docker images before start of project  
```

docker compose up -f docker-compose.yml
docker run -p 6379:6379 redis 
```
# Rest Endpoints
- Add below Dependency

  	<dependency>
  		<groupId>org.springframework.boot</groupId>
  		<artifactId>spring-boot-starter-web</artifactId>
  	</dependency>

- HTTP Methods
    - GET
      - Path Parameter
      - Request Parameter
    - PUT 
      - Request Body
    - POST 
      - Request Body
    - DELETE
    - HTTP Status codes
      - 200 Series
      - 400 Series
      - 500 Series
    - Media Types : JSON , XML 
        - Produces
        - Consumes

#  ORM Integration(hibernate to Mysql/Oracle/Postgres/MS SQL/H2)
- Add below Dependency and Driver

  	<dependency>
  		<groupId>org.springframework.boot</groupId>
  		<artifactId>spring-boot-starter-data-jpa</artifactId>
  	</dependency>
- Create a model with below Annotations
    - @Entity
    - @Id
- Create a Repository

  	@Repository
  	public interface StudentRepository extends JpaRepository<Student, Integer> {
  	//Code Generation Technique: DSL 
  	}

# Swagger ::: https://springdoc.org/
-   Add dependencies in pom.xml
-	Add openDoc Depdency

     <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-ui</artifactId>
        <version>1.6.13</version>
     </dependency>

-   Add @ Bean for DocketAPI
  -
      @Bean
  public OpenAPI customOpenAPI() {
  return new OpenAPI()
  .components(new Components())
  .info(new Info().title("Training Demo  Application API").description(
  "This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3."));
  }
-	open url :http://localhost:port/context-path/swagger-ui.html


# Datasource creation
- @ Bean for Programatic Data Source
- Embedded will be created if you add depedency

  	<dependency>
  		<groupId>com.h2database</groupId>
  		<artifactId>h2</artifactId>
  		<scope>runtime</scope>
  	</dependency>
- Connection Pooling
- use for Hikari:  spring.datasource.type=com.zaxxer.hikari.HikariDataSource
- use the below config for Datasource

  	spring:
  	  datasource:
  		url: jdbc:mysql://localhost:3306/mysql
  		username: root
  		password: root
  		driver-class-name: com.mysql.cj.jdbc.Driver


#  Log level Details
- debug=false
- logging.file=application.log
- logging.level.org.springframework=INFO
- logging.level.org.org.hibernate=WARN


#   Actuator Endpoints
- Add below Dependency in the pom.xml

  	<dependency>
  		<groupId>org.springframework.boot</groupId>
  		<artifactId>spring-boot-starter-actuator</artifactId>
  	</dependency>		
- By default all actuator endpoints can be seen :
  "http://serveropaddress:port/context-path/actuator"
- By default Endpoints are disabled due to Secure data
- enable all endpoints by : management.endpoints.web.exposure.include: "*"
- Shutdown endpoint needs to be enabled. This will not be covered in all(*)



# Spring Annotations
- @Component
- @RestController
- @RequestMapping
- @Service
- @Repository
- @SpringBootApplication
- @Bean
- @Autowired
- @Query
- @Transactional
# Dev tools
- HMR(Hot Module Replacement)

  	<dependency>
  		<groupId>org.springframework.boot</groupId>
  		<artifactId>spring-boot-devtools</artifactId>
  		<scope>runtime</scope>
  	</dependency>
- Ensures Restart of Project upon save
- It does not detect the pom.xml changes
# YAML Usage
- Spring profiles active
- Server port
- Conext path : Different Application name
- usage of tab

# Reading Properties Files inside the program
- for Multiple Properties

  	@Autowired
  	Environment env; 
- for single property

  	@Value("property.name)

# Bean Validation
- use @ Valid wherever it needs to be validated
- @NotNull
- @Email
- @Min
- @Max
- @Size
- @Past/@Future
- @Negative/@Positive
# Oracle Database connectivtity

- download JAR freom below:

  https://www.oracle.com/technetwork/apps-tech/jdbc-112010-090769.html

- Install to local repo:

  mvn install:install-file -Dfile=ojdbc6.jar  -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=12.1.0.1 -Dpackaging=jar
- Add pom dependency

  	<dependency>
            <groupId>com.oracle</groupId>
            <artifactId>ojdbc6</artifactId>
            <version>12.1.0.1</version>
        </dependency>
- create a user and give privilages

  	CREATE USER crud IDENTIFIED BY crud;

  	GRANT CONNECT TO crud;

  	GRANT CONNECT, RESOURCE, DBA TO crud;

  	GRANT CREATE SESSION TO crud;


  	GRANT UNLIMITED TABLESPACE TO crud;


- CREATE SEQUENCE student_seq
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 4
  INCREMENT BY 1;

# MongoDB Integration
- Add below dependency in pom.xml

  	<dependency>
  			<groupId>org.springframework.boot</groupId>
  			<artifactId>spring-boot-starter-data-mongodb</artifactId>
  	</dependency>
- mention connection details in .yml file or(application.properties)

  	spring:
  	  data:
  		mongodb:
  		  host: localhost
  		  port: 27017
  		  database: courses
- create a mongo Repository

  	public interface CourseRepository extends MongoRepository<Course, String> {
  		
  	}
-

# Rest Consumers
- http://www.groupkt.com/post/c9b0ccb9/country-and-other-related-rest-webservices.htm

# Open API integration
- http://localhost:8090/crudapp/swagger-ui.html
- username is : admin& admin
- yet to implement documentation Tasks

# Features Awaiting
- Exception Handling
  - Controller Specific
- AOP
- Auditing...Added Auditing
- Oauth2 Integration
    - password flow
    - Authorization Code
    - Client Credentials
- Vault Service Integration
- Spring Cloud Config Integration
- Resilient 4J integration
- CQRS integration
- Native Queries
- JDBC and Batch Support
- Spring Cloud Sleuth support
- Spring Micrometer integration
- Dockerized this app
- K8S integration
- Making external calls to the app
- Jmeter Test cases
- API Integrations
- GraphQL
- WebFlux
 
# Rest
    - File Upload
    - Web Socket
- Encryption utilities
- Base 64 encryption
- HAL Media types
- Actuator End points
- Encrypting
- Custom Logging: Specifying the logger
- Many to Many mapping
- two data sources in the same project
- Unit Test cases
- Spring AOP
    - Before
    - After
    - Around 