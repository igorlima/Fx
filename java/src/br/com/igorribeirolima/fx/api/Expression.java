package br.com.igorribeirolima.fx.api;

import java.util.regex.Pattern;

public abstract class Expression {
  
  public static Fx fx;
  private final String expression;
  
  protected Expression(String expression) {
    this.expression = expression;
  }
  
  public abstract Double calculate(String expressao);
  
  public boolean isValid(String expressao) {
    return Pattern.matches(this.expression, expressao);
  }
  
}
