#!/usr/bin/env bash
mvn clean
docker login -u="$DOCKER_USERNAME" -p="$DOCKER_PASSWORD"
mvn package spring-boot:repackage
mvn dockerfile:build
TAG=`date +%Y%m%d`
docker tag dylzl678/tianr:latest dylzl678/tianr:${TAG}
docker push dylzl678/tianr:${TAG}
docker push dylzl678/tianr:latest
