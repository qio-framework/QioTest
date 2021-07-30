#  QioTest 


### Requirements

* Java OpenJdk
* Maven


A testing scaffold for Qio

* Clone the QioTodo project:

```
git clone https://github.com/qio-framework/QioTodo.git
```
* Run QioTodo in the background
```
mvn package jetty:run
```

* Clone this project...
* Download/Update the web driver, expecting to be in homedir/WebDriver/* see `src/main/test/qio/QioTodoTest.java` for driver setup.
* Run tests by running following command:

```
mvn test
```