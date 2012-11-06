package br.com.igorribeirolima.fx.regex;

import br.com.igorribeirolima.fx.api.RegexEnum;
import br.com.igorribeirolima.fx.function.Function;


public enum RegexFunction implements RegexEnum {
  IF  ("IF" , "[I][F][(]"    + RegexExpression.GENERIC_EXPRESSION + "[,]" + RegexExpression.GENERIC_EXPRESSION + "[,]" + RegexExpression.GENERIC_EXPRESSION + "[)]" ),
  AND ("AND", "[A][N][D][(]" + RegexExpression.GENERIC_EXPRESSION +"([,]" + RegexExpression.GENERIC_EXPRESSION + ")*[)]" ),
  OR  ("OR" , "[O][R][(]"    + RegexExpression.GENERIC_EXPRESSION +"([,]" + RegexExpression.GENERIC_EXPRESSION + ")*[)]"  ),
  NOT ("NOT", "[N][O][T][(]" + RegexExpression.GENERIC_EXPRESSION + "[)]" ),
  HourToNumber ("HourToNumber", "[H][o][u][r][T][o][N][u][m][b][e][r][(]" + RegexExpression.GENERIC_EXPRESSION + "[)]" )
  ;
  
  private final String symbol;
  private final String regex;
  
  private RegexFunction(String symbol, String regex) {
    this.symbol = symbol;
    this.regex = regex;
  }
  
  public String symbol() {
    return this.symbol;
  }
  
  public String regex() {
    return this.regex;
  }
  
  public static String regexFunctions() {
    String regex = "";
    for (Function funcao : Function.values())
      regex += regex.isEmpty() ? "("+funcao.regex()+")" : "|(" + funcao.regex() + ")";
    
    return regex;
  }
  
}
