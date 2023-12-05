package main

import (
	"fmt"
	"github.com/urfave/cli/v2"
	"os"
)

func main() {
	app := &cli.App{
		Commands: []*cli.Command{
			{
				Name:  "solve",
				Usage: "solve a riddle door",
				Flags: []cli.Flag{
					&cli.StringFlag{
						Name:  "api_key",
						Value: "",
						Usage: "Your personal API key",
					},
					&cli.StringFlag{
						Name:  "door",
						Value: "1",
						Usage: "The door of the riddle to solve",
					},
				},
				Action: func(c *cli.Context) error {
					apiKey := c.String("api_key")
					door := c.String("door")

					execute(apiKey, door)

					return nil
				},
			},
		},
	}

	err := app.Run(os.Args)
	if err != nil {
		fmt.Println(err)
	}
}

func execute(doorNumber string, apiKey string) {
	//appConfig, err := config.NewConfig("config.json")
	//if err != nil {
	//	log.Err(err)
	//}

	// ToDo 1. Create rest client and fetch data
	// ToDo 2. Call the solve method with a Riddle and get a Solution
	// ToDo 3. Call the Rest client with the Solution

}
