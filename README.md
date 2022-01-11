
# API - Livraria

Projeto desenvolvido para estudaro Spring com Mongo.


## Tech Stack

- Java (17)
- [Spring Boot (2.6.2)](https://spring.io/projects/spring-boot)
- [Spring Data MongoDB](https://spring.io/projects/spring-data-mongodb)
- [Lombok](https://projectlombok.org/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)
- [Docker-Compose](https://docs.docker.com/compose/)
- [MongoDB](https://www.mongodb.com/)

## Rodar localmente

Clonar o projeto

```bash
  git clone https://github.com/t-rodrigues/livraria-api.git
```

Acessar o diretorio do projeto

```bash
  cd spring-mongo
```

Criar o container do MongoDB, necessário ter o docker-compose instalado

```bash
  docker-compose up -d
```

Iniciar o projeto 
```bash
./mvnw spring-boot:run
```

## Endpoints

- `/users`
- `/posts`

## Autor

- [@thiagorodrigues](https://www.github.com/t-rodrigues)
