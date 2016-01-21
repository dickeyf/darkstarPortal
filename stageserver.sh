#!/bin/bash

# Build the java backend
./gradlew oneJar

# Copy the fat jar to the package
cp build/libs/darkstarPortal-1.0-SNAPSHOT-standalone.jar darkstar/
cp LICENSE darkstar/