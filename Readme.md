# Kotlin project for solving the EGS coding Adventskalendar
The calendar can be found under: https://codingchallenge.azurewebsites.net/ <br>

## Setup
Add a class called `ApplicationConfig.kt` in the path `kotlin/org/example/config/ApplicationConfig.kt` with the content: <br>

```package org.example.config

object ApplicationConfig {
  const val BASE_URI: String = "https://codingchallenge.azurewebsites.net/api"
  const val USER_TOKEN: String = // your token string here
}
```

## Structure
There are `Riddle` classes, that automatically get the new riddle from the API and need to transfer the json into a kotlin data class. <br>
`Solver` classes use these data classes returned from the riddle classes and implement code to solve the problem and return the solution as json again. <br>
