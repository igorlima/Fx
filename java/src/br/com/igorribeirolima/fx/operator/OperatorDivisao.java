package br.com.igorribeirolima.fx.operator;

import br.com.igorribeirolima.fx.Expression;
import br.com.igorribeirolima.fx.Number;


class OperatorDivisao extends Expression {
  
  private static final String EXPRESSAO = "("+Number.REAL_NUMBER+ ")(("+Operator.DIVISAO.regex()+")("+Number.REAL_NUMBER+"))";
  
  OperatorDivisao() {
    super(EXPRESSAO);
  }

  public Double calculate(String expressao) {
    String[] valores = expressao.split(Operator.DIVISAO.regex());
    return Double.parseDouble(valores[0])/Double.parseDouble(valores[1]);
  }

}
