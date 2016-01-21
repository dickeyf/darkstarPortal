[![Build Status](https://travis-ci.org/dickeyf/darkstarPortal.svg?branch=master)](https://travis-ci.org/dickeyf/darkstarPortal)

# Darkstar Portal Backend

The purpose of this project is to provide the REST services required by the frontend to access Darkstar.

## License

This project is licensed as GPL V3.

# IntelliJ

## Prerequistes
* Ensure that you installed the ember.js plugin first
* Install nodejs on your system
* Execute darkstarPortal-client/setupEnv.sh once to install dependencies.

## Import the projects
This is how to import the project in IntelliJ:
1. Import darkstarPortal as a Gradle project.
2. Once imported, go in File -> Project Structure
3. Go in Modules.  Click the '+' button and pick "Import a module".
4. Select the darkstarPortal-client directory.
5. Select "Create Module from Existing Source".
6. Ember should be detected automatically.  Keep defaults for dialogs after that.

## Staging the client
This is how to stage the client:
In IntelliJ's terminal windows type :
> stageclient.sh

You'll have the restage again after you do any changes to the ember.js client

## Running from IntelliJ
1. Go in Run -> Edit Configurations...
2. Click the '+' button, in the drop-down, choose gradle.
3. Name the configuration.  IE. 'StarServer'.
4. Choose 'build.gradle' in "Gradle Project".  Use the browse button, you'll find that file in the project's root.
5. In 'Tasks', type "run".

It is now possible to Run, or Debug the server using that configuration.

Once started, you should see logs in the Console.  If everything is okay (IE. mysql server is
reachable), then, you'll be able to connect from a browser to http://127.0.0.1:8080
