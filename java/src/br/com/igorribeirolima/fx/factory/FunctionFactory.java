package br.com.igorribeirolima.fx.factory;

import java.util.HashMap;
import java.util.Map;

import br.com.igorribeirolima.fx.api.Calculavel;
import br.com.igorribeirolima.fx.api.CalculavelFactory;
import br.com.igorribeirolima.fx.function.Function;

class FunctionFactory implements CalculavelFactory{
  
  protected static final Map<String,Calculavel> map = new HashMap<String, Calculavel>();
  static {
    for (Function funcao : Function.values()) 
      map.put(funcao.symbol(), funcao);
  }
  
  public Calculavel get(String symbol) {
    return map.get(symbol);
  }
  
}
