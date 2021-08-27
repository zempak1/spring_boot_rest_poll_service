FROM maven:3.6.0-jdk-11 AS build


COPY pom.xml ./pom.xml
WORKDIR /src
COPY . /src
#RUN mvn liquibase:update -e
#RUN mvn package -U -X -Dmaven.test.failure.ignore=true
# RUN mvn clean package -U -X -Dmaven.test.failure.ignore=true -Dliquibase.should.run=false
# RUN rm -f target/*-docker-info.jar

RUN mvn clean package -U -X -Dmaven.test.failure.ignore=true

FROM adoptopenjdk/openjdk11:latest
WORKDIR /
COPY --from=build src/target/spring_boot_poll_service-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java", "-jar", "app.jar", "application.properties"]
