#!/bin/bash

CURR_VERSION="0.2.0"


if [ $# -eq 1 ] ; then
    CURR_BRANCH=$1
elif [ "$GIT_BRANCH" = "origin/master" ] ; then
    CURR_BRANCH="master"
else
    CURR_BRANCH="rc-${CURR_VERSION}"
fi

export CURR_BRANCH
export CURR_VERSION


## Build and deploy frontend and backend

mvn clean package

if [ $? -ne 0 ] ; then
    exit 1
fi

## Reset database

if [ "$CURR_BRANCH" = "master" ]; then
    cd ./Database
    ./database_bootstrap.sh

    if [ $? -ne 0 ] ; then
        exit 1
    fi
    cd ..
fi

## Run application
cd ./recruit-me-app
./app_bootstrap.sh
cd ..

export -n CURR_BRANCH
export -n CURR_VERSION






