package br.com.igorribeirolima.fx.operator;

import br.com.igorribeirolima.fx.api.Calculavel;
import br.com.igorribeirolima.fx.api.Expression;
import br.com.igorribeirolima.fx.api.RegexEnum;
import br.com.igorribeirolima.fx.regex.RegexOperator;

public enum Operator implements Calculavel {
  
  //Manter ordem de PRECEDÊNCIA
  EXP           (RegexOperator.EXP,           OperatorExponencial.class   ),
  MULTIPACACAO  (RegexOperator.MULTIPACACAO,  OperatorMultiplicacao.class ),
  DIVISAO       (RegexOperator.DIVISAO,       OperatorDivisao.class       ),
  SOMA          (RegexOperator.SOMA,          OperatorSoma.class          ),
  SUBTRACAO     (RegexOperator.SUBTRACAO,     OperatorSubtracao.class     ),
  IGUAL_QUE     (RegexOperator.IGUAL_QUE,     OperatorIgualQue.class      ),
  DIFERENTE_DE  (RegexOperator.DIFERENTE_DE,  OperatorDiferenteDe.class   ),
  MENOR_IGUAL   (RegexOperator.MENOR_IGUAL,   OperatorMenorIgual.class    ),
  MAIOR_IGUAL   (RegexOperator.MAIOR_IGUAL,   OperatorMaiorIgual.class    ),
  MAIOR_QUE     (RegexOperator.MAIOR_QUE,     OperatorMaiorQue.class      ),
  MENOR_QUE     (RegexOperator.MENOR_QUE,     OperatorMenorQue.class      ),
  AND           (RegexOperator.AND,           OperatorAND.class           ),
  OR            (RegexOperator.OR,            OperatorOR.class            )
  ;
  
  private final Class<?> className;
  private final RegexEnum regex;
  private Expression expressaoSimples;

  private Operator(RegexEnum regex, Class<?> className) {
	this.regex = regex;
    this.className = className;
  }
  
  @Override
  public String symbol() {
  	return regex.symbol();
  }
  
  @Override
  public String regex() {
  	return regex.regex();
  }
  
  public Expression expression() {
    try {
      if (expressaoSimples==null)
        this.expressaoSimples = (Expression) className.newInstance();
      return this.expressaoSimples;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  
  public Double calculate(String expressao) {
    return this.expression().calculate(expressao);
  }
  
  public boolean isValid(String expressao) {
    return this.expression().isValid(expressao);
  }
  
}
