# Batch Example
A little jee batch example

### Start batch
http://localhost:8080/batch1/v0/start

### Get all currencies
http://localhost:8080/batch1/v0/currency/all

### Get latest rate for a currency
http://localhost:8080/batch1/v0/currency/rate?currency=978

### add jberetweb
https://github.com/lbtc-xxx/jberetweb

#### Build

mvn -DdataSourceName=java:jboss/datasources/ExampleDS -DjobOperator.jndi=java:global/batch1/JobOperatorFacade!javax.batch.operations.JobOperator clean package

####
Change standalone.xml:
```xml
        <subsystem xmlns="urn:jboss:domain:batch-jberet:1.0">
            <default-job-repository name="example-ds"/>
            <default-thread-pool name="batch"/>
            <job-repository name="example-ds">
                <jdbc data-source="ExampleDS"/>
            </job-repository>
            <thread-pool name="batch">
                <max-threads count="10"/>
                <keepalive-time time="30" unit="seconds"/>
            </thread-pool>
        </subsystem>
```
