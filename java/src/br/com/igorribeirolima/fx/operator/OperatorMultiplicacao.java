package br.com.igorribeirolima.fx.operator;

import br.com.igorribeirolima.fx.Expression;
import br.com.igorribeirolima.fx.Number;


class OperatorMultiplicacao extends Expression {
  
  private static final String EXPRESSAO = "("+Number.REAL_NUMBER+ ")(("+Operator.MULTIPACACAO.regex()+")("+Number.REAL_NUMBER+"))";
  
  OperatorMultiplicacao() {
    super(EXPRESSAO);
  }

  public Double calculate(String expressao) {
    String[] valores = expressao.split(Operator.MULTIPACACAO.regex());
    return Double.parseDouble(valores[0])*Double.parseDouble(valores[1]);
  }

}
