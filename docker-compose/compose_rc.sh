#!/usr/bin/env bash


cp ../recruit-me-app/target/recruit-me-app*.jar ./backend/app.jar
cp -r ../recruit-me-web/dist/ ./frontend/files/

docker-compose -p rc down --rmi local
docker-compose -f docker-compose.yaml -f docker-compose.rc.yaml -p rc up -d --build