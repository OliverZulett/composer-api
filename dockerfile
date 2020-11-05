FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ENV APP_PORT=8094
ENV API_USER=composerAdmin
ENV API_PASSWORD=composerAdmin
ENV API_USER_ROLE=ADMIN
ENV PRODUCT_API_BASE_URL=http://springboot-product:8090
ENV ORDER_API_BASE_URL=http://springboot-order:8091
ENV COMPANY_API_BASE_URL=http://springboot-company:8092
ENV USER_API_BASE_URL=http://springboot-user:8093
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} api.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","api.jar"]