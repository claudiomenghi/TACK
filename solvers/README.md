# Solvers

###Running the *MITLI solver* from IDE
* run the class `solvers.MITLIsolver`. Specify the file that contains the formula of interest as parameter.
 
###Running the *MITLI solver* using Gradle

 
* execute the command `docker pull fmarconi/zot`
* run the command `gradle solve -PappArgs="['geesig.mitli', '15']"`. Where `geesig.mitli` contains the MITLI formula to be verified. This command generates the file `geesig.lisp` that contains the zot encoding of the MITLI formula.
* run the command `sh run_zot.sh geesig.lisp` where `geesig.lisp` is the generated file


# Developer corner


* run a single class test `gradle test --tests classname` where classname is the class containing the tests