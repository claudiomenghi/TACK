#!/bin/bash
# https://stackoverflow.com/questions/556405/what-do-real-user-and-sys-mean-in-the-output-of-time1/556411#556411

mkdir TMP
file=results.txt;
touch $file
echo "" > $file

for j in $(seq 0 1);
do
    echo "--------------------------------------------" >> $file
    echo "Property "$j >> $file

    for bound in $(seq 10 5 30)
     do
        echo "--------------------------------------------" >> $file
        echo "bound: "$bound >> $file
        for i in $(seq 2 10);

        do 
            echo "Fisher:" $i >> $file  
            message="Test: 0"$i
                echo $message;
                param=0$i;
                (time sh runTack.sh $param $j $bound $file; ) 2>> $file

                #mytime="$(time ( " $command"  ) 2>&1 1>/dev/null )"
                echo "$mytime" >> $file        
        done

	#i=10
	#message="Test: "$i
	#echo "Fisher:" $i >> $file
    #        echo $message;

    #        (time sh runTack.sh $i $j $bound ; ) 2>> $file
    #        #mytime="$(time ( " $command"  ) 2>&1 1>/dev/null )"
    #        echo "$mytime" >> $file
    done
done
