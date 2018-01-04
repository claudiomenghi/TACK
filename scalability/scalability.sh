#!/bin/bash
# https://stackoverflow.com/questions/556405/what-do-real-user-and-sys-mean-in-the-output-of-time1/556411#556411
touch results.txt
echo "" > results.txt

for j in {1..2}
do
    echo "--------------------------------------------" >> results.txt
    echo "Property "$j >> results.txt

#    for bound in `seq 10 5 30`
     do
        echo "--------------------------------------------" >> results.txt
        echo "bound"$bound >> results.txt

    #    for i in 0{2..9} 10;
        for i in 0{2..4};
        do 
            message="Test: "$i
            echo $message;

            (time sh runCommand.sh $i $j $bound ; ) 2>> results.txt

            #mytime="$(time ( " $command"  ) 2>&1 1>/dev/null )"
            echo "$mytime" >> results.txt
        done
    done
done