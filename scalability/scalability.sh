#!/bin/bash
# https://stackoverflow.com/questions/556405/what-do-real-user-and-sys-mean-in-the-output-of-time1/556411#556411
for i in 0{2..9} 10;
do 
    mytime="$(time ( echo "a" ) 2>&1 1>/dev/null )"
    echo "$mytime" >> results.txt
done