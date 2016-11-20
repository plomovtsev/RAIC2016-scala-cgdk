if [ ! -f $SCALA_HOME/lib/scala-library.jar ]
then
    echo Unable to find scala-library.jar in SCALA_HOME [$SCALA_HOME] > compilation.log
    exit 1
fi

if [ ! -f src/main/java/Runner.java ]
then
    echo Unable to find src/main/java/Runner.java > compilation.log
    exit 1
fi

if [ ! -f src/main/scala/MyStrategy.scala ]
then
    echo Unable to find src/main/scala/MyStrategy.scala > compilation.log
    exit 1
fi

rm -rf classes
mkdir classes

$SCALA_HOME/bin/scalac -sourcepath "src/main/scala" -d classes src/main/scala/*.scala src/main/scala/model/*.scala src/main/java/*.java src/main/java/model/*.java >compilation.log 2>&1
$JAVA_HOME/bin/javac -sourcepath "src/main/java" -cp "classes" -d classes src/main/java/*.java >>compilation.log 2>&1

if [ ! -f classes/MyStrategy.class ]
then
    echo Unable to find classes/MyStrategy.class >> compilation.log
    exit 1
fi

if [ ! -f classes/Runner.class ]
then
    echo Unable to find classes/Runner.class >> compilation.log
    exit 1
fi

echo Manifest-Version: 1.0 >MANIFEST.MF
echo Main-Class: Runner >>MANIFEST.MF
echo Class-Path: scala-library.jar scala-reflect.jar >>MANIFEST.MF

jar -cfm "./scala-cgdk.jar" MANIFEST.MF -C "./classes" . >>compilation.log 2>&1
cp -n $SCALA_HOME/lib/scala-library.jar $SCALA_HOME/lib/scala-reflect.jar .
