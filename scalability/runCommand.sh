
i=$1
modelname="fischer/fischer_input_"
modelname=$modelname$i".ta"
propertyname="fischer/fischer_input_"
propertyname=$propertyname$i".q"
command="java -jar tack.jar "$modelname" "$propertyname

echo "Test: "$i >> results.txt
eval $command > /dev/null 2>&1