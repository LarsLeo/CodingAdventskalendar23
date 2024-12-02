package solvers

import "errors"

func CreateSolverForDoor(doorNumber string) (Solver, error) {
	switch doorNumber {
	case "1":
		return NewSolver1()
	default:
		return nil, errors.New("No solver found for door: " + doorNumber)
	}
}
