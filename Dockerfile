FROM openjdk:11
VOLUME /tmp
EXPOSE 8000
ADD ./target/Payments-0.0.1-SNAPSHOT.jar Payments.jar
ENTRYPOINT ["java","-jar","/Payments.jar"]