grammar Expr;

prog: stat+ ;

stat: expr NEWLINE
    | ID '=' expr NEWLINE
    | NEWLINE
    ;

expr: expr ('*' | '/') expr
    | expr ('+' | '-') expr
    | ID
    | INT
    | '(' expr ')'
    ;

ID  : [a-zA-Z]+ ;
INT : [0-9]+ ;
NEWLINE: '\r'? '\n';
WS  : [ \t]+ -> skip;

