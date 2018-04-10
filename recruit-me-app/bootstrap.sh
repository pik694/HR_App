#!/usr/bin/env bash

VERSION=:0.1.0-SNAPSHOT

APP_CONTAINER_MASTER=recruit-me
APP_IMAGE_MASTER=recruit-me
APP_IMAGE_MASTER+=$VERSION

RC_VER_LEN=${#GIT_BRANCH}
RC_VER_LEN=`expr $RC_VER_LEN - 7`

APP_CONTAINER_RC=recruit-me-rc
APP_IMAGE_RC=recruit-me-
APP_IMAGE_RC+=${GIT_BRANCH:7:$RC_VER_LEN}
APP_IMAGE_RC+=:latest

if [ $GIT_BRANCH = "origin/master" ]
then
    docker ps -aqf "name=${APP_CONTAINER_MASTER}" | xargs docker stop | xargs docker rm
    docker rmi ${APP_IMAGE_MASTER}

    docker build -t ${APP_IMAGE_MASTER} .
    docker run --name=${APP_CONTAINER_MASTER} -p 8081:8081 -d ${APP_IMAGE_MASTER}

fi

if [ ${GIT_BRANCH:0:9} = "origin/rc" ]
then
    docker ps -aqf "name=${APP_CONTAINER_RC}" | xargs docker stop | xargs docker rm
    docker rmi ${APP_IMAGE_RC}

    docker build -t ${APP_IMAGE_RC} .
    docker run --name=${APP_CONTAINER_RC} -p 6969:6969 -d ${APP_IMAGE_RC}
fi