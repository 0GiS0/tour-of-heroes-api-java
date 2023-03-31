# Variables
RESOURCE_GROUP="tour-of-heroes-java-env"
LOCATION="northeurope"
APPLICATION_NAME="tour-of-heroes-java"

# Create a resource group
az group create --name $RESOURCE_GROUP --location $LOCATION

# Create Application Insights
az monitor app-insights component create \
--app $APPLICATION_NAME-insights --location $LOCATION \
--kind web -g $RESOURCE_GROUP \
--application-type web \
--retention-time 120

# Get Application Insights instrumentation key
APP_INSIGHTS_CONNECTION_STRING=$(az monitor app-insights component show \
--app $APPLICATION_NAME-insights -g $RESOURCE_GROUP \
--query "connectionString" -o tsv)

# Create a Azure Cache for Redis
az redis create \
--name $APPLICATION_NAME-redis \
--resource-group $RESOURCE_GROUP \
--location $LOCATION \
--sku Basic \
--vm-size C0 \
--enable-non-ssl-port

# Get Azure Cache for Redis connection string
REDIS_CONNECTION_STRING=$(az redis list-keys \
--name $APPLICATION_NAME-redis \
--resource-group $RESOURCE_GROUP \
--query "primaryKey" -o tsv)

# Create a Azure Database for PostgreSQL
az postgres server create \
--name $APPLICATION_NAME-postgres \
--resource-group $RESOURCE_GROUP \
--location $LOCATION \
--admin-user postgres \
--admin-password 'P@ssw0rd!' \
--sku-name B_Gen5_1 \
--version 11


# Run app
./gradlew bootRun


# There are two options for enabling Application Insights Java with Spring Boot: JVM argument and programmatically.

# Download Application Insights Java agent from GitHub
curl -L https://github.com/microsoft/ApplicationInsights-Java/releases/download/3.4.10/applicationinsights-agent-3.4.10.jar -o applicationinsights-agent-3.4.10.jar


# Build app
./gradlew build

### JVM argument ###
APPLICATIONINSIGHTS_CONNECTION_STRING=$APP_INSIGHTS_CONNECTION_STRING \
java -javaagent:./applicationinsights-agent-3.4.10.jar \
-jar build/libs/tour-of-heroes-0.0.1-SNAPSHOT.jar


###################
#### Resources ####
###################
# https://learn.microsoft.com/en-us/azure/azure-monitor/app/opentelemetry-enable?tabs=java
# https://learn.microsoft.com/en-us/azure/azure-monitor/app/java-spring-boot
# https://www.tutorialspoint.com/spring_boot/spring_boot_building_restful_web_services.htm
# https://hantsy.gitbook.io/build-a-restful-app-with-spring-mvc-and-angularjs/build-rest


# https://github.com/akraskovski/spring-boot-postgresql-gradle
# https://refactorizando.com/ejemplo-spring-data-postgresql-docker/
# https://spring.io/guides/gs/accessing-data-mysql/