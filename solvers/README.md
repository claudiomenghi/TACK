# Solvers

###Running the *MITLI solver* from IDE
* run the class `solvers.MITLIsolver`. Specify the file that contains the formula of interest as parameter.
 
###Running the *MITLI solver* using Gradle

 
* execute the command `docker pull fmarconi/zot`
* run the command `gradle solve -Pfile='squaredsignal.mitli' -Ptime='1000'`. Where `squaredsignal.mitli` contains the MITLI formula to be verified. This command generates the file `squaredsignal.lisp` that contains the zot encoding of the MITLI formula.
