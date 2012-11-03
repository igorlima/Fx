package br.com.igorribeirolima.fx;


public interface Calculavel {
  
  String symbol();
  String regex();
  Expression expression();
  Double calculate(String expressao);
  boolean isValid(String expressao);
  
}
