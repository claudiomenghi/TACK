#!/bin/bash
# https://stackoverflow.com/questions/556405/what-do-real-user-and-sys-mean-in-the-output-of-time1/556411#556411
touch results.txt
echo "" > results.txt

for i in 0{2..9} 10;
do 
    
    
#    a=$(echo $( TIMEFORMAT="%3U + %3S"; { time eval $command /dev/sda 2>&1 >/dev/null;  } 2>&1) "*1000" | bc -l)
    message="Running test: "$i
    echo $message;
    
    (time sh runCommand.sh $i; ) 2>> results.txt
    
    #mytime="$(time ( " $command"  ) 2>&1 1>/dev/null )"
    echo "$mytime" >> results.txt
done