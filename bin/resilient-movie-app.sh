#!/bin/bash
for i in {1..500}
do
    YEAR=`jot -r 1  2009 2017`
    URL=http://resilient-movie-app.cfapps.io/movies/$YEAR
    echo $URL
	curl $URL ; echo
done