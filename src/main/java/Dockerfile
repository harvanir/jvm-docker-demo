FROM openjdk:8u212-jre-alpine3.9
#FROM openjdk:14-jdk-alpine
#FROM openjdk:8u92-jre-alpine

VOLUME ["/tmp"]
ADD MemoryEater.class MemoryEater.class
RUN sh -c 'touch /MemoryEater.class'

ENV JMX " "
ENV JVM_OPT " "
ENV SLEEP_EACH_ITERATE_IN_MILLIS "0"
ENV MAX_ITERATION "1000"

ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom $JVM_OPT $JMX MemoryEater $SLEEP_EACH_ITERATE_IN_MILLIS $MAX_ITERATION"]