// Generated from /Users/xiaobailian/Library/Mobile Documents/com~apple~CloudDocs/大文件 repo/ideaProjects/toys/tpdsl/src/main/java/ast/VecMath.g4 by ANTLR 4.10.1
package ast;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link VecMathParser}.
 */
public interface VecMathListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link VecMathParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompileUnit(VecMathParser.CompileUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link VecMathParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompileUnit(VecMathParser.CompileUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link VecMathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInfixExpr(VecMathParser.InfixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link VecMathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInfixExpr(VecMathParser.InfixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link VecMathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(VecMathParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link VecMathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(VecMathParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link VecMathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpr(VecMathParser.FuncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link VecMathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpr(VecMathParser.FuncExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link VecMathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(VecMathParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link VecMathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(VecMathParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link VecMathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParensExpr(VecMathParser.ParensExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link VecMathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParensExpr(VecMathParser.ParensExprContext ctx);
}