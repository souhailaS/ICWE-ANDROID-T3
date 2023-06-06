# openapi-android-server

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>org.openapitools</groupId>
    <artifactId>openapi-android-server</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "org.openapitools:openapi-android-server:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/openapi-android-server-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import org.openapitools.server.resource.UserResource;

public class UserResourceExample {

    public static void main(String[] args) {
        UserResource apiInstance = new UserResource();
        try {
            Location result = apiInstance.getLocation();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserResource#getLocation");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*UserResource* | [**getLocation**](docs/UserResource.md#getLocation) | **GET** /location | Gets the current location
*UserResource* | [**getMusic**](docs/UserResource.md#getMusic) | **GET** /music | Gets a list of favourite music genres
*UserResource* | [**getTemperature**](docs/UserResource.md#getTemperature) | **GET** /temperature | Gets the environment temperature
*UserResponse* | [**getLocation**](docs/UserResponse.md#getLocation) | **GET** /location | Gets the current location
*UserResponse* | [**getMusic**](docs/UserResponse.md#getMusic) | **GET** /music | Gets a list of favourite music genres
*UserResponse* | [**getTemperature**](docs/UserResponse.md#getTemperature) | **GET** /temperature | Gets the environment temperature


## Documentation for Models

 - [Location](docs/Location.md)
 - [Temperature](docs/Temperature.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

spilab.uex@gmail.com

