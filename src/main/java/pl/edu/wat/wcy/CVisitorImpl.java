package pl.edu.wat.wcy;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

public class CVisitorImpl<T> extends CBaseVisitor<T> {

    private ProgramParams params = new ProgramParams();

    @Override
    public T visitPostfixExpression(CParser.PostfixExpressionContext ctx) {
        if (ctx.getChildCount() == 2) {
            String operator = getChildContent(ctx, 1);
            if (isUnaryOperator(operator)) {
                params.addOperator(operator);
                if (isOperand(ctx.getChild(0))) {
                    params.addOperand(getChildContent(ctx, 0));
                }
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public T visitUnaryExpression(CParser.UnaryExpressionContext ctx) {
        if (ctx.getChildCount() == 2) {
            String operator = getChildContent(ctx, 0);
            if (isUnaryOperator(operator) || isLogicalNotOperator(operator)) {
                params.addOperator(operator);
                if (isOperand(ctx.getChild(0))) {
                    params.addOperand(getChildContent(ctx, 1));
                }
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public T visitMultiplicativeExpression(CParser.MultiplicativeExpressionContext ctx) {
        if (ctx.getChildCount() == 3) {
            String operator = getChildContent(ctx, 1);
            if (isMultiplicativeOperator(operator)) {
                params.addOperator(operator);
                if (isOperand(ctx.getChild(0))) {
                    params.addOperand(getChildContent(ctx, 0));
                }
                if (isOperand(ctx.getChild(2))) {
                    params.addOperand(getChildContent(ctx, 2));
                }
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public T visitAdditiveExpression(CParser.AdditiveExpressionContext ctx) {
        if (ctx.getChildCount() == 3) {
            String operator = getChildContent(ctx, 1);
            if (isAdditiveOperator(operator)) {
                params.addOperator(operator);
                if (isOperand(ctx.getChild(0))) {
                    params.addOperand(getChildContent(ctx, 0));
                }
                if (isOperand(ctx.getChild(2))) {
                    params.addOperand(getChildContent(ctx, 2));
                }
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public T visitRelationalExpression(CParser.RelationalExpressionContext ctx) {
        if (ctx.getChildCount() == 3) {
            String operator = getChildContent(ctx, 1);
            if (isRelationalOperator(operator)) {
                params.addOperator(operator);
                if (isOperand(ctx.getChild(0))) {
                    params.addOperand(getChildContent(ctx, 0));
                }
                if (isOperand(ctx.getChild(2))) {
                    params.addOperand(getChildContent(ctx, 2));
                }
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public T visitEqualityExpression(CParser.EqualityExpressionContext ctx) {
        if (ctx.getChildCount() == 3) {
            String operator = getChildContent(ctx, 1);
            if (isEqualityOperator(operator)) {
                params.addOperator(operator);
                if (isOperand(ctx.getChild(0))) {
                    params.addOperand(getChildContent(ctx, 0));
                }
                if (isOperand(ctx.getChild(2))) {
                    params.addOperand(getChildContent(ctx, 2));
                }
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public T visitLogicalAndExpression(CParser.LogicalAndExpressionContext ctx) {
        if (ctx.getChildCount() == 3) {
            String operator = getChildContent(ctx, 1);
            if (isLogicalAndOperator(operator)) {
                params.addOperator(operator);
                if (isOperand(ctx.getChild(0))) {
                    params.addOperand(getChildContent(ctx, 0));
                }
                if (isOperand(ctx.getChild(2))) {
                    params.addOperand(getChildContent(ctx, 2));
                }
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public T visitLogicalOrExpression(CParser.LogicalOrExpressionContext ctx) {
        if (ctx.getChildCount() == 3) {
            String operator = getChildContent(ctx, 1);
            if (isLogicalOrOperator(operator)) {
                params.addOperator(operator);
                if (isOperand(ctx.getChild(0))) {
                    params.addOperand(getChildContent(ctx, 0));
                }
                if (isOperand(ctx.getChild(2))) {
                    params.addOperand(getChildContent(ctx, 2));
                }
            }
        }
        return visitChildren(ctx);
    }

    private boolean isLogicalOrOperator(String operator) {
        return "||".equals(operator);
    }

    @Override
    public T visitAssignmentExpression(CParser.AssignmentExpressionContext ctx) {
        if (ctx.getChildCount() == 3) {
            String operator = getChildContent(ctx, 1);
            if (isAssignmentOperator(operator)) {
                params.addOperator(operator);
                if (isOperand(ctx.getChild(0))) {
                    params.addOperand(getChildContent(ctx, 0));
                }
                if (isOperand(ctx.getChild(2))) {
                    params.addOperand(getChildContent(ctx, 2));
                }
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public T visitInitDeclarator(CParser.InitDeclaratorContext ctx) {
        if (ctx.getChildCount() == 3) {
            String operator = getChildContent(ctx, 1);
            if ("=".equals(operator)) {
                params.addOperator(operator);
                params.addOperand(getChildContent(ctx, 0));
                params.addOperand(getChildContent(ctx, 2));
            }
        }
        return visitChildren(ctx);
    }

    private String getChildContent(ParserRuleContext ctx, int index) {
        return ctx.getChild(index).getText();
    }

    private boolean isUnaryOperator(String operator) {
        return "++".equals(operator) || "--".equals(operator);
    }

    private boolean isLogicalNotOperator(String operator) {
        return "!".equals(operator);
    }

    private boolean isMultiplicativeOperator(String operator) {
        return "*".equals(operator) || "/".equals(operator) || "%".equals(operator);
    }

    private boolean isAdditiveOperator(String operator) {
        return "+".equals(operator) || "-".equals(operator);
    }

    private boolean isRelationalOperator(String operator) {
        return "<".equals(operator) || "<=".equals(operator)
                || ">".equals(operator) || ">=".equals(operator);
    }

    private boolean isEqualityOperator(String operator) {
        return "==".equals(operator) || "!=".equals(operator);
    }

    private boolean isLogicalAndOperator(String operator) {
        return "&&".equals(operator);
    }

    private boolean isAssignmentOperator(String operator) {
        return "=".equals(operator) || "*=".equals(operator)
                || "/=".equals(operator) || "%=".equals(operator)
                || "+=".equals(operator) || "-=".equals(operator)
                || "<<=".equals(operator) || ">>=".equals(operator)
                || "&=".equals(operator) || "^=".equals(operator)
                || "|=".equals(operator);
    }

    private boolean isOperand(ParseTree node) {
        while (!"PostfixExpressionContext".equals(node.getClass().getSimpleName())) {
            if (node.getChildCount() == 2 && ("*".equals(node.getChild(0).getText())
                    || "-".equals(node.getChild(0).getText()))) {
                node = node.getChild(1);
            } else if (node.getChildCount() > 1) {
                return false;
            } else if (isTerminalNode(node)) {
                return true;
            } else {
                node = node.getChild(0);
            }
        }
        if (isPrimaryExpression(node)) {
            CParser.PrimaryExpressionContext primaryExpression = (CParser.PrimaryExpressionContext) node.getChild(0);
            return primaryExpression.getChildCount() == 1;
        } else if (node.getChildCount() == 3) {
            String text = node.getChild(1).getText();
            return ".".equals(text) || "->".equals(text);
        } else {
            return isArray(node);
        }
    }

    private boolean isTerminalNode(ParseTree node) {
        return node.getChildCount() == 0
                && "TerminalNodeImpl".equals(node.getClass().getSimpleName());
    }

    private boolean isPrimaryExpression(ParseTree node) {
        return node.getChildCount() == 1
                && "PrimaryExpressionContext".equals(node.getChild(0).getClass().getSimpleName());
    }

    private boolean isArray(ParseTree node) {
        return node.getChildCount() == 4
                && "[".equals(node.getChild(1).getText());
    }

    public ProgramParams getParams() {
        return params;
    }

}
