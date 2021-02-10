# mobiq-atf-api
Test automation framework

This is a test framework created as a test task.

###Description:
[Cucumber] was chosen As a base tool for test management and execution. Main argument being - business oriented and easy to understand design (via Gherkin)

###Spring:
Spring is used for dependency injection and dynamic configuration of framework. Making the solution more scalable. All spring configuration is annotation-based


The main layers of framework are:
- feature files located in .resources/features - representing test cases
- step definitions located in .steps package - representing highlevel implementation for each test step oriented on business. Thus all classes are plitted by business domain
- actions located in .actions package - representing more granulated, and compatinr to steps - more technical level
- service layers located in .service  - are targeted to act as a layer of abstraction between abovementioned layers and highlevel-technical functionality of the framework

###Reporting
- after each run, a test report is generated under target/pretty-cucumber
- report format is standard cucumber report, that can be adjusted by using existing cucumber templates

###Configuration:
- For configuration layer ./resources/application.yml is used allowing dynamic configuration of framework for future uses
- Currently base url - is single configurable parameter
