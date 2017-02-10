# Solvers

###Running the *MITLI solver* using gradle

 
* execute the command `docker pull fmarconi/zot`
* run the command `sudo gradle run -PappArgs="['formula1.txt']"`. Where `formula1.txt` contains the MITLI formula to be verified. This command generates the file `formula1.lisp` that contains the zot encoding of the MITLI formula.
