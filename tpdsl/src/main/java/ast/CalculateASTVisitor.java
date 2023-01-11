package ast;

import java.lang.reflect.InvocationTargetException;

public class CalculateASTVisitor extends ASTVisitor<Double> {

    @Override
    public Double visit(AdditionNode node) {
        return visit(node.getLeft()) + visit(node.getRight());
    }

    @Override
    public Double visit(DivisionNode node) {
        return visit(node.getLeft()) / visit(node.getRight());
    }

    @Override
    public Double visit(MultiplicationNode node) {
        return visit(node.getLeft()) * visit(node.getRight());
    }

    @Override
    public Double visit(SubtractNode node) {
        return visit(node.getLeft()) - visit(node.getRight());
    }

    @Override
    public Double visit(NegateNode node) {
        return -visit(node.getInnerNode());
    }

    @Override
    public Double visit(NumberNode node) {
        return node.getValue();
    }

    @Override
    public Double visit(FunctionNode node) {
        try {
            return (Double) node.getMethod().invoke(null, visit(node.getArgument()));
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("invoke error");
    }
}
