package br.com.igorribeirolima.fx;


public interface Fx {

  public Double calc(String expression);
  public boolean hasParentesisOK( String expressao, Character charAbre, Character charFecha );  
  public boolean isValid(String expressao);
  
}
