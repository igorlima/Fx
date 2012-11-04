package br.com.igorribeirolima.fx.operator;

import br.com.igorribeirolima.fx.api.Expression;
import br.com.igorribeirolima.fx.regex.RegexExpression;


class OperatorIgualQue extends Expression {
  
  private static final String EXPRESSAO = "("+RegexExpression.DIGIT+ ")(("+Operator.IGUAL_QUE.regex()+")("+RegexExpression.DIGIT+"))";
  
  OperatorIgualQue() {
    super(EXPRESSAO);
  }

  public Double calculate(String expressao) {
    String[] valores = expressao.split(Operator.IGUAL_QUE.regex());
    
    Object firstSentence = RegexExpression.convertDigitToObject(valores[0]);
    Object secondSentence = RegexExpression.convertDigitToObject(valores[1]);
    
    if (firstSentence.equals(secondSentence))
      return 1.0;
    else
      return 0.0;
  }

}
