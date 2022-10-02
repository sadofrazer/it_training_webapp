#!/bin/bash
docker stop $(docker ps -a | grep -i "rest_api" | awk '{print $NF}') || true
docker rm -f $(docker ps -a | grep -i "rest_api" | awk '{print $NF}') || true