
i=$1
property=$2

modelname="fischer/fischer_input_"
modelname=$modelname$i".ta"
propertyname="fischer/fischer_input_P"
propertyname=$propertyname$property".mitli"
command="java -jar tack.jar "$modelname" "$propertyname

echo $command

eval $command > /dev/null 2>&1