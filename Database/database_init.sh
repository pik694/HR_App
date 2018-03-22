#!/bin/bash

DB_CONTAINER=recruit-me-db
DB_IMAGE=recruit-me-db:0.1.0
DB_VOLUME=recruit-me-db-volume

docker ps -aqf "name=${DB_CONTAINER}" | xargs docker stop | xargs docker rm
docker rmi ${DB_IMAGE}
docker build -t ${DB_IMAGE} .

docker run --name=${DB_CONTAINER} -p 3306:3306 -d -v ${DB_VOLUME}:/dupa ${DB_IMAGE}

