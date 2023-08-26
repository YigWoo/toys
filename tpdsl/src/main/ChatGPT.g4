grammar ChatGPT;

//  grammar generate by ChatGPT

expression      : logicalExpression EOF ;

logicalExpression : equalityExpression ((and | or) equalityExpression)* ;

equalityExpression : relationalExpression ((eq | neq) relationalExpression)* ;

relationalExpression : additionExpression ((lt | gt | le | ge) additionExpression)* ;

additionExpression : term (plus term | minus term)* ;

term               : factor (mul factor | div factor)* ;

factor             : INTEGER | DECIMAL | identifier | methodCall | memberAccess | linq | LPAREN expression RPAREN ;


methodCall         : identifier LPAREN (expression (COMMA expression)*)? RPAREN ;

memberAccess       : expression DOT identifier ;

linq               : from clauseList select (expression | aggregateFunc LPAREN expression RPAREN) ;

clauseList         : clause clauseList | clause ;

clause             : rangeVariable in expression (join rangeVariable on expression eq expression)?
                    | where expression
                    | group by expression
                    | order by expression (asc | desc)? ;

rangeVariable      : identifier ;

aggregateFunc      : sum | min | max | avg | count ;

INTEGER           : [0-9]+ ;
DECIMAL           : [0-9]+ '.' [0-9]+ ;

and               : '&&' ;
or                : '||' ;
eq                : '==' ;
neq               : '!=' ;
lt                : '<' ;
gt                : '>' ;
le                : '<=' ;
ge                : '>=' ;
plus              : '+' ;
minus             : '-' ;
mul               : '*' ;
div               : '/' ;
LPAREN            : '(' ;
RPAREN            : ')' ;
COMMA             : ',' ;
from              : 'from' ;
select            : 'select' ;
in                : 'in' ;
join              : 'join' ;
on                : 'on' ;
where             : 'where' ;
group             : 'group' ;
by                : 'by' ;
order             : 'order' ;
asc               : 'asc' ;
desc              : 'desc' ;
DOT               : '.' ;
sum               : 'sum' ;
min               : 'min' ;
max               : 'max' ;
avg               : 'avg' ;
count             : 'count' ;

identifier         : [a-zA-Z][a-zA-Z0-9_]* ;


WS                : [ \t\r\n]+ -> skip ;
