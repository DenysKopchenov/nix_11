#!/bin/sh

#remove build
rm -r -f ./build

## manifest
echo Class-Path: libs/commons-collections4-4.4.jar libs/commons-io-1.3.2.jar libs/commons-lang3-3.12.0.jar libs/commons-math3-3.6.1.jar libs/commons-pool2-2.11.1.jar libs/commons-text-1.9.jar Main-Class: ua.com.alevel.Main>MANIFEST.MF

## compile
javac -sourcepath ./src -d build/classes -cp ./libs/*: src/ua/com/alevel/Main.java

## make dir jar
mkdir -p build/jar

#copy libs, create jar
jar cfm build/jar/HelloWorld.jar MANIFEST.MF -C build/classes/ .
mkdir -p build/jar/libs
cp libs/* build/jar/libs

## run
java -jar build/jar/HelloWorld.jar
