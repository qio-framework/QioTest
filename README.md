#  QioTest 

A testing scaffold for Qio

### Requirements

* Java OpenJdk
* Maven


### Steps

1. Clone the QioTodo project:

```
git clone https://github.com/qio-framework/QioTodo.git
```
2. Run QioTodo in the background
```
mvn package jetty:run
```

3. Clone this project...
4. Download/Update the web driver, expecting to be in homedir/WebDriver/* see `src/main/test/qio/QioTodoTest.java` for driver setup.
5. Run tests by running following command:

```
mvn test
```