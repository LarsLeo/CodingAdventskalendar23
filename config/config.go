package config

import (
	"encoding/json"
	"fmt"
	"io"
	"os"
)

type Config struct {
	BaseUrl          string `json:"base_url"`
	GetRiddlePath    string `json:"get_riddle_path"`
	PostSolutionPath string `json:"post_solution_path"`
}

func NewConfig(configPath string) (*Config, error) {
	file, err := os.Open(configPath)
	if err != nil {
		fmt.Println(err)
		return nil, err
	}
	defer func(file *os.File) {
		_ = file.Close()
	}(file)

	bytes, err := io.ReadAll(file)
	if err != nil {
		fmt.Println(err)
		return nil, err
	}

	var config Config
	if err := json.Unmarshal(bytes, &config); err != nil {
		fmt.Println(err)
		return nil, err
	}

	return &config, nil
}
