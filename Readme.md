#Selection of the base
Spring Boot or the base configuration:
- Tasks don't require interaction with complicated technologies/frameworks, communication with databases or etc., 
therefore the base configuration is enough to complete this challenge.

JUnit or TestNG:
- **TestNG** is modern and flexible framework, which allows creating step-by-step tests and
  provides simple configuration for suites. 
- **JUnit** is also good framework for testing, but mostly it uses for unit-testing.

Allure:
- **Allure** is the framework that helps to check results of testing or any changes in results. 
It provides simple UI and has integration with Jenkins.
---
#Selection of testing frameworks
The first step is to determine frameworks to communicate with interfaces from tasks:
- UI task: 
  - **Selenium**
    - **Selenium** is one of the leaders in test automation for **WebUI**, which provides the opportunity to open browser,
      **find** necessary elements by Xpath, id, text or functionality of the element and **interact** with them.
    - **Selenium** provides the ability to **wait** for an element/page without interrupting, unlike Thread.sleep(), which
      makes test execution very fast.
    
- API task: 
  - **REST Assured**
    - This framework provides communication with RESTful services and allows to log everything. With this framework
    very easy to build a request and determine necessary attributes for response. It's also very simple to get 
    data and deserialize them.
    
  - **Jackson Databind**
    - This framework is necessary for reading JSON and covert into Java Objects.
  - **Lombok**
    - This framework simplifies the code by reducing the need to write getters/setters or constructors for each field of the class.
---
#Patterns
The second step is to determine how to write code very simple to another could understand it very quick and how to write code by optimize way.
- **Page Object** is the pattern for WebUI testing, which reduces the amount of duplicated code and if the UI changes, the fix need only be applied in one place.
- **Facade design pattern** helps to hide the complexities of the larger system and provides a simpler interface.
  It's very important for teamwork to read the realization of tests very quick and reuse some functions in another tests.
  This pattern also helps to minimize code length.
- **Randomization of tests** is necessary to provide different tests that might detect some bugs in the system.
---
#Preparations
The third step is to prepare all necessary objects, classes and JSONs:
- There might be a lot of tests that use same methods and variables, therefore it's important to take care of 
  general classes in advance, which contains everything necessary.
- Before cover scenarios by automation tests, it's necessary to examine the documentation for input and output data and 
  prepare their models in the framework.

---
#Possible steps for improvements
- On the big projects its more preferable to use Spring, because there can be a lot of environments,
  certain data (passwords, urls, certificates) and dependencies. Some frameworks are easier to use with Spring.
- All interactions with additional frameworks(e.g. kafka, jdbc, etc.) are easy to realize in ***src.main.java*** as a
  base of framework for testing.
- The more tests appear, the more smoke-tests are necessary.
- It's also possible to connect Log4j for certain logging.
- RandomHelper will also grow as necessary.
---
#Execution
Tests are easy to execute not only locally, but also from Jenkins with command "mvn clean test -Dsuite=${suite}", where
"suite" is the variable of suite name without "testng-".