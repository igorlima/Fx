package br.com.igorribeirolima.fx.expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.igorribeirolima.fx.api.Fx;
import br.com.igorribeirolima.fx.operator.Operator;
import br.com.igorribeirolima.fx.regex.RegexExpression;

class ManyExpression implements Fx {
  
  private SimpleExpression simpleExpression = new SimpleExpression();
  
  public Double calc(String expression) {
    expression = ajustarInicioDeExpressao(expression);
    
    if (!Pattern.matches(RegexExpression.GENERIC_EXPRESSION, expression))
      throw new RuntimeException("Expressao invalida");
    
    //Manter ordem de PRECEDÊNCIA
    for (Operator operador : Operator.values()){
      Pattern pattern = Pattern.compile("("+RegexExpression.DIGIT+ ")(("+ operador.regex() +")("+RegexExpression.DIGIT+"))");
      Matcher matcher = pattern.matcher(expression);
      
      //Enquanto encontrar expressaoSimples, calcule-as e atualize expressao
      while (matcher.find()) {
        String expressaoSimples = matcher.group();
        boolean startWithOperador = expressaoSimples.startsWith("+") || expressaoSimples.startsWith("-");
        expression = expression.replace(expressaoSimples, (startWithOperador?"+":"") + simpleExpression.calc(expressaoSimples).toString());
        expression = calculationBetweenOperators(expression); //Evitar para que NÃO ocorra de ter dois operandos juntos
        matcher = pattern.matcher(expression);
      }
      
    }
    
    try{
      return Double.parseDouble(expression);
    }catch (NumberFormatException numberFormatException) {
      throw new RuntimeException("Nao foi possivel calcular expressao. Possivelmente alguma operacao nao foi implementada");
    }
  }
  
  /**
   * Evitar para que NÃO ocorra de ter dois operandos juntos 
   * @param expression
   * @return
   */
  private String calculationBetweenOperators(String expression) {
    return expression
        .replaceAll( "\\+\\+", "+")
        .replaceAll( "\\+\\-", "-")
        .replaceAll( "\\-\\+", "-")
        .replaceAll( "\\-\\-", "+");
  }
  
  private String ajustarInicioDeExpressao( String expressao ) {
    if (expressao.startsWith("+") || expressao.startsWith("-"))
      return "0" + expressao;
    else
      return expressao;
  }
  
}
