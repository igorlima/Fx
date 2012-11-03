package br.com.igorribeirolima.fx.operator;

import br.com.igorribeirolima.fx.Expression;
import br.com.igorribeirolima.fx.Number;


class OperatorSoma extends Expression {
  
  private static final String EXPRESSAO = "("+Number.REAL_NUMBER+ ")(("+Operator.SOMA.regex()+")("+Number.REAL_NUMBER+"))";
  
  OperatorSoma(){
    super(EXPRESSAO);
  }

  public Double calculate(String expressao) {
    int index = expressao.lastIndexOf( Operator.SOMA.symbol() );
    String firstSentence = expressao.substring(0,index);
    String secondSentence = expressao.substring(index);
    return Double.parseDouble(firstSentence)+Double.parseDouble(secondSentence);
  }

}
