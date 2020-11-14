#!/bin/sh

set -e

# kse-script.sh shell script is located in the ./market-kse-script/ folder
# run the below command inside the Katalon Container to execute katalon script of the targeted tested application

echo $PATH

katalonc.sh -projectPath=./market-kse-script -retry=1 -retryStrategy=allExecutions -testSuiteCollectionPath="Test Suites/Market_TSC" -apiKey="${APIKEY-VALUE}" --config -webui.autoUpdateDrivers=true
