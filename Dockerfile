FROM eclipse-temurin:17
WORKDIR /app
COPY ./target/shopping_app_backend-0.0.1-SNAPSHOT.jar /app/shopply.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "shopply.jar"]