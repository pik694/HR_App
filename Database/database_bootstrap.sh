#!/bin/bash

DB_CONTAINER=recruit-me-db
DB_IMAGE=recruit-me-db:${CURR_VERSION}


docker ps -aqf "name=${DB_CONTAINER}" | xargs docker stop | xargs docker rm
docker rmi ${DB_IMAGE}
docker build -t ${DB_IMAGE} .

docker run --name=${DB_CONTAINER} -p 3306:3306 -d ${DB_IMAGE}

