# 🦸🏻‍♂️ Tour of heroes API in Java ☕️

![Heroes with Java coffee](docs/images/Heroes%20con%20un%20cafe%20de%20Java.jpeg)

## Introduction

Welcome to the Tour of Heroes API in Java! This project is a simple API that allows you to manage heroes 🦸🏼‍♀️. It is
based on the [Tour of Heroes](https://angular.io/tutorial) tutorial from Angular.

## How to run the project

If you want to run the project, you can do it in three ways:

### Installing the required tools

You need to have the following tools installed:

- Java 17
- Visual Studio Code or IntelliJ IDEA

### Using Dev Containers

You can run the project using Dev Containers:

1. Clone the repository.
2. Open the repository in Visual Studio Code.
3. Click on the "Reopen in Container" button.

### Using GitHub Codespaces

You can run the project using GitHub Codespaces:

[![Open in GitHub Codespaces](https://github.com/codespaces/badge.svg)](https://codespaces.new/octodemo/tour-of-heroes-api-java)

## Running the project

If you don't want to run the project in GitHub Codespaces, you can run it locally using Dev Containers.

Or... you need to run Postgres locally. You can do this by running the following command:

```bash
docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d -p 5432:5432 postgres
```

Also you need to run a Redis server locally. You can do this by running the following command:

```bash
docker run --name some-redis -e REDIS_PASSWORD=eYVX7EwVmmxKPCDmwMtyKVge8oLd2t81 -d -p 6379:6379 redis
```

After that, you can run the project by running the following command:

```bash
./gradlew bootRun
```

Or just press the play button in your IDE.
