# Variables
RESOURCE_GROUP="tour-of-heroes-java-env"
LOCATION="northeurope"
APPLICATION_NAME="tour-of-heroes-java"

# Create a resource group
az group create --name $RESOURCE_GROUP --location $LOCATION

# Create a Log Analytics workspace
az monitor log-analytics workspace create \
--resource-group $RESOURCE_GROUP \
--workspace-name $APPLICATION_NAME-log-analytics \
--location $LOCATION

# Get Log Analytics workspace id
LOG_ANALYTICS_WORKSPACE_ID=$(az monitor log-analytics workspace show \
--resource-group $RESOURCE_GROUP \
--workspace-name $APPLICATION_NAME-log-analytics \
--query "id" -o tsv)

# Create Application Insights
az monitor app-insights component create \
--app $APPLICATION_NAME-insights --location $LOCATION \
--kind web -g $RESOURCE_GROUP \
--application-type web \
--workspace $LOG_ANALYTICS_WORKSPACE_ID

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
REDIS_PRIMARY_KEY=$(az redis list-keys \
--name $APPLICATION_NAME-redis \
--resource-group $RESOURCE_GROUP \
--query "primaryKey" -o tsv)

# Test Redis connection
# Create docker container with redis-cli
echo "docker run -it --rm redis:6.2.5-alpine redis-cli -h $APPLICATION_NAME-redis.redis.cache.windows.net -p 6379 -a $REDIS_PRIMARY_KEY"

# Create a Azure Database for PostgreSQL
az postgres server create \
--name $APPLICATION_NAME-postgres \
--resource-group $RESOURCE_GROUP \
--location $LOCATION \
--admin-user $DB_USERNAME \
--admin-password $DB_PASSWORD \
--sku-name B_Gen5_1 \
--version 11

# Create database
az postgres db create \
--name tourofheroes \
--resource-group $RESOURCE_GROUP \
--server-name $APPLICATION_NAME-postgres

# Get my IP address
curl ifconfig.me

# Run app
./gradlew bootRun


# There are two options for enabling Application Insights Java with Spring Boot: JVM argument and programmatically.

#### JVM argument ####

# Download Application Insights Java agent from GitHub
curl -L https://github.com/microsoft/ApplicationInsights-Java/releases/download/3.4.10/applicationinsights-agent-3.4.10.jar -o applicationinsights-agent-3.4.10.jar

# Build app
./gradlew build

### JVM argument ###
APPLICATIONINSIGHTS_CONNECTION_STRING=$APP_INSIGHTS_CONNECTION_STRING \
java -javaagent:./applicationinsights-agent-3.4.10.jar \
-jar build/libs/tour-of-heroes-0.0.2-SNAPSHOT.jar

### Programmatically ###
# https://learn.microsoft.com/en-us/azure/azure-monitor/app/java-spring-boot#enabling-programmatically