package br.com.igorribeirolima;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.igorribeirolima.fx.expression.ExpressionTest;
import br.com.igorribeirolima.fx.function.FunctionTest;
import br.com.igorribeirolima.fx.operator.OperatorTest;
import br.com.igorribeirolima.fx.regex.RegexTest;

@RunWith(Suite.class)
@SuiteClasses({ FunctionTest.class, OperatorTest.class, RegexTest.class, ExpressionTest.class })
public class AllTests {
  
}
