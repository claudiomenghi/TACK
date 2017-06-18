# TACK (Timed Automata ChecKer)


#### Implementation
The TACK framework is made by several modules:

* [cltloc](/cltloc) module that contains the description of CLTLoc formulae
* [mitli](/mitli) module that contains the description of  MITL formulae
* [solvers](/solvers) module allows the verification of MITL formulae
* [timed automata](/timedAutomata) contains the classes that represent and parse timed automata
* [checker](/checker) contains the TACK checker

#### Running TACK from the workspace
* open the `checker` folder
* run `gradle run -PappArgs="['model.ta','property.mitli']"` where `model.ta` is the model to be considered and `property.mitli` is the property to be verified.  

For example, `gradle run -PappArgs="['fischer_input_02.ta','fischer_input_02.mitli']"` executed in the folder `checker` folder verifies whether the formula `fischer_input_02.mitli` holds in the model `fischer_input_02.ta`