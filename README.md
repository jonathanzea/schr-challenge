# SCHR Challenge - Weather "Microservice" (Spring Boot) Example Project

This is a sample Java / Maven / Spring Boot application that can be used as a middleware for retrieving the weather temperature (current time) from a city written by the user in the URL.

## How to Run 

This application is packaged as a war which has Tomcat 7 embedded. No Tomcat or JBoss installation is necessary. You run it using the ```java -jar``` command.

* Clone this repository 
* Make sure you are using JDK 1.7 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service typing:
* ```mvn spring-boot:run -Drun.arguments="spring.profiles.active=test"```

Once the application runs you should see something like this

```
2014-10-04 18:24:58.870  INFO 10190 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8090/http
2014-10-04 18:24:58.872  INFO 10190 --- [           main] com.khoubyari.example.Application        : Started Application in 6.764 seconds (JVM running for 7.06)
```

## About the Service

The service is just a simple weather REST service. It connects to an external API ```(https://openweathermap.org/api)``` an make a request to its weather service that its provided depending on the city name introduced.

In the controller this data is managed by Java Maps and Collections in order to extract just the temperature value to be finally converted in celsius degrees. get comfortable with the sample app you can add your own services following the same patterns as the sample service.

Here is the endpoint you can call:

### Get current temperature of a city.

```
http://localhost:8090/weadthermidle/weather-in/?city=Caracas
```

# Internal Services (Spring Boot Default) 

Conecting to ```http://localhost:8091``` you will be able to check the following endpoints helpful in monitoring and operating the service:

**/metrics** Shows “metrics” information for the current application.

**/health** Shows application health information.

**/info** Displays arbitrary application info.

**/configprops** Displays a collated list of all @ConfigurationProperties.

**/mappings** Displays a collated list of all @RequestMapping paths.

**/beans** Displays a complete list of all the Spring Beans in your application.

**/env** Exposes properties from Spring’s ConfigurableEnvironment.

**/trace** Displays trace information (by default the last few HTTP requests).

# Questions and Comments: zeta_jonathan@hotmail.com





