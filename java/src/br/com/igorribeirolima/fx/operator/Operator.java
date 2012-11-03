package br.com.igorribeirolima.fx.operator;

import java.util.HashMap;
import java.util.Map;

import br.com.igorribeirolima.fx.Calculavel;
import br.com.igorribeirolima.fx.Expression;

public enum Operator implements Calculavel {
  
  //Manter ordem de PRECEDÊNCIA
  EXP           ("^" , "\\^",    OperatorExponencial.class   ),
  MULTIPACACAO  ("*" , "\\*",    OperatorMultiplicacao.class ),
  DIVISAO       ("/" , "\\/",    OperatorDivisao.class       ),
  SOMA          ("+" , "\\+",    OperatorSoma.class          ),
  SUBTRACAO     ("-" , "\\-",    OperatorSubtracao.class     ),
  IGUAL_QUE     ("==", "\\=\\=", OperatorIgualQue.class      ),
  DIFERENTE_DE  ("<>", "\\<\\>", OperatorDiferenteDe.class   ),
  MENOR_IGUAL   ("<=", "\\<\\=", OperatorMenorIgual.class    ),
  MAIOR_IGUAL   (">=", "\\>\\=", OperatorMaiorIgual.class    ),
  MAIOR_QUE     (">" , "\\>",    OperatorMaiorQue.class      ),
  MENOR_QUE     ("<" , "\\<",    OperatorMenorQue.class      ),
  AND           ("&&", "\\&\\&", OperatorAND.class           ),
  OR            ("||", "\\|\\|", OperatorOR.class            )
  ;
  
  private static final Map<String,Calculavel> map = new HashMap<String, Calculavel>();
  private final String symbol;
  private final String regex;
  private final Class<?> className;
  private Expression expressaoSimples;

  private Operator(String symbol, String regex, Class<?> className) {
    this.symbol = symbol;
    this.regex = regex;
    this.className = className;
  }
  
  public String symbol() {
    return this.symbol;
  }
  
  public String regex() {
    return this.regex;
  }
  
  public Expression expression() {
    try {
      if (expressaoSimples==null)
        this.expressaoSimples = (Expression) className.newInstance();
      return this.expressaoSimples;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  
  public Double calculate(String expressao) {
    return this.expression().calculate(expressao);
  }
  
  public boolean isValid(String expressao) {
    return this.expression().isValid(expressao);
  }
  
  /**
   * operadores +, -, \, *, ^
   * @return
   */
  public static String regexOperators() {
    String regex = "";
    for (Operator operador : Operator.values())
      regex += regex.isEmpty() ? operador.regex() : "|" + operador.regex();
    
    return regex;
  }
  
  public static Calculavel get(String symbol) {
    if (map.isEmpty())
      for (Operator operador : Operator.values()) 
        map.put(operador.symbol(), operador);
    
    return map.get(symbol);
  }
  
}
