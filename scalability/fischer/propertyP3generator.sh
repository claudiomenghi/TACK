propertyIndex=2;
max=11
while (($propertyIndex < $max)) 
do 
    string="";
    
    indexsub=2;
    upp=$((propertyIndex + 1));
    while (( $indexsub < $upp )) 
    do
        term=""
        index=1
        maxvalue=$(($indexsub+1));
        while  (( $index < $maxvalue )) 
        do
            if [ $index == 1 ]; 
            then
                term="(p1_cs)"
            else
                term="(&& (p"$index"_cs) "$term")"
            fi
            index=$((index+1));
        done
        if [ $indexsub == 2 ]; then
            string=$term
        else
            string="(|| "$term" "$string")"
        fi
        indexsub=$((indexsub+1));
    done
   echo "Property P"$propertyIndex" generated"
   echo "G_i+ 0 (! "$string ")" > fischer_input_P3_0$propertyIndex.mitli
   propertyIndex=$((propertyIndex+1));
done