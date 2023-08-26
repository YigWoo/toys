package symtab.klass; /***
 * Excerpted from "Language Implementation Patterns",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpdsl for more book information.
***/

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

public class CymbolErrorNode extends CymbolAST {
    public CymbolErrorNode(TokenStream input, Token start, Token stop,
                            RecognitionException e)
    {
	super(start); // no need to record anything for this example
    }
}
