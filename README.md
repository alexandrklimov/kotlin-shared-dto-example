# kotlin-shared-dto-example

## shared Tests Output

In this example simplest tests are used: they considered passed if didn't throw an exception and print some output to a console.  
But Gradle tends to swallow test's stdout.  

It can be fixed for JVM-based tests by following setting
```
tasks.withType<Test> {
    testLogging.showStandardStreams = true
}
```

But it isn't fix the issue for JS-based test.
For seeing JS-based test output you need to run it with **--info** param
```
./gradlew shared:jsTest --info
```
