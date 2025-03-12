# UI tests for Civil Service Jobs

Coding language = `Java 21'`

Build tool = `Maven`

This is a `Cucumber BDD` framework.

## To run all tests:

`./run-tests.sh`

or alternatively

`mvn test -Dcucumber.options="--tags @regression"`

## To run all tests in headless-chrome:

`./run-tests.sh headless`

or alternatively

` mvn test -Dcucumber.filter.tags="@regression" -Dheadless=true`



## To run a particular test scenario:
Tag the scenario with `@<tag name>` and run:

`mvn test -Dcucumber.options="--tags @<tag name>"`

## To view HTML Test reports:

Go to:

`target/default-html-reports/index.html`

