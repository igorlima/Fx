package br.com.igorribeirolima.fx.function;

import org.junit.Assert;
import org.junit.Test;

public class FunctionTest {
  
  @Test
  public void testeFuncaoIF() {
    FunctionIF function = new FunctionIF();
    Assert.assertEquals( 1.0, function.calculate("IF(1.0,1,0)"), 0.0001 );
    Assert.assertEquals( 1.0, function.calculate("IF(1==1,1,0)"), 0.0001 );
    Assert.assertEquals( 0.0, function.calculate("IF(1<>1,1,0)"), 0.0001 );
  }
  
  @Test
  public void testeParaVerificarARemocaoDoNomeDaFuncao() {
    String function = "IF(1==1,1,0)";
    String functionWithoutName = Function.IF.takeOfFunctionName(function);
    Assert.assertEquals( "1==1,1,0", functionWithoutName );
  }
  
  @Test
  public void testeFuncaoAND() {
    FunctionAND function = new FunctionAND();
    Assert.assertEquals( 0.0, function.calculate("AND(0)"), 0.0001 );
    Assert.assertEquals( 1.0, function.calculate("AND(1)"), 0.0001 );
    Assert.assertEquals( 0.0, function.calculate("AND(1+1-1,1,0)"), 0.0001 );
    Assert.assertEquals( 1.0, function.calculate("AND(1==1,1,1,1)"), 0.0001 );
  }
  
  @Test
  public void testeFuncaoOR() {
    FunctionOR function = new FunctionOR();
    Assert.assertEquals( 1.0, function.calculate("OR(1+1-1,1,0)"), 0.0001 );
    Assert.assertEquals( 1.0, function.calculate("OR(1==1,1,1,1)"), 0.0001 );
    Assert.assertEquals( 1.0, function.calculate("OR(\"EU\"==\"EU\",1,1,1)"), 0.0001 );
    Assert.assertEquals( 0.0, function.calculate("OR(1<>1,1-1,0,0<0)"), 0.0001 );
    Assert.assertEquals( 0.0, function.calculate("OR(\"Rio Grande\"==\"Jucuruçu\", \"Rio Grande\"==\"Rio Alcobaça ou Itanhém\")"), 0.0001 );
  }
  
  @Test
  public void testeFuncaoNOT() {
    FunctionNOT function = new FunctionNOT();
    Assert.assertEquals( 1.0, function.calculate("NOT(1+1-1-1)"), 0.0001 );
    Assert.assertEquals( 1.0, function.calculate("NOT(0)"), 0.0001 );
    Assert.assertEquals( 0.0, function.calculate("NOT(1)"), 0.0001 );
    Assert.assertEquals( 0.0, function.calculate("NOT(1+1+1+1+1)"), 0.0001 );
  }
  
}
