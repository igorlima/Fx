package br.com.igorribeirolima.fx.operator;

import br.com.igorribeirolima.fx.api.Expression;
import br.com.igorribeirolima.fx.regex.RegexNumber;


class OperatorAND extends Expression {
  
  private static final String EXPRESSAO = "("+RegexNumber.REAL_NUMBER+ ")(("+Operator.AND.regex()+")("+RegexNumber.REAL_NUMBER+"))";
  
  OperatorAND() {
    super(EXPRESSAO);
  }

  public Double calculate(String expressao) {
    String[] valores = expressao.split(Operator.AND.regex());
    
    Double firstSentence = new Double(valores[0]);
    Double secondSentence = new Double(valores[1]);
    if (firstSentence.equals(1.0) && secondSentence.equals(1.0)) 
      return 1.0;
    else
      return 0.0;
  }

}
