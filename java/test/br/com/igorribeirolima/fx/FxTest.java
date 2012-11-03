package br.com.igorribeirolima.fx;

import org.junit.Assert;
import org.junit.Test;

import br.com.igorribeirolima.fx.operator.Operator;

public class FxTest {
  
  @Test
  public void testeParaVerificarRegexDosOperadores() {
    String regexOperadores = "\\^|" +
        "\\*|" +
        "\\/|" +
        "\\+|" +
        "\\-|" +
        "\\=\\=|" +
        "\\<\\>|" +
        "\\<\\=|" +
        "\\>\\=|" +
        "\\>|" +
        "\\<|" +
        "\\&\\&|" +
        "\\|\\|";
    Assert.assertEquals( "Regex de operadores inválida", regexOperadores, Operator.regexOperators() );
  }
  
  @Test
  public void testeParaVerificarUmNumero() {
    Assert.assertTrue( "00 é um numero", Number.isReal("00") );
    Assert.assertTrue( "-1 é um numero", Number.isReal("-1") );
    Assert.assertTrue( "+10 é um numero",  Number.isReal("+10") );
    Assert.assertTrue( "+10.2 é um numero",  Number.isReal("+10.2") );
    Assert.assertTrue( "-10.2 é um numero",  Number.isReal("-10.2") );
    Assert.assertFalse( "a NÃO é um numero", Number.isReal("a") );
    Assert.assertFalse( "--10 NÃO é um numero", Number.isReal("--10") );
    Assert.assertFalse( "++10 NÃO é um numero", Number.isReal("++10") );
    Assert.assertFalse( ". NÃO é um numero", Number.isReal(".") );
    Assert.assertFalse( ".02 NÃO é um numero", Number.isReal(".02") );
  }
  
  @Test
  public void testeParaVerificarUmDigitoDeUmExpressao() {
    Assert.assertTrue( "00 é um dígito", Number.isDigito("00") );
    Assert.assertTrue( "x é um dígito", Number.isDigito("x") );
    Assert.assertFalse( "y NÃO é um dígito", Number.isDigito("y") );
    Assert.assertFalse( "a NÃO é um dígito", Number.isDigito("a") );
  }
  
  @Test
  public void testeParaVerificarUmaIncognita() {
    Assert.assertTrue( "x é uma incognita", Number.isIncognita("x") );
    Assert.assertFalse( "n NÃO é uma incognita", Number.isIncognita("n") );
    Assert.assertFalse( "a NÃO é uma incognita", Number.isIncognita("a") );
  }
  
  @Test
  public void testeParaNumeroNoFormatoBrasileiro() {
    Assert.assertTrue( Expression.isBrazilianNumber("1,000") );
    Assert.assertTrue( Expression.isBrazilianNumber("1213123132,000") );
    Assert.assertTrue( Expression.isBrazilianNumber("1.131.313.131,000") );
    Assert.assertFalse( Expression.isBrazilianNumber("1,000,000.00") );
    Assert.assertFalse( Expression.isBrazilianNumber("1.05") );
  }
  
}
