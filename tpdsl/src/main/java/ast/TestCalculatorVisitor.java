package ast;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class TestCalculatorVisitor {

    public static void main(String[] args) throws IOException {
        CharStream input = null;
        if ( args.length>0 ) input = new ANTLRFileStream(args[0]);
        else input = new ANTLRInputStream(System.in);

        VecMathLexer lexer = new VecMathLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        VecMathParser parser = new VecMathParser(tokens);
        VecMathParser.CompileUnitContext parseTree = parser.compileUnit();


        ASTBuilder astBuilder = new ASTBuilder();
        ExprNode ast = astBuilder.visitCompileUnit(parseTree);
        Double value = new CalculateASTVisitor().visit(ast);

        System.out.println(value);
    }
}
