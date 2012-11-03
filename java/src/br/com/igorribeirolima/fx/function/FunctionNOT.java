package br.com.igorribeirolima.fx.function;

import br.com.igorribeirolima.fx.Expression;
import br.com.igorribeirolima.fx.Fx;
import br.com.igorribeirolima.fx.math.Math;


class FunctionNOT extends Expression {
  
  protected FunctionNOT() {
    super(Function.NOT.regex());
  }

  public Double calculate(String expression) {
    Fx fx = Math.fx();
    Double value = fx.calc( Function.NOT.takeOfFunctionName(expression) );
    
    if (value.equals(0.0))
      return 1.0;
    else
      return 0.0;
    
  }

}
