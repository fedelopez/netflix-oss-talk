#!/bin/bash
for i in {1..500}
do
    YEAR=`jot -r 1  2009 2017`
    URL=http://resilient-discovery-app.cfapps.io/topgrossing/$YEAR
    echo $URL
	curl $URL ; echo
	sleep 1
done