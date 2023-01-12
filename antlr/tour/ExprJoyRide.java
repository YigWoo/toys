import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExprJoyRide {

    public static void main(String[] args) throws IOException {
        InputStream is;
        if (args.length > 0 && args[0] != null) {
            is = new FileInputStream(args[0]);
        } else {
            is = System.in;
        }

        ANTLRInputStream input = new ANTLRInputStream(is);


        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.prog();
        System.out.println(tree.toStringTree(parser));
    }

}
