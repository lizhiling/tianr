#!/usr/bin/env bash
mvn clean
mvn package spring-boot:repackage
mvn dockerfile:build
docker login -u="$DOCKER_USERNAME" -p="$DOCKER_PASSWORD"
docker push dylzl678/tianr:latest