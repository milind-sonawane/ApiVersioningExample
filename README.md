Step 1: Add API Version Management dependency in POM 

For Spring boot 1.5.x
```
<dependency>
    <groupId>com.mindstix.web.api.management</groupId>
    <artifactId>rest-api-version-management</artifactId>
    <version>0.0.1-RELEASE</version>
</dependency>
```
For Spring boot 2.0.x
```
<dependency>
    <groupId>com.mindstix.web.api.management</groupId>
    <artifactId>rest-api-version-management-SB2</artifactId>
    <version>0.0.1-RELEASE</version>
</dependency>
```
Step 2: Adding ‘@ApiVersionCheck’ on the main class and include ‘com.mindstix.web’ package in ComponentScan so as to trigger API Version Manager
```
@SpringBootApplication
@ApiVersionCheck
@ComponentScan(basePackages = { "com.mindstix.web", "com.example.integration" })
public class DemoApplication {
    public static void main(String[] args) {
       SpringApplication.run(DemoApplication.class, args);
    }
}
```
Step 3: Adding config properties

Optional but recommended. These properties are also available as attributes within the annotation `@ApiVersionCheck`
```
# Flag to disable API versioning feature. (optional, default=true)
rest.api.version.management.feature.enabled=

# Flag to disable API versioning fallback if requested version is unavail. (optional, default=true if feature is enabled, else false)
rest.api.version.management.fallback.enabled=

# Flag to enable fallback retry with base lookup path without versioning. (optional, default=false)
rest.api.version.management.fallback.retryWithBaseLookupPath=

# API context for versioned APIs. (optional, default="")
rest.api.version.management.apiContext=

# Version context for versioned APIs. (optional, default="")
rest.api.version.management.versionContext=

# Minimum version supported for API versioning. (optional, determined via code if not provided)
rest.api.version.management.min.version.support=

# Maximum version supported for API versioning. (optional, determined via code if not provided)
rest.api.version.management.current.version.support=

# Max decimal digit support for API versions. (optional, default=1)
rest.api.version.management.max.decimal.digit.support=

# Flag to allow the disabled API versions. (optional, default=false)
rest.api.version.management.disabledApiVersions.allowed=

# Flag to include disabled API versions in fallback. (optional, default=true if disabled APIs are allowed, else false)
rest.api.version.management.disabledApiVersions.fallback.enabled=

# Default packages to be scanned if AutoApiVersionCheck annotation is conflicting. (optional, default="")
rest.api.version.management.default.scanPackages=

# Default packages to be ignored if AutoApiVersionCheck annotation is conflicting. (optional, default="")
rest.api.version.management.default.ignorePackages=

# Default classes to be ignored if AutoApiVersionCheck annotation is conflicting. (optional, default="")
rest.api.version.management.default.ignoreClasses=

# Default stopAppOnCheckFail AutoApiVersionCheck annotation is conflicting. (optional, default=false)
rest.api.version.management.default.stopAppOnCheckFail=
```
Step 4: Creating a new controller
Create a new java class. There are few things to take care of
Packaging structure.
The controller bean should have a name.
Annotating the controller with @ApiVersion
Giving the controller a version.
For example, a HelloVersioningController would look like this.
```
package api.versioning.example.controllers.v1_0;

@RestController("VersionCheckController_v1_0")
// Add a proper bean name to avoid clashes with controllers of different version with the same name.
@ApiVersion("1.0")
public class VersionCheckController {
    @RequestMapping(path = "/")
    public ResponseEntity<String> checkControllerVersion() {
        return new ResponseEntity<>("Controller Version 1.0", HttpStatus.OK);

    }
}
```
You can refer the sample project
https://github.com/milind-sonawane/ApiVersioningExample

If you have any doubts regarding this project, feel free to post on stack overflow with the tag `spring-api-versioning`
