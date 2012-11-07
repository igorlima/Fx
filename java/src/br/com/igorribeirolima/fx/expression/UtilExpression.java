package br.com.igorribeirolima.fx.expression;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.igorribeirolima.fx.regex.RegexExpression;
import br.com.igorribeirolima.fx.regex.RegexNumber;

class UtilExpression {
  
  /**
   * Os espaços entre parenteses não serão excluídos
   * @param expressao
   * @return
   */
  protected static String clearBlanckSpace( String expressao ) {
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
  
  public static String getExpressionBetweenParentesis( String expressao ) {
    int indexAbreParentese = expressao.lastIndexOf( '(' )+1;
    int indexFechaParentese = expressao.indexOf( ')', expressao.lastIndexOf( '(' ) );
    return expressao.substring(indexAbreParentese, indexFechaParentese);
  }
  
  /**
   * 
   * @param expressao expresao que deseja verificar os parenteses, ou colchetes
   * @param charAbre 
   * @param charFecha
   * @return
   */
  public static boolean hasParentesisOK( String expressao, Character charAbre, Character charFecha ){
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
  public static boolean isValid(String expressao) {
    
    //verificar se os parenteses da expressao estao corretos
    if (!hasParentesisOK(expressao, '(', ')')) return false;
    
    //Para fins de verificacao, caso haja incognitas, substitua por zero 
    expressao = expressao.replaceAll(RegexNumber.INCOGNITAS, ""+0.0);
    //Remover todos os espacos em branco
    expressao = clearBlanckSpace(expressao);
    
    //'Calcular' todas as expressoes dentro dos parenteses
    while (expressao.contains("(")) try {
      String expressaoEntreParentese = getExpressionBetweenParentesis(expressao);
      expressao = expressao.replace( "("+expressaoEntreParentese+")", "0.0");
    }catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      return false;
    }
    
    return Pattern.matches(RegexExpression.GENERIC_EXPRESSION, expressao) ? true : false;
    
  }
}
