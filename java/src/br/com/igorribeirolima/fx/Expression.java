package br.com.igorribeirolima.fx;

import java.util.regex.Pattern;

import br.com.igorribeirolima.fx.operator.Operator;


public abstract class Expression {
  
  public static final String OPERATORS = Operator.regexOperators();
  public static final String CARACTER = "[a-zA-Z0-9_ãáàâêéíõóúüç ]";
  public static final String WORD = "([\"]("+CARACTER+"+)[\"])";
  public static final String DIGIT = "("+Number.DIGIT+"|"+WORD+")";
  public static final String SIMPLE_EXPRESSION = "("+DIGIT+ ")(("+ OPERATORS +")("+DIGIT+"))"; //suporta apenas a operacao entre dois numeros
  public static final String GENERIC_EXPRESSION = "("+DIGIT+ ")(("+ OPERATORS +")("+DIGIT+"))*";
  
  private final String expression;
  
  protected Expression(String expression) {
    this.expression = expression;
  }
  
  public abstract Double calculate(String expressao);
  
  public boolean isValid(String expressao) {
    return Pattern.matches(this.expression, expressao);
  }
  
  public static boolean isWord(String word) {
    return Pattern.matches(WORD, word);
  }
  
  public static boolean isNumber(String number) {
    return Pattern.matches(Number.DIGIT, number);
  }
  
  public static boolean isBrazilianNumber(String number) {
    return Pattern.matches(Number.BRAZILIAN_NUMBER, number);
  }
  
  public static Object convertDigitToObject(String digito) {
    if (isNumber(digito)) return new Double(digito);
    else if (isWord(digito)) return new String(digito);
    else return null;
  }
  
}
