package br.com.igorribeirolima.fx.operator;

import br.com.igorribeirolima.fx.Expression;


class OperatorIgualQue extends Expression {
  
  private static final String EXPRESSAO = "("+Expression.DIGIT+ ")(("+Operator.IGUAL_QUE.regex()+")("+Expression.DIGIT+"))";
  
  OperatorIgualQue() {
    super(EXPRESSAO);
  }

  public Double calculate(String expressao) {
    String[] valores = expressao.split(Operator.IGUAL_QUE.regex());
    
    Object firstSentence = convertDigitToObject(valores[0]);
    Object secondSentence = convertDigitToObject(valores[1]);
    
    if (firstSentence.equals(secondSentence))
      return 1.0;
    else
      return 0.0;
  }

}
