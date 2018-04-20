#!/usr/bin/env bash

CONTAINER_NAME="recruit-me-app"
IMAGE_NAME="recruit-me-app"

if [ "$CURR_BRANCH" != "master" ]; then
    CONTAINER_NAME="${CONTAINER_NAME}-rc"
    IMAGE_NAME="${IMAGE_NAME}-rc"
fi


cp ./target/recruit-me-app-*.jar ./target/recruit-me-app-${CURR_VERSION}.jar
cp -r ../recruit-me-web/dist ./target/web_app

docker ps -aqf "name=${CONTAINER_NAME}" | xargs docker stop | xargs docker rm
docker rmi ${IMAGE_NAME}:${CURR_VERSION}
docker build -t ${IMAGE_NAME}:${CURR_VERSION} --build-arg JAR_FILE=recruit-me-app-${CURR_VERSION}.jar .


if [ "$CURR_BRANCH"  = "master" ] ; then
    docker run --name=${CONTAINER_NAME} -p 8081:80 -d ${IMAGE_NAME}:${CURR_VERSION}
else
    docker run --name=${CONTAINER_NAME} -p 6969:80 -p 7070:8080 -d ${IMAGE_NAME}:${CURR_VERSION}
fi

