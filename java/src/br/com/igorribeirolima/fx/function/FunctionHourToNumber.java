package br.com.igorribeirolima.fx.function;

import br.com.igorribeirolima.fx.api.Expression;
import br.com.igorribeirolima.fx.operator.Operator;


class FunctionHourToNumber extends Expression {
  
  protected FunctionHourToNumber() {
    super(Function.HourToNumber.regex());
  }

  public Double calculate(String expression) {
    String expressionOR = "";
    String[] valores = Function.HourToNumber.takeOfFunctionName(expression).split(":");
    Double result = 0.0;
    for (String value : valores)
      expressionOR += expressionOR.isEmpty() ? fx.calc(value) : Operator.OR.symbol() + fx.calc(value); 
    
    return fx.calc(expressionOR);
    
  }

}
