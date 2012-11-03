package br.com.igorribeirolima.fx.operator;

import br.com.igorribeirolima.fx.Expression;


class OperatorDiferenteDe extends Expression {
  
  private static final String EXPRESSAO = "("+Expression.DIGIT+ ")(("+Operator.DIFERENTE_DE.regex()+")("+Expression.DIGIT+"))";
  
  OperatorDiferenteDe() {
    super(EXPRESSAO);
  }

  public Double calculate(String expressao) {
    String[] valores = expressao.split(Operator.DIFERENTE_DE.regex());
    
    Object firstSentence = convertDigitToObject(valores[0]);
    Object secondSentence = convertDigitToObject(valores[1]);
    
    if (!firstSentence.equals(secondSentence))
      return 1.0;
    else
      return 0.0;
  }

}
