FROM eclipse-temurin:24-jdk AS builder

WORKDIR /KidTD

COPY . .

RUN mvnw clean package -DskipTests

FROM eclipse-temurin:24-jre

WORKDIR /KidTD

COPY --from=builder /KidTD/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar","app.jar"]