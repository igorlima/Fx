package br.com.igorribeirolima.fx.operator;

import br.com.igorribeirolima.fx.api.Expression;
import br.com.igorribeirolima.fx.regex.RegexNumber;


class OperatorMenorIgual extends Expression {
  
  private static final String EXPRESSAO = "("+RegexNumber.REAL_NUMBER+ ")(("+Operator.MENOR_IGUAL.regex()+")("+RegexNumber.REAL_NUMBER+"))";
  
  OperatorMenorIgual() {
    super(EXPRESSAO);
  }

  public Double calculate(String expressao) {
    String[] valores = expressao.split(Operator.MENOR_IGUAL.regex());
    if (Double.parseDouble(valores[0])<=Double.parseDouble(valores[1]))
      return 1.0;
    else
      return 0.0;
  }

}
