package br.com.igorribeirolima.fx.operator;

import br.com.igorribeirolima.fx.Expression;
import br.com.igorribeirolima.fx.Number;


class OperatorExponencial extends Expression {
  
  private static final String EXPRESSAO = "("+Number.REAL_NUMBER+ ")(("+Operator.EXP.regex()+")("+Number.REAL_NUMBER+"))";
  
  OperatorExponencial() {
    super(EXPRESSAO);
  }

  public Double calculate(String expressao) {
    String[] valores = expressao.split(Operator.EXP.regex());
    return Math.pow( Double.parseDouble(valores[0]), Double.parseDouble(valores[1]));
  }

}
