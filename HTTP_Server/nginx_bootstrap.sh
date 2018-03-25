#!/bin/bash

HTTP_SERVER_CONTAINER=nginx
HTTP_SERVER_IMAGE=nginx_img

docker ps -aqf "name=${HTTP_SERVER_CONTAINER}" | xargs docker stop | xargs docker rm
docker rmi ${HTTP_SERVER_IMAGE}
docker build -t ${HTTP_SERVER_IMAGE} .

docker run --name=${HTTP_SERVER_CONTAINER} -p 80:80 -d ${HTTP_SERVER_IMAGE}


