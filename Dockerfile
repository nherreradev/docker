# ---------- Etapa 1: Compilación ----------
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean package -DskipTests

# ---------- Etapa 2: Imagen final ----------
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/target/docker-course-1.0.1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]