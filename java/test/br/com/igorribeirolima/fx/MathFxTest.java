package br.com.igorribeirolima.fx;

import org.junit.Assert;
import org.junit.Test;

import br.com.igorribeirolima.fx.MathFx;

public class MathFxTest {
  
  private MathFx fx = new MathFx();
  
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
	
	@Test
	public void testeParaVerificarALimpezaDeEspacosEmBranco() {
		String strCleaning = fx.clearBlanckSpace("\"Rio Grande\"  ==  \"Jucuruçu\",    \"Rio Grande\"==\"Rio Alcobaça ou Itanhém\"");
		Assert.assertEquals("\"Rio Grande\"==\"Jucuruçu\",\"Rio Grande\"==\"Rio Alcobaça ou Itanhém\"", strCleaning);
	}
	
	@Test
	public void testeExpressaoComParenteses() {
		Assert.assertEquals( -6.0, fx.calc("((1+1)-4)*(9/3)"), 0.0001 );
		Assert.assertEquals( 0.0,  fx.calc("(1+1)-(1+1)"), 0.0001 );
		Assert.assertEquals( 3.0,  fx.calc("(2*2)-(2/2)"), 0.0001 );
		Assert.assertEquals( 6.0,  fx.calc("(2^2)+2"), 0.0001 );
	}
	
	@Test
	public void testeParaVerificarOrdemDePrecedencia(){
		Assert.assertEquals( 7.0,  fx.calc("2+2*2+1"), 0.0001 );
		Assert.assertEquals( 8.0,  fx.calc("2+2*2+1*(2*1^3)"), 0.0001 );
		Assert.assertEquals( 12.0, fx.calc("2+2^2+2*(2*1^3+1)"), 0.0001 );
		Assert.assertEquals( 8.0,  fx.calc("2+2^2+2*(2*1^3>1)"), 0.0001 );
	}
	
	@Test
	public void testeParaVerificarCalculoDeFuncaoDentroDeFuncao() {
		Assert.assertEquals( 1.0, fx.calc("IF(AND(1,1,1,1),1,0)"), 0.0001 );
		Assert.assertEquals( 1.0, fx.calc("IF(AND((1+1^2(1))<>0,1,1,1),1,0)"), 0.0001 );
		Assert.assertEquals( 1.0, fx.calc("AND(\"GD2\"==\"GD2\")"), 0.0001 );
		Assert.assertEquals( 1.0, fx.calc("IF( AND(\"GD2\"==\"GD2\"), 5 * 2 < 10.5, 5 * 2 < 5.5 )"), 0.0001 );
	}
	
	@Test
	public void testeParaVerificarUmaExpressaoDeRegraDeModoDeUso() {
		Double value = fx.calc("IF(OR(\"GD2\"==\"SF6\",\"GD2\"==\"SF7\",\"GD2\"==\"SF8\",\"GD2\"==\"SF9\",\"GD2\"==\"SF10\", \"GD2\"==\"JQ1\", \"GD2\"==\"JQ2\", \"GD2\"==\"JQ3\", \"GD2\"==\"PA1\", \"GD2\"==\"MU1\", \"Rio Grande\"==\"Jucuruçu\", \"Rio Grande\"==\"Rio Alcobaça ou Itanhém\"), 1 <= 0.5, 1 <= 1 )");
		Assert.assertEquals(1.0, value, 0.0001);
	}
}
