# pokemon-manager-api

## Pokemon Manager API

Welcome to the back-end demo API for managing Pokemons.

The back-end application is implemented in [Spring](https://spring.io/), and it uses:

- [PostgreSQL](https://www.postgresql.org/) [Alpine 12.4](https://registry.hub.docker.com/layers/postgres/library/postgres/12-alpine/images/sha256-f78f9956eb182a092b5f570a4dbf09aebdbe8d8ef91fc46030bdea3ca07ac310?context=explore)
  Database
- [Keycloak](https://www.keycloak.org/) [latest](https://hub.docker.com/r/jboss/keycloak/tags) Identity Manager.

## Run locally

### Environment

Environment variables used during runtime

| Variable               | Default                          | Description            |
|------------------------|----------------------------------|------------------------|
| SERVER_PORT            | 13372                            | Application port       |
| DB_HOST                | localhost                        | Database host          |
| DB_PORT                | 13370                            | Database port          |
| DB_NAME                | pokemon_manager                  | Database name          |
| DB_USERNAME            | xed                              | Database user name     |
| DB_PASSWORD            | xed                              | Database user password |
| KEYCLOAK_HOST          | localhost                        | Keycloak host          |
| KEYCLOAK_PORT          | 13371                            | Keycloak port          |
| KEYCLOAK_REALM         | pokemon                          | Keycloak realm name    |
| KEYCLOAK_CLIENT_ID     | pokemon-client                   | Keycloak client ID     |
| KEYCLOAK_CLIENT_SECRET | gUYaQZXdDOoT2bxM4WkQJ4hr8kPacMvo | Keycloak client secret |


### Run on docker

Make sure to have the application packaged before running it on docker.

````shell
.\mvnw clean package
````

Run the **docker-compose.yml** file from the root of the project.

````shell
docker compose up
````

###### The following containers will be created:

- **pokemon-manager-app:**  Spring application running on port 13372
- **pokemon-manager-auth:** Keycloak instance running on port 13371
- **pokemon-manager-db:**   Postgres instance running on port 13370

### Delete cached docker images

There is a **docker-remove.cmd** file that deletes all cached images related to this project.

Run from the root of the project.

````shell
.\docker-remove
````

## Keycloak realm export

To export the pokemon-id Keycloak realm along with users,
follow [this](https://keepgrowing.in/tools/keycloak-in-docker-5-how-to-export-a-realm-with-users-and-secrets/) article.

1. Bind path `/tmp/export/` to a local volume
2. Execute this command
    ```shell
    docker exec -it pokemon-manager-auth /opt/jboss/keycloak/bin/standalone.sh `
    -D'jboss.socket.binding.port-offset=100' `
    -D'keycloak.migration.action=export' `
    -D'keycloak.migration.provider=singleFile' `
    -D'keycloak.migration.realmName=pokemon-id' `
    -D'keycloak.migration.usersExportStrategy=REALM_FILE' `
    -D'keycloak.migration.file=/tmp/export/pokemon-id-realm.json'
    ```

## Static code analysis

These commands create a SonarQube container on Docker, run it along with the code analysis

```shell
# create sonarqube container
docker run -d --name sonarqube -p 9000:9000 sonarqube:8.6.0-community
# run container 
docker start sonarqube
# run sonar analysis
.\mvnw clean verify sonar:sonar -D'sonar.host.url=http://localhost:9000' -D'sonar.login=admin' -D'sonar.password=admin'
```

## Testing options

- Launch Unit & Integration Tests

```shell
.\mvnw clean verify
```

###### Have a good day!
