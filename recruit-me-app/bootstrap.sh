#!/usr/bin/env bash

VERSION=:0.1.0-SNAPSHOT

APP_CONTAINER_MASTER=recruit-me
APP_IMAGE_MASTER=recruit-me
APP_IMAGE_MASTER+=VERSION

APP_CONTAINER_RC=recruit-me-rc-
APP_CONTAINER_RC+=$BUILD_ID
APP_IMAGE_RC=recruit-me-rc-
APP_IMAGE_RC+=$BUILD_ID
APP_IMAGE_RC+=$VERSION

if [ $GIT_BRANCH = "origin/master" ]
then
    docker ps -aqf "name=${APP_CONTAINER_MASTER}" | xargs docker stop | xargs docker rm
    docker rmi ${APP_IMAGE_MASTER}

    docker build -t ${APP_CONTAINER_MASTER} .
    docker run --name=${APP_CONTAINER_MASTER} -p 8081:8081 -d ${APP_IMAGE_MASTER}
fi

if [ $GIT_BRANCH = "origin/testing" ]
then
    docker ps -aqf "name=${APP_CONTAINER_RC}" | xargs docker stop | xargs docker rm
    docker rmi ${APP_IMAGE_RC}

    docker build -t ${APP_CONTAINER_RC} .
    docker run --name=${APP_CONTAINER_RC} -p 6969:6969 -d ${APP_IMAGE_RC}
fi