package br.com.igorribeirolima.fx.function;

import br.com.igorribeirolima.fx.api.Expression;


class FunctionNOT extends Expression {
  
  protected FunctionNOT() {
    super(Function.NOT.regex());
  }

  public Double calculate(String expression) {
    Double value = fx.calc( Function.NOT.takeOfFunctionName(expression) );
    
    if (value.equals(0.0))
      return 1.0;
    else
      return 0.0;
    
  }

}
