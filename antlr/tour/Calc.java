import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Calc {

    public static void main(String[] args) throws IOException {
        InputStream is;
        if (args.length > 0 && args[0] != null) {
            is = new FileInputStream(args[0]);
        } else {
            is = System.in;
        }

        CharStream input = CharStreams.fromStream(is);

        LabeledExprLexer lexer = new LabeledExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokens);
        ParseTree tree = parser.prog();
        System.out.println(tree.toStringTree(parser));

        EvalVisitor eval = new EvalVisitor();
        eval.visit(tree);
    }
}
