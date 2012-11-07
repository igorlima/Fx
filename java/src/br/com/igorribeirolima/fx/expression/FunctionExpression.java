package br.com.igorribeirolima.fx.expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.igorribeirolima.fx.api.CalculavelFactory;
import br.com.igorribeirolima.fx.api.Fx;
import br.com.igorribeirolima.fx.factory.FxFactory;
import br.com.igorribeirolima.fx.regex.RegexFunction;

class FunctionExpression implements Fx {
  
  private CalculavelFactory factory = new FxFactory();
  private ManyExpression manyExpression = new ManyExpression();
  protected final static String REGEX = RegexFunction.regexFunctions();
  protected final static Pattern pattern = Pattern.compile(FunctionExpression.REGEX);

  @Override
  public Double calc(String expression) {
    expression = calculateFuncions(expression);
    return manyExpression.calc(expression);
  }
  
  private String calculateFuncions(String expression) {
    
    Matcher matcher = pattern.matcher(expression);
    
    while (matcher.find()) {
      String function = matcher.group();
      String symbol = getSymbolFromFunctionExpression(function);
      Double value = factory.get(symbol).calculate(function);
      expression = expression.replace( function, value.toString());
      matcher = pattern.matcher(expression);
    }
    return expression;
  }
  
  private String getSymbolFromFunctionExpression(String function) {
    return function.substring(0, function.indexOf("("));
  }
  
}
