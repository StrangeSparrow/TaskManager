FROM adoptopenjdk/openjdk14:jre-14.0.2_12-ubuntu
VOLUME /tmp
ADD target/taskManager-1.0.jar app.jar
ENTRYPOINT [ "sh", "-c", "java --enable-preview -jar /app.jar" ]
