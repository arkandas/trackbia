# Compile Jar File
FROM maven:3.8.6-eclipse-temurin-17 AS compile
RUN mkdir /home/trackbia
COPY src /home/trackbia/src
COPY pom.xml /home/trackbia
RUN mvn -f /home/trackbia/pom.xml clean package -DskipTests

# Build Docker Image
FROM eclipse-temurin:17
LABEL maintainer="arkandas" 
RUN mkdir /opt/app
COPY dbIP /opt/app/dbIP
COPY --from=compile /home/trackbia/target/trackbiaback-1.0.0.jar /opt/app
CMD ["java", "-jar", "/opt/app/trackbiaback-1.0.0.jar"]