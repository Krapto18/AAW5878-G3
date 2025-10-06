FROM eclipse-temurin:24-jdk AS builder

WORKDIR AAW5878-G3/KidTD

COPY . .

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:24-jre

WORKDIR AAW5878-G3/KidTD

COPY --from=builder AAW5878-G3/KidTD/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar","app.jar"]