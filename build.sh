#!/bin/bash
set -e

# Stage the ember.js client in the backend's assets
./stageclient.sh

# Stage the server into a deployable package
./stageserver.sh

# Archive the package
tar czf darkstarPortal.tar.gz darkstarPortal

# I said.... SHIP IT!