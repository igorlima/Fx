package br.com.igorribeirolima.fx;

import java.util.regex.Pattern;

public class Number {
  
  public static final String NOTACAO_CIENTIFICA = "(E\\-?[0-9]+)?"; //1.4210854715202004E-14
  public static final String BRAZILIAN_NUMBER_WITHOUT_DECIMAL_PLACES = "(\\-|\\+)?[0-9]+(\\,[0-9]+)?"+NOTACAO_CIENTIFICA;
  public static final String BRAZILIAN_NUMBER_WITH_DECIMAL_PLACES = "(\\-|\\+)?[0-9]{1,3}([.][0-9]{3})*(\\,[0-9]+)?"+NOTACAO_CIENTIFICA;
  public static final String BRAZILIAN_NUMBER = "("+ BRAZILIAN_NUMBER_WITHOUT_DECIMAL_PLACES +")|(" + BRAZILIAN_NUMBER_WITH_DECIMAL_PLACES + ")";
  public static final String REAL_NUMBER = "(\\-|\\+)?[0-9]+(\\.[0-9]+)?"+NOTACAO_CIENTIFICA; //aceita somente numero Real
  public static final String INCOGNITAS = "(x)";
  public static final String DIGIT = "("+REAL_NUMBER+"|"+INCOGNITAS+")"; //numero reais e variavel x
  
  public static boolean isDigito( String n ) {
    return Pattern.matches(DIGIT, n);
  }
  
  public static boolean isReal( String n ){
    return Pattern.matches(REAL_NUMBER, n);
  }
  
  public static boolean isIncognita( String incognita ){
    return Pattern.matches(INCOGNITAS, incognita);
  }
  
}
