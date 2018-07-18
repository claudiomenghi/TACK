# TACK (Timed Automata ChecKer)

TACK is  a novel technique to perform model checking of MITL properties on networks of TA which relies on a purely logic-based approach. 
The technique uses an intermediate logical language translating both the MITL formula and the TA model.
Instead of a direct encoding of the model-checking problem into the language of the underlying solver, the procedure exploits an intermediate level similarly to the Java Byte code for Java program execution.
The intermediate encoding is then processed by an appropriate solver.
The bipartite schema of the adopted decision procedure allows for decoupling software engineering and formal methods concerns.
On the one hand, software engineering concerns can be easily handled  by proposing an encoding of new TA semantics in the intermediate language.
On the other hand, more efficient solvers can be developed for  the intermediate language. 


### Authors
- Claudio Menghi - claudio.menghi@gu.se
- Marcello Bersani - marcellomaria.bersani@polimi.it
- Matteo Rossi - matteo.rossi@polimi.it
- Pierluigi San Pietro - pierluigisanpietro@gmail.com

### Related tool
- QTLSolver is the ancestor of TACK solving the satisfiability for MITL formulae over signals. The active repository is https://github.com/fm-polimi/qtlsolver while the original one with a more comprehensive user wiki is at https://code.google.com/archive/p/qtlsolver/.

### Running TACK using docker
Type the following commands 

1. `docker pull claudiomenghi/tack`
2. `docker run --name tack -it claudiomenghi/tack bash`
3. `java -jar tack.jar model.ta property.mitli bound` for example, run
`java -jar tack.jar fischer/fischer_input_02.ta fischer/fischer_input_P0.mitli 10`
4. `exit` exits the docker machine

To restart the machine after it has been exited use the following commands
1. `docker start tack`
2. `docker attach tack`

## Tool inputs
Two inputs must be provided to the tool:

1. a Timed Automaton to be verified (file .ta)
2. a property of interest (file .mitli)

# Timed Automaton

Timed Automata are described using the same syntax of UPPAAL. The interested reader can see TOBEADDED for additional information.

An example of Timed Automaton is described in the following
```
clock x1, x2;
int id{0,1,2}=0;

process p1 {
  state  a, b {x1<=2}, c, cs;
  init   a;
  trans  a -> b {
           guard  id==0;
           assign x1:=0;
         },
           b -> c {
           guard  x1<=2;
           assign x1:=0,id:=1;
         },
           c -> b {
           guard  id==0;
           assign x1:=0;
         },
           -> cs {
           guard  x1>2,id==1;
         },
           cs -> a {
           assign x1:=0,id:=0;
         };
}
system p1;
```

# Property of interest
- `F_xy lower_time_bound upper_time_bound formula` 
    It represents the finally operator 
    -   `x` must be associated to the value `i` (included) or `e` excluded and specify whether the formula should hold in the lower_time_bound instant
    -   `y` must be associated to the value `i` (included) or `e` excluded and specify whether the formula should hold in the upper_time_bound instant
- `G_xy lower_time_bound upper_time_bound formula`
     It represents the globally operator 
    -   `x` must be associated to the value `i` (included) or `e` excluded and specify whether the formula should hold in the lower_time_bound instant
    -   `y` must be associated to the value `i` (included) or `e` excluded and specify whether the formula should hold in the upper_time_bound instant
- `G_x+ lower_time_bound formula`
    It represents the globally operator. The formula should hold from the lower_time_bound forever (no upper bound is provided). 
    -   `x` must be associated to the value `i` (included) or `e` excluded and specify whether the formula should hold in the lower_time_bound instant
-  `F_x+ lower_time_bound formula`
    It represents the finally operator (no upper bound is provided). 
    -   `x` must be associated to the value `i` (included) or `e` excluded and specify whether the formula should hold in the lower_time_bound instant
-   `-> (formula1) (formula2)` 
    It represents the implication operator
-   `&& (formula1) (formula2)` 
    It represents the AND operator
-   `|| (formula1) (formula2)` 
    It represents the OR operator
-   `<-> (formula1) (formula2)` 
    It represents the OR operator
-   `U (formula1) (formula2)` 
    It represents the UNTIL operator
-   `id = INT` 
    specifies the value of the variable `id`. If the variable is a local variable it should have the form `process_id`, where `process` is the process within which the variable is defined.
-   `p_s` 
    specifies that the process `p` is in the state `s`.

# Developers corner

### Replicate the experiment 
1. `docker pull claudiomenghi/tack`
2. `docker run --name tack -it claudiomenghi/tack bash`
3. choose the solver to be used by changing the file `solver.txt`
4. `sh scalability.sh`


### Creating a new image
- `git clone https://github.com/claudiomenghi/TACK.git`
- `docker image build ./ --tag  claudiomenghi/tack`
- `docker image tag claudiomenghi/tack  claudiomenghi/tack/latest`
- `docker login`
- `docker push claudiomenghi/tack`


To copy the results on your local machine 
- `docker cp <containerId>:/file/path/within/container /host/path/target`



