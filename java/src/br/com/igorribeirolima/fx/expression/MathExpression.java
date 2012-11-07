package br.com.igorribeirolima.fx.expression;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.igorribeirolima.fx.api.Fx;

public class MathExpression implements Fx {
  
  private static final Map<Pattern, Fx> patterns = new HashMap<Pattern, Fx>();
  static {
	  patterns.put( GenericExpression.pattern, new GenericExpression() );
	  patterns.put( FunctionExpression.pattern, new FunctionExpression() );
  }
  
  private ManyExpression manyExpression = new ManyExpression();
  
  @Override
  public Double calc(String expression) {
    expression = UtilExpression.clearBlanckSpace(expression);
    Stack<Pattern> toCalc = new Stack<Pattern>();
    Stack<Pattern> calced = new Stack<Pattern>();
    for (Pattern pattern : patterns.keySet()) toCalc.add(pattern);
    
    while (!toCalc.isEmpty()) {
      Pattern pattern = toCalc.pop(); 
      Matcher matcher = pattern.matcher(expression);
      while (matcher.find()) {
        String subExpression = matcher.group();
        Double value = patterns.get(pattern).calc(subExpression);
        expression = expression.replace(subExpression, value.toString());
        matcher = pattern.matcher(expression);
        toCalc.addAll(calced);
        calced.clear();
      }
      calced.add(pattern);
    }
    
    return manyExpression.calc(expression);
  }
  
}
