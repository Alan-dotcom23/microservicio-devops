# Etapa 1: Compilación (Usando Maven con Java 21)
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY suscipciones_fullstack1/pom.xml .
COPY suscipciones_fullstack1/src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Imagen de ejecución ligera (JRE de Java 21)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# El archivo .jar generado se llamará basado en tu artifactId y versión del pom
COPY --from=build /app/target/subcripciones-0.0.1-SNAPSHOT.jar app.jar

# Spring Boot corre por defecto en el puerto 8080
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]