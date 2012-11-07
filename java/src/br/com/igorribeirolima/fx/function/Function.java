package br.com.igorribeirolima.fx.function;

import br.com.igorribeirolima.fx.api.Calculavel;
import br.com.igorribeirolima.fx.api.Expression;
import br.com.igorribeirolima.fx.api.RegexEnum;
import br.com.igorribeirolima.fx.regex.RegexFunction;

public enum Function implements Calculavel {
  
  IF  (RegexFunction.IF,  FunctionIF.class),
  AND (RegexFunction.AND, FunctionAND.class),
  OR  (RegexFunction.OR,  FunctionOR.class),
  NOT (RegexFunction.NOT, FunctionNOT.class),
  HourToNumber (RegexFunction.HourToNumber, FunctionHourToNumber.class)
  ;
  
  private final RegexEnum regex;
  private final Class<?> className;
  private Expression simpleExpression;
  private Function(RegexEnum regex, Class<?> className) {
    this.regex = regex;
    this.className = className;
  }
  
  public String symbol() {
    return this.regex.symbol();
  }
  
  public String regex() {
    return this.regex.regex();
  }
  
  public Expression expression() {
    try {
      if (simpleExpression==null)
        this.simpleExpression = (Expression) className.newInstance();
      return this.simpleExpression;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  
  public Double calculate(String expression) {
    return this.expression().calculate(expression);
  }
  
  public boolean isValid(String expression) {
    return this.expression().isValid(expression);
  }
  
  public String takeOfFunctionName(String expression) {
    return expression.replaceAll(symbol()+"[(]", "").replaceAll("[)]", "" );
  }
  
}
