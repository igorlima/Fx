package br.com.igorribeirolima.fx.function;

import br.com.igorribeirolima.fx.api.Expression;


class FunctionIF extends Expression {
  
  protected FunctionIF() {
    super(Function.IF.regex());
  }

  public Double calculate(String expression) {
    String[] valores = Function.IF.takeOfFunctionName(expression).split(",");
    
    if (fx.calc(valores[0]).equals(1.0))
      return fx.calc(valores[1]);
    else
      return fx.calc(valores[2]);
    
  }

}
