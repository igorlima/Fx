package br.com.igorribeirolima.fx.regex;

import br.com.igorribeirolima.fx.api.RegexEnum;


public enum RegexOperator implements RegexEnum {
  EXP           ("^" , "\\^"),
  MULTIPACACAO  ("*" , "\\*"),
  DIVISAO       ("/" , "\\/"),
  SOMA          ("+" , "\\+"),
  SUBTRACAO     ("-" , "\\-"),
  IGUAL_QUE     ("==", "\\=\\="),
  DIFERENTE_DE  ("<>", "\\<\\>"),
  MENOR_IGUAL   ("<=", "\\<\\="),
  MAIOR_IGUAL   (">=", "\\>\\="),
  MAIOR_QUE     (">" , "\\>"),
  MENOR_QUE     ("<" , "\\<"),
  AND           ("&&", "\\&\\&"),
  OR            ("||", "\\|\\|")
  ;
  
  private final String symbol;
  private final String regex;
  
  private RegexOperator(String symbol, String regex) {
    this.symbol = symbol;
    this.regex = regex;
  }
  
  public String symbol() {
    return this.symbol;
  }
  
  public String regex() {
    return this.regex;
  }
  
  /**
   * operadores +, -, \, *, ^
   * @return
   */
  public static String regexOperators() {
    String regex = "";
    for (RegexOperator operador : RegexOperator.values())
      regex += regex.isEmpty() ? operador.regex() : "|" + operador.regex();
    
    return regex;
  }
}
