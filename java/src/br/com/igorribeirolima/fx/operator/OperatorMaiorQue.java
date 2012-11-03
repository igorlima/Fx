package br.com.igorribeirolima.fx.operator;

import br.com.igorribeirolima.fx.Expression;
import br.com.igorribeirolima.fx.Number;


class OperatorMaiorQue extends Expression {
  
  private static final String EXPRESSAO = "("+Number.REAL_NUMBER+ ")(("+Operator.MAIOR_QUE.regex()+")("+Number.REAL_NUMBER+"))";
  
  OperatorMaiorQue() {
    super(EXPRESSAO);
  }

  public Double calculate(String expressao) {
    String[] valores = expressao.split(Operator.MAIOR_QUE.regex());
    if (Double.parseDouble(valores[0])>Double.parseDouble(valores[1]))
      return 1.0;
    else
      return 0.0;
  }

}
