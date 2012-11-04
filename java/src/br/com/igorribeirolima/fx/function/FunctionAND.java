package br.com.igorribeirolima.fx.function;

import br.com.igorribeirolima.fx.api.Expression;
import br.com.igorribeirolima.fx.operator.Operator;


class FunctionAND extends Expression {
  
  protected FunctionAND() {
    super(Function.AND.regex());
  }

  public Double calculate(String expression) {
    String expressionAND = "";
    String[] valores = Function.AND.takeOfFunctionName(expression).split(",");
    if (valores.length==1) return fx.calc(valores[0]).equals(1.0) ? 1.0 : 0.0;
    
    for (String value : valores)
      expressionAND += expressionAND.isEmpty() ? fx.calc(value) : Operator.AND.symbol() + fx.calc(value); 
    
    return fx.calc(expressionAND);
    
  }

}
