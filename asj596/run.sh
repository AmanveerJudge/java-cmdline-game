#!/bin/sh

javac -d out -Xlint:none src/org/uob/a1/*.java
#if [ $? -eq 0 ]; then
#    echo "Compile Success"
#else
#    echo "Compile Failed"
#fi
java -cp out org.uob.a1.Game 