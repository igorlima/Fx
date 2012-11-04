package br.com.igorribeirolima.fx.operator;

import br.com.igorribeirolima.fx.api.Expression;
import br.com.igorribeirolima.fx.regex.RegexNumber;


class OperatorExponencial extends Expression {
  
  private static final String EXPRESSAO = "("+RegexNumber.REAL_NUMBER+ ")(("+Operator.EXP.regex()+")("+RegexNumber.REAL_NUMBER+"))";
  
  OperatorExponencial() {
    super(EXPRESSAO);
  }

  public Double calculate(String expressao) {
    String[] valores = expressao.split(Operator.EXP.regex());
    return Math.pow( Double.parseDouble(valores[0]), Double.parseDouble(valores[1]));
  }

}
