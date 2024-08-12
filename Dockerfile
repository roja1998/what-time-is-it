FROM maven:3.8.6-openjdk-11 AS build
WORKDIR /work
COPY . /work
RUN chmod +x mvnw
RUN ./mvnw package

FROM openjdk:15-alpine
WORKDIR /root/
COPY --from=build /work/target/what-time-is-it-0.0.1-jar-with-dependencies.jar what-time-is-it.jar
CMD ["java", "-jar", "what-time-is-it.jar"]