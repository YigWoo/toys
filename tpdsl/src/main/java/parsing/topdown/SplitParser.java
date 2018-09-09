package parsing.topdown;

/** */
public class SplitParser extends Parser {
    public SplitParser(Lexer input) { super(input); }
    
    /** list : '[' elements ']' ; // match bracketed list */
    public void list() {
        match(SplitLexer.LBRACK); elements(); match(SplitLexer.RBRACK);
    }

    /** elements : element (',' element)* ; // match comma-separated list */
    void elements() {
        element();
        while ( lookahead.type==SplitLexer.COMMA ) {
            match(SplitLexer.COMMA); element();
        }
    }

    /** element : name | list ; // element is name or nested list */
    void element() {
        if ( lookahead.type==SplitLexer.NAME ) match(SplitLexer.NAME);
        else if ( lookahead.type==SplitLexer.LBRACK ) list();
        else throw new Error("expecting name or list; found "+ lookahead);
    }

    public static void main(String[] args) {
        SplitLexer lexer = new SplitLexer(args[0]);
        SplitParser parser = new SplitParser(lexer);
        parser.list();
    }
}
