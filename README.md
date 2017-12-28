# TACK (Timed Automata ChecKer)

TACK is  a novel technique to perform model checking of MITL properties on networks of TA which relies on a purely logic-based approach. 
The technique uses an intermediate logical language translating both the MITL formula and the TA model.
Instead of a direct encoding of the model-checking problem into the language of the underlying solver, the procedure exploits an intermediate level similarly to the Java Byte code for Java program execution.
The intermediate encoding is then processed by an appropriate solver.
The bipartite schema of the adopted decision procedure allows for decoupling software engineering and formal methods concerns.
On the one hand, software engineering concerns can be easily handled  by proposing an encoding of new TA semantics in the intermediate language.
On the other hand, more efficient solvers can be developed for  the intermediate language. 

TACK has been submitted to FM 2018.

### Authors
- Claudio Menghi - claudio.menghi@gu.se
- Marcello Bersani - marcellomaria.bersani@polimi.it
- Matteo Rossi - matteo.rossi@polimi.it
- Pierluigi San Pietro - pierluigisanpietro@gmail.com




