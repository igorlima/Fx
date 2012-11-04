package br.com.igorribeirolima.fx.api;


public interface Fx {

  public Double calc(String expression);
  public boolean hasParentesisOK( String expressao, Character charAbre, Character charFecha );  
  public boolean isValid(String expressao);
  
}
