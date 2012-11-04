package br.com.igorribeirolima.fx.operator;

import br.com.igorribeirolima.fx.api.Expression;
import br.com.igorribeirolima.fx.regex.RegexNumber;


class OperatorDivisao extends Expression {
  
  private static final String EXPRESSAO = "("+RegexNumber.REAL_NUMBER+ ")(("+Operator.DIVISAO.regex()+")("+RegexNumber.REAL_NUMBER+"))";
  
  OperatorDivisao() {
    super(EXPRESSAO);
  }

  public Double calculate(String expressao) {
    String[] valores = expressao.split(Operator.DIVISAO.regex());
    return Double.parseDouble(valores[0])/Double.parseDouble(valores[1]);
  }

}
