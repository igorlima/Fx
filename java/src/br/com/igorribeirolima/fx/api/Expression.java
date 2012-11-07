package br.com.igorribeirolima.fx.api;

import java.util.regex.Pattern;

public abstract class Expression {
  
  public static final Fx fx = Expression.fx();
  
  private final String expression;
  
  protected Expression(String expression) {
    this.expression = expression;
  }
  
  public abstract Double calculate(String expressao);
  
  public boolean isValid(String expressao) {
    return Pattern.matches(this.expression, expressao);
  }
  
  public static Fx fx(){
    Fx fx = null;
    try {
		Class<?> fxClass = Class.forName("br.com.igorribeirolima.fx.expression.MathExpression");
		fx = (Fx) fxClass.newInstance();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (InstantiationException e) {
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	}
    return fx;
  }
  
}
