package com.simple;


import com.simple.bean.BaseSplitData;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void contains(){
        List<BaseSplitData> list = new ArrayList<>();
        BaseSplitData baseSplitData = new BaseSplitData();
        baseSplitData.setSystemNum(3);
        baseSplitData.setShopId(11493L);
        list.add(baseSplitData);
        list.add(baseSplitData);
        String rule = "',11493,11494,11495,11496,11497,11498,11499,11500,11501,326726,326728,10942'.contains(\",\" + #P1[0].shopId + \",\")";
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression(rule);
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("P1", list);
        Object obj = expression.getValue(context);
        System.out.println("EL value: " + obj);
    }

    @Test
    public void fist() {
        String rule = "#P1 == \"TBITSTORE19\"";
        String shopCode = "TBITSTORE19";
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression(rule);
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("P1", shopCode);
        Object obj = expression.getValue(context);
        System.out.println("EL value: " + obj);
    }
}
