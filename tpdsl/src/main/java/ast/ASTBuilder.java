package ast;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class ASTBuilder extends VecMathBaseVisitor<ExprNode> {
    @Override
    public ExprNode visitCompileUnit(VecMathParser.CompileUnitContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public ExprNode visitNumberExpr(VecMathParser.NumberExprContext ctx) {
        return new NumberNode(Double.parseDouble(ctx.getText()));
    }

    @Override
    public ExprNode visitParensExpr(VecMathParser.ParensExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public ExprNode visitInfixExpr(VecMathParser.InfixExprContext ctx) {
        InfixExprNode node;
        switch (ctx.op.getType()) {
            case VecMathLexer.OP_ADD:
                node = new AdditionNode();
                break;
            case VecMathLexer.OP_DIV:
                node = new DivisionNode();
                break;
            case VecMathLexer.OP_MUL:
                node = new MultiplicationNode();
                break;
            case VecMathLexer.OP_SUB:
                node = new SubtractNode();
                break;
            default:
                throw new RuntimeException("Operation Not Supported");
        }
        visit(ctx.left);
        visit(ctx.right);
        return node;
    }

    @Override
    public ExprNode visitUnaryExpr(VecMathParser.UnaryExprContext ctx) {
        switch (ctx.op.getType()) {
            case VecMathLexer.OP_ADD:
                return visit(ctx.expr());
            case VecMathLexer.OP_SUB:
                return new NegateNode(visit(ctx.expr()));
        }

        throw new RuntimeException("Operation Not Supported");
    }

    @Override
    public ExprNode visitFuncExpr(VecMathParser.FuncExprContext ctx) {
        Optional<Method> mathMethod = Arrays.stream(Math.class.getMethods())
                .filter(method -> Objects.equals(method.getName(), ctx.ID().getText())
                        && Objects.equals(method.getParameters()[0].getType(), double.class)
                        && Objects.equals(method.getReturnType(), double.class))
                .findFirst();

        if (mathMethod.isPresent()) {
            ExprNode arguments = visit(ctx.expr());
            Method method = mathMethod.get();
            return new FunctionNode(method, arguments);
        } else {
            throw new RuntimeException();
        }
    }
}
