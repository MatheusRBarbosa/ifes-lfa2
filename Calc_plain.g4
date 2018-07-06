grammar Calc_plain;

program
    : statement+
    ;

statement
    : IDENT GETS expr SEMI
    | bexpr SEMI
    | if_expr
    | while_expr
    | block_expr
    | list_expr
    ;

expr
    : IDENT GETS expr
    | bexpr
    | if_expr
    | while_expr
    | block_expr
    | list_expr
    | STRING
    ;

if_expr
    : IF bexpr THEN expr
    | IF bexpr THEN expr ELSE expr
    ;

list_expr
     : LCOL arg_lista RCOL;

arg_lista
    : /* empty */
    | (STRING | INTEGER | FLOAT) (COMMA (STRING | INTEGER | FLOAT))*
    ;
/*str
    : ASPAS (CHAR_NO_NL)* ASPAS;
*/
while_expr
    : WHILE bexpr DO expr
    ;

block_expr
    : LBRC expr* RBRC
    ;

bexpr
    : conj (AND conj)*
    ;

conj
    : disj (OR disj)*
    ;

disj
    : aexpr (rel_op aexpr)?
    ;

rel_op
    : EQU
    | NEQ
    | GT
    | GEQ
    | LT
    | LEQ
    ;

aexpr
    : f1=fator
        (PLUS f2=fator
        | MINUS f2=fator
        )*
    ;

fator
    : t1=termo
        (TIMES t2=termo
        | DIVIDE t2=termo
        )*
    ;

termo
    : atomo (EXP atomo)*
    ;
       
atomo
    : MINUS t=atomo
    | PLUS t=atomo
    | NOT t=atomo
    | LPAR e=expr RPAR
    | func_call 
    | bool
    | ( INTEGER
      | FLOAT
      | IDENT
      )
    ;

bool
    : VERUM
    | FALSUM
    ;

func_call
    : IDENT LPAR arg_list RPAR
    ;

arg_list
    : /* empty */
    | expr (COMMA expr)*
    ;

LPAR    : '(' ;
RPAR    : ')' ;
LBRC    : '{' ;
RBRC    : '}' ;
PLUS    : '+' ;
MINUS   : '-' ;
TIMES   : '*' ;
DIVIDE  : '/' ;
EXP     : '^' ;
COMMA   : ',' ;
SEMI    : ';' ;
GETS    : '=' ;
EQU     : '==';
NEQ     : '!=';
GT      : '>';
GEQ     : '>=';
LT      : '<';
LEQ     : '<=';
AND     : '&&';
OR      : '||';
NOT     : '!';
VERUM   : 'true';
FALSUM  : 'false';
IF      : 'if';
THEN    : 'then';
ELSE    : 'else';
WHILE   : 'while';
DO      : 'do';
LCOL    : '[';
RCOL    : ']';
ASPAS   : '"';

fragment DIGIT  : [0-9] ;

INTEGER : DIGIT+ ;

FLOAT   : DIGIT+ '.' DIGIT* ([eE] (PLUS | MINUS) DIGIT+)?
        | '.' DIGIT+ ([eE] (PLUS | MINUS) DIGIT+)?
        ;

IDENT   : [_a-zA-Z] [_a-zA-Z0-9\']* ;

STRING  : '\"' ('\\' . | ~[\"\\])* '\"' ;

WS      : [ \t\r\n] -> skip;