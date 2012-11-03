package br.com.igorribeirolima.fx.operator;

import br.com.igorribeirolima.fx.Expression;
import br.com.igorribeirolima.fx.Number;


class OperatorMenorQue extends Expression {
  
  private static final String EXPRESSAO = "("+Number.REAL_NUMBER+ ")(("+Operator.MENOR_QUE.regex()+")("+Number.REAL_NUMBER+"))";
  
  OperatorMenorQue() {
    super(EXPRESSAO);
  }

  public Double calculate(String expressao) {
    String[] valores = expressao.split(Operator.MENOR_QUE.regex());
    if (Double.parseDouble(valores[0])<Double.parseDouble(valores[1]))
      return 1.0;
    else
      return 0.0;
  }

}
