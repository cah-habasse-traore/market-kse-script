<h1> KATALON integration with CONCOURSE-CI </h1>

<h3>This sample code aimied to guide users on how to integrate a Katalon Script with a Concource pipeline.
The main goal is to enable projects team to implement testing has part of thier CI/CD pipeline.</h3>

<h5>1. Create Katalon Script</h5>

<h5>2. Execute Katalon script inside Docker </h5>
 
    Docker commands to launch Katalon and run the test inside the container
 
     * Execute a Test Suite in a docker for a specified browser type
         docker run -t --rm -v "$(pwd)":{volume mounted to container} katalonstudio/katalon katalonc.sh -projectPath={Katalon-script-folder} -retry=1 -retryStrategy=allExecutions -testSuiteCollectionPath="Test Suites/{ktl-test-suite-collection-TSC}" -apiKey="{katalon licensed account API Key}"
  
     * Execute a Test Suite Collection in a docker with the specified browserType for each Test Suite - Can be exeucted Sequentionally or in Parrallel depending on the use case
         docker run -t --rm -v "$(pwd)":{volume mounted to container} katalonstudio/katalon katalonc.sh -projectPath={Katalon-script-folder} -retry=1 -retryStrategy=allExecutions -testSuiteCollectionPath="Test Suites/{ktl-test-suite-collection-TSC}" -apiKey="{katalon licensed account API Key}"

<h5>3. Execute Katalon Script through the CLI  </h5>

    * CLI command to run a test suite collection
        katalonc.sh -projectPath={Katalon-script-folder} -retry=1 -retryStrategy=allExecutions -testSuiteCollectionPath="Test Suites/{ktl-test-suite-collection-TSC}" -apiKey="{katalon licensed account API Key}"

    * CLI command to run a test suite
        katalonc.sh -projectPath={Katalon script folder} -browserType="Chrome" -retry=1 -statusDelay=15 -testSuitePath="Test Suites/{ktl test suite}" -apiKey="{katalon licensed account API Key}"

   
<h5>4. Save Katalon Script in Git Hub  </h5>

    Save the script using either the Katalon Studio IDE or the Git CLI 
    
    
<h5>5. Create Concourse Pipeline  </h5>

    Create your pipeline using your katalon script has a Git-Hub Resource following the template below. 
   
  ![Image of Yaktocat]()

-├── market-kre:
-│   │ 
-│   ├── timer resource:
-│   │
-│   │
-│   ├── git resource: ./market-kse-script/
-│   │                             │   ├── scripts
-│   │                                       │   ├── kre-task.yml
-│   │                                                    │   │
-│   │                                                    │   └── kse-script.sh

    
    1. market-kre                 is my Pipeline
    2. market-kse-script          is my Katalon Script - called has a resource in my concourse pipeline
    3. timer                      is my pipeline timer resource 
    3. market-kre-pipeline.yml    is my Concourse Pipeline configuration file
    4. kse-script.yml             is my Pipeline Task
    5. kse-script.sh              is my katalon execution shell script:
    
<h5>6. market-kre-pipeline.yml configuration  </h5>
  
resources:
  - name: market-kse-script
    type: git
    source:
      uri: market-kse-script.git
      branch: master

  - name: execution-timer
    type: time
    source:
      interval: 30m
      
jobs:
 - name: market-kre-job
   public: true
   plan:
      - get: market-kse-script
      - get: execution-timer
        trigger: true
      - task: market-kre
        file: market-kse-script/kre-task.yml

<h5>7. Provided the kre-task.yml and kse-script.sh file in the repo  </h5>

<h5>8. FLY command you deploy the pipeline  </h5>
  
     *Set a Pipeline
           fly -t (tutorial) set-pipeline -c (path to pipeline configuration .yml file) -p (pipeline name)
           EX- Set the pipeline named "market-kre" using the "-market-kse-pipeline.yml" configuration file.
               fly -t tutorial set-pipeline -c kre-pipeline.yml -p market-kre
