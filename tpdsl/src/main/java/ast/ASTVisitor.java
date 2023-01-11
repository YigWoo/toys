package ast;

public abstract class ASTVisitor<T> {

    public abstract T visit(AdditionNode node);

    public abstract T visit(DivisionNode node);

    public abstract T visit(MultiplicationNode node);

    public abstract T visit(SubtractNode node);

    public abstract T visit(NegateNode node);

    public abstract T visit(NumberNode node);

    public abstract T visit(FunctionNode node);

    public T visit(ExprNode node) {
        if (node instanceof AdditionNode) {
            return visit((AdditionNode) node);
        } else if (node instanceof SubtractNode) {
            return visit((SubtractNode) node);
        } else if (node instanceof MultiplicationNode) {
            return visit((MultiplicationNode) node);
        } else if (node instanceof DivisionNode) {
            return visit((DivisionNode) node);
        } else if (node instanceof NegateNode) {
            return visit((NegateNode) node);
        } else if (node instanceof NumberNode) {
            return visit((NumberNode) node);
        } else if (node instanceof FunctionNode) {
            return visit((FunctionNode) node);
        } else {
            throw new RuntimeException();
        }
    }


}
