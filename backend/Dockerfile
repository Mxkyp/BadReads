FROM alpine:3.22.1

EXPOSE 8080
WORKDIR /usr/src/app

#Dependency stage
RUN apk add openjdk17 maven curl
COPY pom.xml .
RUN mvn -B dependency:go-offline

#package stage
COPY . .
RUN mvn package

ENTRYPOINT [ "java", "-jar", "/usr/src/app/target/BadReads-0.0.1-SNAPSHOT.jar" ]
