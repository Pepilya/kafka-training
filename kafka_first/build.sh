#! /bin/bash
cd kafka-producer
echo "Building producer ..."
mvn clean verify
cd ..
cd kafka-listener
echo "Building listener ..."
mvn clean verify
cd ..