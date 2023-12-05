package http

import (
	"fmt"
	"github.com/go-resty/resty/v2"
	"github.com/rs/zerolog/log"
	"larsleo.com/adventskalendar23/config"
)

type RestClient struct {
	Config config.Config
}

type RiddleRestClient interface {
	GETRiddle(door string)
	POSTSolution(door string, solution string)
}

func (rc RestClient) GETRiddle(door string) (*resty.Response, error) {
	client := resty.New()
	riddlePath := rc.Config.BaseUrl + rc.Config.GetRiddlePath + door
	resp, err := client.R().
		// ToDo: set api token
		SetHeader("User-Token", "").
		Get(riddlePath)
	if err != nil {
		log.Err(err)
		return nil, err
	}

	return resp, nil
}

func (rc RestClient) POSTSolution(door string, solution string) (*resty.Response, error) {
	client := resty.New()
	solutionPath := rc.Config.BaseUrl + rc.Config.PostSolutionPath + door
	resp, err := client.R().
		SetHeader("Content-Type", "application/json").
		SetBody(solution).
		Post(solutionPath)
	if err != nil {
		fmt.Println("Error:", err)
		return nil, err
	}

	return resp, nil
}
