package br.com.igorribeirolima.fx.api;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionTest {
  private SimpleExpression fx = new SimpleExpression();
  
  @Test
  public void testeExpressaoSimples() {
    Assert.assertEquals( -2.0, fx.calculateSimpleExpression("-1-1"), 0.0001 );
    Assert.assertEquals( 2.0,  fx.calculateSimpleExpression("+1+1"), 0.0001 );
    Assert.assertEquals( 0.0,  fx.calculateSimpleExpression("-1+1"), 0.0001 );
    Assert.assertEquals( 0.0,  fx.calculateSimpleExpression("+1-1"), 0.0001 );
    Assert.assertEquals( -1.0, fx.calculateSimpleExpression("-1*1"), 0.0001 );
    Assert.assertEquals( -1.0, fx.calculateSimpleExpression("-1/1"), 0.0001 );
    Assert.assertEquals( 2.0,  fx.calculateSimpleExpression("1+1"), 0.0001 );
    Assert.assertEquals( 2.0,  fx.calculateSimpleExpression("4/2"), 0.0001 );
    Assert.assertEquals( 4.0,  fx.calculateSimpleExpression("2*2"), 0.0001 );
    Assert.assertEquals( 4.0,  fx.calculateSimpleExpression("2^2"), 0.0001 );
    Assert.assertEquals( 4.0,  fx.calculateSimpleExpression("6-2"), 0.0001 );
  }
  
  @Test
  public void testeExpressao() {
    Assert.assertEquals( 4.0,  fx.calculateExpressionWithoutParentesis("1+1+1+1"), 0.0001 );
    Assert.assertEquals( 0.0,  fx.calculateExpressionWithoutParentesis("1+1-1-1"), 0.0001 );
    Assert.assertEquals( 4.0,  fx.calculateExpressionWithoutParentesis("2*2*2/2"), 0.0001 );
    Assert.assertEquals( 16.0, fx.calculateExpressionWithoutParentesis("2^2^2"), 0.0001 );
  }
  
}
