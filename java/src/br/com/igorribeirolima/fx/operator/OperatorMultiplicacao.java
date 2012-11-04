package br.com.igorribeirolima.fx.operator;

import br.com.igorribeirolima.fx.api.Expression;
import br.com.igorribeirolima.fx.regex.RegexNumber;


class OperatorMultiplicacao extends Expression {
  
  private static final String EXPRESSAO = "("+RegexNumber.REAL_NUMBER+ ")(("+Operator.MULTIPACACAO.regex()+")("+RegexNumber.REAL_NUMBER+"))";
  
  OperatorMultiplicacao() {
    super(EXPRESSAO);
  }

  public Double calculate(String expressao) {
    String[] valores = expressao.split(Operator.MULTIPACACAO.regex());
    return Double.parseDouble(valores[0])*Double.parseDouble(valores[1]);
  }

}
