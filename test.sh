if [ $1 ]
then
    var=$1
else
    var="256m"
fi

./gradlew clean assemble && java -jar -Xmx$var build/libs/demo-0.0.1-SNAPSHOT.jar