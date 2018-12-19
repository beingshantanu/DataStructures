package com.company.packageMain;

import com.company.operations.Operation;

public class ArithmaticEvaluationMain {
    public static void main(String[] args) {
        //String expression = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        String expression = "100 * ( 2 + 12 ))";
        Double val = new Operation()
                .evaluateArithMaticExpression(expression);
        if (val == null) {
            System.out.println("Give \"(\" at the start and \")\" at the end of the expression");
        } else {
            System.out.println(val);
        }
    }

}
