package br.com.igorribeirolima.fx.expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.igorribeirolima.fx.api.Calculavel;
import br.com.igorribeirolima.fx.api.CalculavelFactory;
import br.com.igorribeirolima.fx.api.Fx;
import br.com.igorribeirolima.fx.factory.FxFactory;
import br.com.igorribeirolima.fx.regex.RegexExpression;

class SimpleExpression implements Fx {
  
  private CalculavelFactory factory = new FxFactory();
  
  public Double calc(String expression) {
    
    if (Pattern.matches(RegexExpression.SIMPLE_EXPRESSION, expression)) {
      Pattern pattern = Pattern.compile(RegexExpression.OPERATORS);
      Matcher matcher = pattern.matcher(expression);
      String symbol = null;
      while (matcher.find()) symbol = matcher.group(); //pegar o ultimo operador
      Calculavel calculavel = factory.get(symbol);
      return calculavel.calculate(expression);
    }else{
      throw new RuntimeException( "Expressao invalida" );
    }
    
  }
  
}
