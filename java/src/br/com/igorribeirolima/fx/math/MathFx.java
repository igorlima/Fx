package br.com.igorribeirolima.fx.math;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.igorribeirolima.fx.Calculavel;
import br.com.igorribeirolima.fx.Expression;
import br.com.igorribeirolima.fx.Fx;
import br.com.igorribeirolima.fx.Number;
import br.com.igorribeirolima.fx.function.Function;
import br.com.igorribeirolima.fx.operator.Operator;

class MathFx implements Fx {

  protected Double calculateSimpleExpression(String expression) {
    
    if (Pattern.matches(Expression.SIMPLE_EXPRESSION, expression)) {
      Pattern pattern = Pattern.compile(Expression.OPERATORS);
      Matcher matcher = pattern.matcher(expression);
      String symbol = null;
      while (matcher.find()) symbol = matcher.group(); //pegar o ultimo operador
      Calculavel calculavel = Operator.get(symbol);
      return calculavel.calculate(expression);
    }else{
      throw new RuntimeException( "Expressao invalida" );
    }
    
  }
  
  public Double calc(String expression) {
    expression = clearBlanckSpace(expression);
    expression = calculateSimpleFuncions(expression);
    expression = calculateExpressions(expression);
    expression = calculateSimpleFuncions(expression);
    return calculateExpressionWithoutParentesis(expression);
  }
  
  private String calculateSimpleFuncions(String expression) {
    Pattern pattern = Pattern.compile(Function.regexFunctions());
    Matcher matcher = pattern.matcher(expression);
    
    while (matcher.find()) {
      String function = matcher.group();
      String symbol = getSymbolFromFunctionExpression(function);
      Double value = Function.get(symbol).calculate(function);
      expression = expression.replace( function, value.toString());
      matcher = pattern.matcher(expression);
    }
    return expression;
  }
  
  private String calculateExpressions(String expression) {
    
    Pattern pattern = Pattern.compile("[(]"+Expression.GENERIC_EXPRESSION+ "[)]");
    Matcher matcher = pattern.matcher(expression);
    
    while (matcher.find()) {
      String genericExpression = matcher.group();
      Double value = calculateExpressionWithoutParentesis(genericExpression.replace("(","").replace(")",""));
      expression = expression.replace( genericExpression, value.toString());
      matcher = pattern.matcher(expression);
    }
    
    return expression;
  }
  
  protected Double calculateExpressionWithoutParentesis(String expression) {
    expression = ajustarInicioDeExpressao(expression);
    
    if (!Pattern.matches(Expression.GENERIC_EXPRESSION, expression))
      throw new RuntimeException("Expressao invalida");
    
    //Manter ordem de PRECEDÊNCIA
    for (Operator operador : Operator.values()){
      Pattern pattern = Pattern.compile("("+Expression.DIGIT+ ")(("+ operador.regex() +")("+Expression.DIGIT+"))");
      Matcher matcher = pattern.matcher(expression);
      
      //Enquanto encontrar expressaoSimples, calcule-as e atualize expressao
      while (matcher.find()) {
        String expressaoSimples = matcher.group();
        boolean startWithOperador = expressaoSimples.startsWith("+") || expressaoSimples.startsWith("-");
        expression = expression.replace(expressaoSimples, (startWithOperador?"+":"") + calculateSimpleExpression(expressaoSimples).toString());
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
  
  /**
   * Os espaços entre parenteses não serão excluídos
   * @param expressao
   * @return
   */
  protected String clearBlanckSpace( String expressao ) {
    expressao = expressao.replace( "\n", "" );
    
    boolean betweenParentesis = false;
    String strCleaning = "";
    char[] characters = expressao.toCharArray();
    for (char c : characters) {
      if (c=='\"') betweenParentesis = !betweenParentesis;
      if (!betweenParentesis && c==' ') continue; 
      strCleaning+=c;
    }
    
    return strCleaning;
  }
  
  private String getExpressionBetweenParentesis( String expressao ) {
    int indexAbreParentese = expressao.lastIndexOf( '(' )+1;
    int indexFechaParentese = expressao.indexOf( ')', expressao.lastIndexOf( '(' ) );
    return expressao.substring(indexAbreParentese, indexFechaParentese);
  }
  
  private String getSymbolFromFunctionExpression(String function) {
    return function.substring(0, function.indexOf("("));
  }
  
  /**
   * 
   * @param expressao expresao que deseja verificar os parenteses, ou colchetes
   * @param charAbre 
   * @param charFecha
   * @return
   */
  public boolean hasParentesisOK( String expressao, Character charAbre, Character charFecha ){
    Stack<Character> pilha = new Stack<Character>();
    
    Pattern pattern = Pattern.compile("(\\"+charAbre+"|\\"+charFecha+")");
    Matcher matcher = pattern.matcher(expressao);
    
    //Enquanto existe caracteres de abertura e fechamento de expressao faca
    while (matcher.find()) {
      
      //Se encontrar um caracter de abertura, empilha
      if (matcher.group().equals(""+charAbre))
        pilha.push(charAbre);
      
      //Se encontrar um caracter de fechamento, desempilha
      if (matcher.group().equals(""+charFecha)) try {
        //Caso lanca uma excessao (pilha vazia), eh pq a abertura e fechamento dos caracteres nao casaram
        pilha.pop();
      }catch (EmptyStackException  emptyStackException) {
        return false;
      }
      
    }
    
    //Se a pilha estiver vazia, eh pq todas as aberturas e fechamentos dos caracteres casaram
    //Caso contrario, nao houve casamento de pelo menos uma abetura e fechamento de caracter
    return pilha.isEmpty() ? true : false;
    
  }
  
  
  /**
   * 
   * @param expressao string da expressao que deseja verificar se eh valida
   * @return
   */
  public boolean isValid(String expressao) {
    
    //verificar se os parenteses da expressao estao corretos
    if (!hasParentesisOK(expressao, '(', ')')) return false;
    
    //Para fins de verificacao, caso haja incognitas, substitua por zero 
    expressao = expressao.replaceAll(Number.INCOGNITAS, ""+0.0);
    //Remover todos os espacos em branco
    expressao = clearBlanckSpace(expressao);
    
    //'Calcular' todas as expressoes dentro dos parenteses
    while (expressao.contains("(")) try {
      String expressaoEntreParentese = getExpressionBetweenParentesis(expressao);
      expressao = expressao.replace( "("+expressaoEntreParentese+")", "0.0");
    }catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      return false;
    }
    
    return Pattern.matches(Expression.GENERIC_EXPRESSION, expressao) ? true : false;
    
  }
  
}
