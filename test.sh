cd timedAutomata
echo "Running the timed Automata tests"
gradle test
cd ..
cd cltloc 
echo "Running the CLTLoc tests"
gradle test
cd ..
cd mitli 
echo "Running the MITLI tests"
gradle test
cd ..
cd solvers
echo "Running the solvers tests"
gradle test
cd ..
cd checker
echo "Running the checker tests"
gradle test
cd ..

