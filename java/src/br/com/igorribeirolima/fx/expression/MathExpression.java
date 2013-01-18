package br.com.igorribeirolima.fx.expression;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.igorribeirolima.fx.api.Fx;

public class MathExpression implements Fx {
  
  private static enum Patterns {
    Generic(GenericExpression.pattern, new GenericExpression() ),
    Function(FunctionExpression.pattern, new FunctionExpression())
    ;
    
    private Pattern pattern;
    private Fx fx;
    
    private Patterns(Pattern pattern, Fx fx){
    
      this.pattern = pattern;
      this.fx = fx;
    }
    public Pattern get () {
      return this.pattern;
    }
    public Fx fx () {
      return this.fx;
    }
  }
  
  private ManyExpression manyExpression = new ManyExpression();
  
  @Override
  public Double calc(String expression) {
    expression = UtilExpression.clearBlanckSpace(expression);
    Stack<MathExpression.Patterns> toCalc = new Stack<MathExpression.Patterns>();
    Stack<MathExpression.Patterns> calced = new Stack<MathExpression.Patterns>();
    for (MathExpression.Patterns pattern : MathExpression.Patterns.values()) toCalc.add(pattern);
    
    while (!toCalc.isEmpty()) {
      MathExpression.Patterns pattern = toCalc.pop(); 
      Matcher matcher = pattern.get().matcher(expression);
      while (matcher.find()) {
        String subExpression = matcher.group();
        Double value = pattern.fx().calc(subExpression);
        expression = expression.replace(subExpression, value.toString());
        matcher = pattern.get().matcher(expression);
        toCalc.addAll(calced);
        calced.clear();
      }
      calced.add(pattern);
    }
    
    return manyExpression.calc(expression);
  }
  
}
