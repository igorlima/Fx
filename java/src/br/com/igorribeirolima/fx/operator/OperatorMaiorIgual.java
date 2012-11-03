package br.com.igorribeirolima.fx.operator;

import br.com.igorribeirolima.fx.Expression;
import br.com.igorribeirolima.fx.Number;


class OperatorMaiorIgual extends Expression {
  
  private static final String EXPRESSAO = "("+Number.REAL_NUMBER+ ")(("+Operator.MAIOR_IGUAL.regex()+")("+Number.REAL_NUMBER+"))";
  
  OperatorMaiorIgual() {
    super(EXPRESSAO);
  }

  public Double calculate(String expressao) {
    String[] valores = expressao.split(Operator.MAIOR_IGUAL.regex());
    if (Double.parseDouble(valores[0])>=Double.parseDouble(valores[1]))
      return 1.0;
    else
      return 0.0;
  }

}
