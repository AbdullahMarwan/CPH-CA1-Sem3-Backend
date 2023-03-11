FROM eclipse-temurin:17-jdk

EXPOSE 8080
ARG APP_NAME="CA1-Backend"
ARG APP_VERSION="0.0.1"
ARG JAR_FILE="/build/libs/${APP_NAME}-${APP_VERSION}.jar"

COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "app.jar"]