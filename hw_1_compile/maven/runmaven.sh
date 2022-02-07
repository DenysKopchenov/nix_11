#!/bin/sh

cd app/

mvn clean install

java -jar target/Main.jar