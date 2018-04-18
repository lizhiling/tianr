FROM java:8
VOLUME /tmp
ADD target/HelloWorld-1.0.jar app.jar
RUN bash -c 'touch /app.jar'

EXPOSE 9444
CMD ["java", "-jar", "./app.jar"]
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]