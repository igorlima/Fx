package br.com.igorribeirolima.fx.factory;

import java.util.HashMap;
import java.util.Map;

import br.com.igorribeirolima.fx.api.Calculavel;
import br.com.igorribeirolima.fx.api.CalculavelFactory;

public class FxFactory implements CalculavelFactory {
  
  private static final Map<String,Calculavel> map = new HashMap<String, Calculavel>();
  static {
    map.putAll(FunctionFactory.map);
    map.putAll(OperatorFactory.map);
  }

  public Calculavel get(String symbol) {
    return map.get(symbol);
  }
  
}
