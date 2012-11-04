package br.com.igorribeirolima.fx.operator;

import br.com.igorribeirolima.fx.api.Expression;
import br.com.igorribeirolima.fx.regex.RegexNumber;


class OperatorMaiorQue extends Expression {
  
  private static final String EXPRESSAO = "("+RegexNumber.REAL_NUMBER+ ")(("+Operator.MAIOR_QUE.regex()+")("+RegexNumber.REAL_NUMBER+"))";
  
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
