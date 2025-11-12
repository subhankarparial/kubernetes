FROM eclipse-temurin:21-jdk
EXPOSE 8080
COPY order/target/order.jar order.jar
ENTRYPOINT ["java", "-jar", "/order.jar"]