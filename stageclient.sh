#!/bin/bash
set -e
cd darkstarPortal-client
npm install
bower install
ember build

# Copy the built ember application to the assets folder
mkdir -p ../src/main/resources/assets
cp -rf dist/* ../src/main/resources/assets

cd ..
