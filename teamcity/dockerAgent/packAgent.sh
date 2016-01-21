#!/bin/bash

if [ $# -ne 1 ]; then
   echo "Usage: packAgent.sh <Teamcity install dir>"
   exit 1
fi

if [ ! -d $1/buildAgent ]; then
   echo "Failed: Couldn't find the directory $1/buildAgent"
   exit 1
fi

tar czf agent.tar.gz $1/buildAgent
