# Integration Testing

A good unit test isolates the code that it tests from dependencies on outside resources. This is desirable because it usually makes the test more reliable and also easier to debug when it fails. However, interactions with outside resources are a potential source of bugs and bad assumptions and should definitely be tested. In fact, there are classes whose primary function is to interact with outside resources. Data Access Objects are an example of this. In order to validate that a DAO is functioning correctly, we really need to test it against a database. This is an example of an "integration test".

## Objectives

* Answer the question, "What is an Integration Test?"
* Implement DAO Integration Testing

## Notes and Examples

### What is an Integration Test?

<div class="definition note">

**Integration Testing** is a broad category of tests that validate the integration between units of code, or between code and outside dependencies such as databases or network resources.

</div>

- **Integration tests:**
    - Use the same tools as unit tests (i.e. JUnit or MSTest)
    - Usually slower than unit tests (but often still measured in ms)
    - More complex to write and debug
    - Can have dependencies on outside resources like files or a database

### DAO Integration Testing

- Since DAOs exist solely for the purpose of interacting with a database, they are often best tested using an integration test.

- The point of integration tests with a database are to ensure that the DAO code functions correctly:
    * SELECT statements are tested by inserting dummy data before the test
    * INSERT statements are tested by searching for the data
    * UPDATE statements are tested by verifying dummy data changed or that rowsAffected == expectedResult
    * DELETE statements are tested by seeing if dummy data is missing or that rowsAffected == expectedResult

- Tests (including integration tests) should be:
    - *Repeatable:* If the test passes/fails on first execution, it should pass/fail on second execution if no code has changed.
    - *Independent:* A test should be able to be run on it's own, independently of other tests, OR together with other tests and have the same result either way.
    - *Obvious:* When a test fails, it should be as obvious as possible why it failed.

- Approaches for Managing Test Data:

    - ***Remotely Hosted Shared Test Database***

        *An RDBMS is installed on a remote server and shared by all developers on the team for testing.*

        - *Advantages:*
            - Easy setup, often already exists
            - Production-like software and (possibly) hardware
        - *Disadvantages:*
            - Unreliable and brittle
            - Lack of test isolation
            - Temptation to rely on existing data (which can change)

    - ***Locally Hosted Test Database***

        *An RDBMS is installed and hosted locally on each developer's machine. (This is the approach we will use)*

        - *Advantages:*
            - Production-like software
            - Reliable (local control)
            - Isolation
        - *Disadvantages:*
            - Requires local hardware resources
            - RDBMS needs to be installed and managed

    - ***Embedded, In-memory Database***

        *An in-memory, embedded database server is started and managed by test code while running integration tests.*

        - *Advantages:*
            - Very reliable
            - Consistent across development machines (managed by source control)
            - Lightweight
        - *Disadvantages:*
            - Not the same software used in production
            - Cannot use proprietary features of production RDBMS

## Code

The lecture code is similar to what the end of the previous day's lecture looked like, along with some tests that you can walk through.

Review the DAO(s), they should look familiar from the DAO Lecture day.

> Java: You can walk through the `JDBCCityDAO` class and review the various methods.

Next, walk through the DAO tests. The first thing to note is that integration tests follow the same "Arrange-Act-Assert" pattern as unit tests. Walk through what each test does for those steps.

### Mock data


You will want to have the data in the database in a specific known state before you run tests. This allows the tests to be **repeatable**—they will return the same results every time you run them.

### Walkthrough Highlights

A test country is loaded into the database before and after **every** test. This happen in the `setup()` method of `JDBCCityDAOIntegrationTest`. The `cleanup()` methods removes it and any other test data that was inserted or modified during the tests.

#### Transaction

After the integration tests run, you want to have the database restored to its original state so that no data is permanently modified.

This is accomplished by creating a **Transaction Scope** object. By creating a transaction before the test runs, and rolling back the transaction after it's completed, this ensures that there are no permanent changes to the database.

#### City tests

Walk through the city tests note how you can create an object to use for a test that INSERTs data.

There's also an example of a test that's testing for a failure in the code. Adding a city to a country that doesn't exist should throw an exception.

