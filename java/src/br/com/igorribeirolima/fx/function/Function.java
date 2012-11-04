package br.com.igorribeirolima.fx.function;

import java.util.HashMap;
import java.util.Map;

import br.com.igorribeirolima.fx.api.Calculavel;
import br.com.igorribeirolima.fx.api.Expression;
import br.com.igorribeirolima.fx.regex.RegexExpression;

public enum Function implements Calculavel {
  
  IF  (FunctionIF.class , "IF" , "[I][F][(]"    + RegexExpression.GENERIC_EXPRESSION + "[,]" + RegexExpression.GENERIC_EXPRESSION + "[,]" + RegexExpression.GENERIC_EXPRESSION + "[)]" ),
  AND (FunctionAND.class, "AND", "[A][N][D][(]" + RegexExpression.GENERIC_EXPRESSION +"([,]" + RegexExpression.GENERIC_EXPRESSION + ")*[)]" ),
  OR  (FunctionOR.class,  "OR" , "[O][R][(]"    + RegexExpression.GENERIC_EXPRESSION +"([,]" + RegexExpression.GENERIC_EXPRESSION + ")*[)]"  ),
  NOT (FunctionNOT.class, "NOT", "[N][O][T][(]" + RegexExpression.GENERIC_EXPRESSION + "[)]" )
  ;
  
  private static final Map<String,Calculavel> map = new HashMap<String, Calculavel>();
  private final String symbol;
  private final String regex;
  private final Class<?> className;
  private Expression simpleExpression;
  private Function(Class<?> className, String symbol, String regex) {
    this.symbol = symbol;
    this.regex = regex;
    this.className = className;
  }
  
  public String symbol() {
    return this.symbol;
  }
  
  public String regex() {
    return this.regex;
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
  
  public static String regexFunctions() {
    String regex = "";
    for (Function funcao : Function.values())
      regex += regex.isEmpty() ? "("+funcao.regex()+")" : "|(" + funcao.regex() + ")";
    
    return regex;
  }
  
  public static Calculavel get(String symbol) {
    if (map.isEmpty())
      for (Function funcao : Function.values()) 
        map.put(funcao.symbol(), funcao);
    
    return map.get(symbol);
  }
  
}
