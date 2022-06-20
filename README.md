# one-stop-shop-registration-journey-tests
UI test suite for `one-stop-shop-registration-frontend` using WebDriver and Cucumber.  

## Running the tests

Prior to executing the tests ensure you have:
- Docker - to run mongo and browser (Chrome or Firefox) inside a container
- Appropriate [drivers installed](#installing-local-driver-binaries) - to run tests against locally installed Browser
- Installed/configured [service manager](https://github.com/hmrc/service-manager).

Run the following command to start services locally:

Run at least 4.0 with a replica set:
`docker run --restart unless-stopped -d -p 27017-27019:27017-27019 --name mongo4 mongo:4.0 --replSet rs0`
Connect to said replica set:
`docker exec -it mongo4 mongo`
When that console is there:
`rs.initiate()`
You then should be running 4.0 with a replica set. You may have to re-run the rs.initiate() after you've restarted

`sm --start ONE_STOP_SHOP_ALL -r` if running via Service Manager

`sbt run -Dapplication.router=testOnlyDoNotUseInAppConf.Routes` if running a branch locally

Note: if running the frontend locally, you will need to use the following command for the BTA feature:
`sbt run -Dapplication.router=testOnlyDoNotUseInAppConf.Routes`

Then execute the `run_tests.sh` script:

    ./run_tests.sh <environment> <browser-driver>

The `run_tests.sh` script defaults to the `local` environment with the locally installed `chrome` driver binary.  For a complete list of supported param values, see:
- `src/test/resources/application.conf` for **environment**
- [webdriver-factory](https://github.com/hmrc/webdriver-factory#2-instantiating-a-browser-with-default-options) for **browser-driver**

## Running the accessibility tests locally

Instructions for accessibility testing locally - based on: https://github.com/hmrc/accessibility-assessment#running-accessibility-assessment-tests-locally

Run this in terminal:
A11Y='artefacts.tax.service.gov.uk/accessibility-assessment:latest'
docker pull ${A11Y} && docker run --rm --name 'a11y' -p 6010:6010 -e TARGET_IP='host.docker.internal' ${A11Y}

Run this initialise post - https://github.com/hmrc/accessibility-assessment#post-apiappinitialise

In the journey tests, run “run_a11y.sh” which will run the journey tests with the following property “accessibility-test=true”

Run the assess pages post - https://github.com/hmrc/accessibility-assessment#post-apiassess-pages

Run the status get - https://github.com/hmrc/accessibility-assessment#get-apistatus
Status will change to “REPORT_READY” once complete and can also see this in the docker logs.
This step may take a while.

Go to http://localhost:6010/api/report/html to view the report

May need to run post reset if running this multiple times - https://github.com/hmrc/accessibility-assessment#get-apiappreset

## Running ZAP tests

ZAP tests are set up to run on Jenkins here - https://build.tax.service.gov.uk/job/One%20Stop%20Shop/job/one-stop-shop-registration-zap-tests/

Tests tagged with the ZAP tag will be included in these.

### Scalafmt
This repository uses [Scalafmt](https://scalameta.org/scalafmt/), a code formatter for Scala. The formatting rules configured for this repository are defined within [.scalafmt.conf](.scalafmt.conf).

To apply formatting to this repository using the configured rules in [.scalafmt.conf](.scalafmt.conf) execute:

 ```
 sbt scalafmtAll
 ```

To check files have been formatted as expected execute:

 ```
 sbt scalafmtCheckAll scalafmtSbtCheck
 ```

[Visit the official Scalafmt documentation to view a complete list of tasks which can be run.](https://scalameta.org/scalafmt/docs/installation.html#task-keys)