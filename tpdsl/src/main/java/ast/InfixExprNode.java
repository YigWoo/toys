package ast;

import lombok.Data;

@Data
public abstract class InfixExprNode extends ExprNode {
    private ExprNode left;
    private ExprNode right;

}
