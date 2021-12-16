FROM openjdk:8-jre

WORKDIR /opt
ADD ./build/libs/*.jar /opt/app.jar

EXPOSE 8080

CMD java -server -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:+ScavengeBeforeFullGC -XX:+CMSScavengeBeforeRemark -XX:MinHeapFreeRatio=20 -XX:MaxHeapFreeRatio=40 -XX:GCTimeRatio=4 -XX:AdaptiveSizePolicyWeight=90 -Xms40M -Xmx256M -jar app.jar
