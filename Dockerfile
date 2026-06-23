# Estructura Multi-stage para un empaquetado optimizado
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Como los archivos ahora están en la raíz, los copiamos directamente
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiamos el archivo JAR compilado desde la etapa de build
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]