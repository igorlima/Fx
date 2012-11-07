package br.com.igorribeirolima.fx.factory;

import java.util.HashMap;
import java.util.Map;

import br.com.igorribeirolima.fx.api.Calculavel;
import br.com.igorribeirolima.fx.api.CalculavelFactory;
import br.com.igorribeirolima.fx.operator.Operator;

class OperatorFactory implements CalculavelFactory{
  
  protected static final Map<String,Calculavel> map = new HashMap<String, Calculavel>();
  static {
    for (Operator operador : Operator.values()) 
      map.put(operador.symbol(), operador);
  }
  
  public Calculavel get(String symbol) {
    return map.get(symbol);
  }
  
}
