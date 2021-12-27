# DOCKER UTILIZADO PARA POSTGRES LOCAL

## Criar container docker do Postgres

```shell script
docker run --name student-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=student postgres
```

## Entrar no shell do container
```shell script
docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash

```

## Entrar no Postgres Shell
```shell script
psql -h localhost -U postgres_user student
```

## Criar usuários

Após iniciar o programa, você pode criar usuários manualmente no psql:

```shell script
INSERT INTO myuser (id, active, password, roles, username) VALUES (1, TRUE, 'pass', 'ROLE_USER', 'user');

INSERT INTO myuser (id, active, password, roles, username) VALUES (2, TRUE, 'pass', 'ROLE_ADMIN', 'admin');
```