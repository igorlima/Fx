package br.com.igorribeirolima.fx.operator;

import br.com.igorribeirolima.fx.Expression;
import br.com.igorribeirolima.fx.Number;


class OperatorOR extends Expression {
  
  private static final String EXPRESSAO = "("+Number.REAL_NUMBER+ ")(("+Operator.OR.regex()+")("+Number.REAL_NUMBER+"))";
  
  OperatorOR() {
    super(EXPRESSAO);
  }

  public Double calculate(String expressao) {
    String[] valores = expressao.split(Operator.OR.regex());
    
    Double firstSentence = new Double(valores[0]);
    Double secondSentence = new Double(valores[1]);
    if (firstSentence.equals(1.0) || secondSentence.equals(1.0)) 
      return 1.0;
    else
      return 0.0;
  }

}
