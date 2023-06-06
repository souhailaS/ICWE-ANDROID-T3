# UserResource

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getLocation**](UserResource.md#getLocation) | **GET** /location | Gets the current location
[**getMusic**](UserResource.md#getMusic) | **GET** /music | Gets a list of favourite music genres
[**getTemperature**](UserResource.md#getTemperature) | **GET** /temperature | Gets the environment temperature


<a name="getLocation"></a>
# **getLocation**
> Location getLocation()

Gets the current location

### Example
```java
// Import classes:
//import org.openapitools.server.resource.UserResource;

UserResource apiInstance = new UserResource();
try {
    Location result = apiInstance.getLocation();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserResource#getLocation");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Location**](Location.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

<a name="getMusic"></a>
# **getMusic**
> List&lt;String&gt; getMusic()

Gets a list of favourite music genres

### Example
```java
// Import classes:
//import org.openapitools.server.resource.UserResource;

UserResource apiInstance = new UserResource();
try {
    List<String> result = apiInstance.getMusic();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserResource#getMusic");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

<a name="getTemperature"></a>
# **getTemperature**
> Temperature getTemperature()

Gets the environment temperature

### Example
```java
// Import classes:
//import org.openapitools.server.resource.UserResource;

UserResource apiInstance = new UserResource();
try {
    Temperature result = apiInstance.getTemperature();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserResource#getTemperature");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Temperature**](Temperature.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

