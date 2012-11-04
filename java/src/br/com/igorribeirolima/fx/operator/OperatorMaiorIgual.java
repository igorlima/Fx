package br.com.igorribeirolima.fx.operator;

import br.com.igorribeirolima.fx.api.Expression;
import br.com.igorribeirolima.fx.regex.RegexNumber;


class OperatorMaiorIgual extends Expression {
  
  private static final String EXPRESSAO = "("+RegexNumber.REAL_NUMBER+ ")(("+Operator.MAIOR_IGUAL.regex()+")("+RegexNumber.REAL_NUMBER+"))";
  
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
