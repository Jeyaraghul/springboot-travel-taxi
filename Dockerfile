From fabric8/java-alpine-openjdk11-jre

COPY ./target/taxi-booking-0.0.1-SNAPSHOT.jar app.jar

ENV PORT=5000

ENV DURL=jdbc:postgresql://localhost:5432/postgres

ENV DUSR=postgres

ENV DPASSWD=postgres

EXPOSE 8081 

CMD ["java", "-jar", "app.jar","--port=${PORT}","--url=${DURL}","--usr=${DUSR}","--passwd=${DPASSWD}"]