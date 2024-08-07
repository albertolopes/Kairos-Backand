# Use a imagem base do Maven para construir o projeto
FROM maven:3.8.4-openjdk-11-slim AS build

# Copie o código fonte do projeto para dentro do contêiner
COPY . /app

# Defina o diretório de trabalho como o diretório raiz do projeto
WORKDIR /app

# Execute o comando mvn install para construir o projeto
RUN mvn install -DskipTests

# Use a imagem base do OpenJDK 11 para executar a aplicação
FROM openjdk:11-jdk-slim

# Copie o arquivo JAR construído durante a fase de construção anterior
COPY --from=build /app/target/pomodoro-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]

# Exponha a porta 8080 (se necessário)
EXPOSE 8080