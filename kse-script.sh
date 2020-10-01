#!/bin/sh

set -e

# kse-script.sh shell script is located in the ./market-kse-script/ folder
# run the below command inside the Katalon Container to execute katalon script of the targeted tested application

echo $PATH

katalonc.sh -projectPath=./market-kse-script -retry=1 -retryStrategy=allExecutions -testSuiteCollectionPath="Test Suites/Market_TSC" -apiKey="5c150d5c-a512-41a2-a42c-48f4ec07560e" --config -webui.autoUpdateDrivers=true