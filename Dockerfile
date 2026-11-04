# Etapa 1: compilar y probar
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /src
COPY pom.xml .
COPY src ./src
RUN mvn -B package

# Etapa 2: runtime oficial de Lambda
FROM public.ecr.aws/lambda/java:21
ARG APP_VERSION=local
ENV APP_VERSION=${APP_VERSION}
COPY --from=build /src/target/classses ${LAMBDA_TASK_ROOT}
CMD [ "mx.itson.devops.descuento.Handler::handleRequest" ]