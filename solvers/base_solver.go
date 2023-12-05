package solvers

type Riddle struct {
	RiddleInput string
}

type Solution struct {
	SolutionOutput string
}

type Solver interface {
	solve(riddle Riddle) (*Solution, error)
}

func SolveRiddle(doorNumber string, riddle Riddle) (*Solution, error) {
	solver, err := CreateSolverForDoor(doorNumber)
	if err != nil {
		return nil, err
	}

	return solver.solve(riddle)
}
