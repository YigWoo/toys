grammar LibExpr;
import CommonLexerRules;

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