# Tour of heroes - Java

In order to run the project, you need to run Postgres locally. You can do this by running the following command:

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

