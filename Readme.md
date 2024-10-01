# Workmate Test Automation Framework

This Readme file outlines the Workmate application's Test Automation Framework.

## How to run the tests

### Prerequisites:

1. Maven installed and properly configured in PATH
2. Backend and Frontend servers running (Frontend is not needed for API tests)

### Commands and parameters

To run all tests in whole framework, execute:

```
mvn test -DbackendServerUrl=<server_address>
```

`<server_address>` corresponds to the address and port of your application. For local installation, it will
be `localhost:8080`. Run command will be:

```
mvn test -DbackendServerUrl=localhost:8080
```