
i=$1
property=$2
bound=$3


modelname="fischer/fischer_input_"
modelname=$modelname$i".ta"
propertyname="fischer/fischer_input_P"

if  [ $2 == 3 ];
then
    propertyname=$propertyname$property"_"$2".mitli"
    command="java -jar tack.jar "$modelname" "$propertyname" "$bound" "$i

else
    propertyname=$propertyname$property".mitli"
    command="java -jar tack.jar "$modelname" "$propertyname" "$bound" "$i
fi
echo $command

eval $command > /dev/null 2>&1