Compiler Deisgn of **alpha** language

School Project
Total grade: 8,5/10 

Alpha language is a language with grammar that our professor created from my University.

This group-project was implemented by me and 2   other students.


**Lexical Analyzer**: The Lexical Analyzer or Lexer reads characters from the input file and groups the characters into words or tokens in internal form: keywords, identifiers, numbers, operators.

**Parser**: The Parser receives a linear sequence of tokens from the Lexer and combines them into structured sentences in the form of abstract syntax trees or ASTs.

**Semantics**: Semantic (meaning) processing includes type checking and generation of code to access data structures such as arrays, pointers and records.

**Optimization**: The efficiency of the code produced by the compiler can be dramatically improved by optimization. The optimizer makes use of concepts from CS theory such as graph theory and set theory.

**Code Generation- Virtual Machine**: This is the final stage, in which actual machine code and virtual machine  is generated. Theory is used here too, e.g. graph coloring to map the program onto machine resources such as registers.

**How does it work**
```
make     |---------------| alphac your.txt  |---------------| alpha your.bin  |-----------|
-------> |  alphac (cmp) |----------------> | AlphaCode.bin |---------------> |  program  |
compiler |  alpha  (vm)  | alpha executable |---------------|                 |  output   |
& VM     |---------------| created                                            |-----------|
```

**Stucture of example**
```
.
|-- phase1
|   |
|   |-- scanner.l
|   |-- scanner.c
|   |-- Makefile

|--phase2
    |hash.h
    |parser.h
    |parser.c
    |parser.y
    |scanner.c
    |scanner.l
    |symtable.c
    | Makefile
|--phase3
|   |--phase3_normal
|   |   |-- parser.c
|   |   |-- praser.h
|   |   |-- praser.y
|   |   |-- quad.c
|   |   |-- quad.h
|   |   |-- scanner.c
|   |   |-- scanner.l
|   |   |-- symtable.c
|   |   |-- symtable.h
|   |   |-- Makefile

|   |--phase3_short_circuit
|   |   |-- parser.c
|   |   |-- praser.h
|   |   |-- praser.y
|   |   |-- quad.c
|   |   |-- quad.h
|   |   |-- scanner.c
|   |   |-- scanner.l
|   |   |-- symtable.c
|   |   |-- symtable.h
|   |   |-- Makefile

|--phase4-5
|   |--Phase5
|   |   |-- avm.c
|   |   |-- avm.h
|   |   |-- parser.c
|   |   |-- parser.h
|   |   |-- parser.y
|   |   |-- quad.c
|   |   |-- quad.h
|   |   |-- scanner.c
|   |   |-- scanner.l
|   |   |-- symtable.c
|   |   |-- symtable.h
|   |   |-- tcodegen.c
|   |   |-- tcodegen.h
|   |   |-- Makefile
|
|-- CompilerExec
|   |
|   '-- examples
|       |
|       '-- ... 
|
'-- README.md

```

