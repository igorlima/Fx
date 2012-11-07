package br.com.igorribeirolima.fx.expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.igorribeirolima.fx.api.Fx;
import br.com.igorribeirolima.fx.regex.RegexExpression;

class GenericExpression implements Fx {
  
  private ManyExpression manyExpression = new ManyExpression();
  
  public Double calc(String expression) {
    return manyExpression.calc( calculateExpressions(expression) );
  }
  
  protected String calculateExpressions(String expression) {
    
    Pattern pattern = Pattern.compile("[(]"+RegexExpression.GENERIC_EXPRESSION+ "[)]");
    Matcher matcher = pattern.matcher(expression);
    
    while (matcher.find()) {
      String genericExpression = matcher.group();
      Double value = manyExpression.calc(genericExpression.replace("(","").replace(")",""));
      expression = expression.replace( genericExpression, value.toString());
      matcher = pattern.matcher(expression);
    }
    
    return expression;
  }

}
