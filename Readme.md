# Golang project for solving the EGS coding Adventskalendar
The calendar can be found under: https://codingchallenge.azurewebsites.net/ <br>

## Setup
There is no setup needed ;)

## Structure
The `config.json` contains the application config for the project. <br>
The `main.go` file is the entry point of the application. <br>

## Running a riddle solver
The solvers for the individual riddles are located under the `solvers` package. <br>
Run `main.go solve --api_key "<your_api_key>" --door "<door_number>"` to solve the riddle for the specific door. <br>
The file `api_key.txt` is ignored by git, you can store your key there if you are lazy :) <br>