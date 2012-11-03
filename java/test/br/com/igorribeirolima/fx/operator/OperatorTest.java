package br.com.igorribeirolima.fx.operator;

import org.junit.Assert;
import org.junit.Test;

public class OperatorTest {
  
  @Test
  public void testeExpressaoSimplesDeSoma() {
    OperatorSoma expressao = new OperatorSoma();
    Assert.assertEquals( "A expressão '1+1' DEVE ser igual a '2'", 2.0, expressao.calculate("1+1"), 0.0001 );
  }
  
  @Test
  public void testeExpressaoSimplesDeDivisao() {
    OperatorDivisao expressao = new OperatorDivisao();
    Assert.assertEquals( "A expressão '4/2' DEVE ser igual a '2'", 2.0, expressao.calculate("4/2"), 0.0001 );
  }
  
  @Test
  public void testeExpressaoSimplesDeMultiplicacao() {
    OperatorMultiplicacao expressao = new OperatorMultiplicacao();
    Assert.assertEquals( "A expressão '2*2' DEVE ser igual a '4'", 4.0, expressao.calculate("2*2"), 0.0001 );
  }
  
  @Test
  public void testeExpressaoSimplesDeExponencial() {
    OperatorExponencial expressao = new OperatorExponencial();
    Assert.assertEquals( "A expressão '2^2' DEVE ser igual a '4'", 4.0, expressao.calculate("2^2"), 0.0001 );
  }
  
  @Test
  public void testeExpressaoSimplesDeSubtracao() {
    OperatorSubtracao expressao = new OperatorSubtracao();
    Assert.assertEquals( "A expressão '6-2' DEVE ser igual a '4'", 4.0, expressao.calculate("6-2"), 0.0001 );
  }
  
  @Test
  public void testeExpressaoSimplesIgualQue() {
    OperatorIgualQue expressao = new OperatorIgualQue();
    Assert.assertEquals( "A expressão '1==1' DEVE ser uma expressão verdadeira", 1.0, expressao.calculate("1==1"), 0.0001 );
    Assert.assertEquals( "A expressão '1==2' DEVE ser uma expressão falsa", 0.0, expressao.calculate("1==2"), 0.0001 );
  }
  
  @Test
  public void testeExpressaoSimplesIgualQueComNome() {
    OperatorIgualQue expressao = new OperatorIgualQue();
    Assert.assertEquals( "A expressão com palavra 'Eu==Eu' DEVE ser uma expressão verdadeira", 1.0, expressao.calculate("\"Eu\"==\"Eu\""), 0.0001 );
    Assert.assertEquals( "A expressão com palavra 'Eu==Tu' DEVE ser uma expressão falsa", 0.0, expressao.calculate("\"Eu\"==\"Tu\""), 0.0001 );
  }
  
  @Test
  public void testeExpressaoSimplesDiferenteDe() {
    OperatorDiferenteDe expressao = new OperatorDiferenteDe();
    Assert.assertEquals( "A expressão '1<>1' DEVE ser uma expressão falsa", 0.0, expressao.calculate("1<>1"), 0.0001 );
    Assert.assertEquals( "A expressão '1<>2' DEVE ser uma expressão verdadeira", 1.0, expressao.calculate("1<>2"), 0.0001 );
  }
  
  @Test
  public void testeExpressaoSimplesDiferenteDeComNome() {
    OperatorDiferenteDe expressao = new OperatorDiferenteDe();
    Assert.assertEquals( "A expressão com palavra 'Eu<>Eu' DEVE ser uma expressão falsa", 0.0, expressao.calculate("\"Eu\"<>\"Eu\""), 0.0001 );
    Assert.assertEquals( "A expressão com palavra 'Eu<>Tu' DEVE ser uma expressão verdadeira", 1.0, expressao.calculate("\"Eu\"<>\"Tu\""), 0.0001 );
  }
  
  @Test
  public void testeExpressaoMenorIgual() {
    OperatorMenorIgual expressao = new OperatorMenorIgual();
    Assert.assertEquals( "A expressão '1<=1' DEVE ser uma expressão verdadeira", 1.0, expressao.calculate("1<=1"), 0.0001 );
    Assert.assertEquals( "A expressão '1<=2' DEVE ser uma expressão verdadeira", 1.0, expressao.calculate("1<=2"), 0.0001 );
  }
  
  @Test
  public void testeExpressaoMaiorIgual() {
    OperatorMaiorIgual expressao = new OperatorMaiorIgual();
    Assert.assertEquals( "A expressão '1>=1' DEVE ser uma expressão verdadeira", 1.0, expressao.calculate("1>=1"), 0.0001 );
    Assert.assertEquals( "A expressão '1>=2' DEVE ser uma expressão falsa", 0.0, expressao.calculate("1>=2"), 0.0001 );
  }
  
  @Test
  public void testeExpressaoMaiorQue() {
    OperatorMaiorQue expressao = new OperatorMaiorQue();
    Assert.assertEquals( "A expressão '1>1' DEVE ser uma expressão falsa", 0.0, expressao.calculate("1>1"), 0.0001 );
    Assert.assertEquals( "A expressão '1>2' DEVE ser uma expressão falsa", 0.0, expressao.calculate("1>2"), 0.0001 );
  }
  
  @Test
  public void testeExpressaoMenorQue() {
    OperatorMenorQue expressao = new OperatorMenorQue();
    Assert.assertEquals( "A expressão '1<1' DEVE ser uma expressão falsa", 0.0, expressao.calculate("1<1"), 0.0001 );
    Assert.assertEquals( "A expressão '1<2' DEVE ser uma expressão verdadeira", 1.0, expressao.calculate("1<2"), 0.0001 );
  }
  
  @Test
  public void testeExpressaoAND() {
    OperatorAND expressao = new OperatorAND();
    Assert.assertEquals( "A expressão '1&&1' DEVE ser uma expressão verdadeira", 1.0, expressao.calculate("1&&1"), 0.0001 );
    Assert.assertEquals( "A expressão '1&&0' DEVE ser uma expressão falsa", 0.0, expressao.calculate("1&&0"), 0.0001 );
    Assert.assertEquals( "A expressão '0&&1' DEVE ser uma expressão falsa", 0.0, expressao.calculate("0&&1"), 0.0001 );
    Assert.assertEquals( "A expressão '0&&0' DEVE ser uma expressão falsa", 0.0, expressao.calculate("0&&0"), 0.0001 );
  }
  
  @Test
  public void testeExpressaoOR() {
    OperatorOR expressao = new OperatorOR();
    Assert.assertEquals( "A expressão '1||1' DEVE ser uma expressão verdadeira", 1.0, expressao.calculate("1||1"), 0.0001 );
    Assert.assertEquals( "A expressão '1||0' DEVE ser uma expressão verdadeira", 1.0, expressao.calculate("1||0"), 0.0001 );
    Assert.assertEquals( "A expressão '0||1' DEVE ser uma expressão verdadeira", 1.0, expressao.calculate("0||1"), 0.0001 );
    Assert.assertEquals( "A expressão '0||0' DEVE ser uma expressão falsa", 0.0, expressao.calculate("0||0"), 0.0001 );
  }
  
}
