package br.com.igorribeirolima.fx.function;

import br.com.igorribeirolima.fx.api.Expression;
import br.com.igorribeirolima.fx.operator.Operator;


class FunctionOR extends Expression {
  
  protected FunctionOR() {
    super(Function.OR.regex());
  }

  public Double calculate(String expression) {
    String expressionOR = "";
    String[] valores = Function.OR.takeOfFunctionName(expression).split(",");
    for (String value : valores)
      expressionOR += expressionOR.isEmpty() ? fx.calc(value) : Operator.OR.symbol() + fx.calc(value); 
    
    return fx.calc(expressionOR);
    
  }

}
