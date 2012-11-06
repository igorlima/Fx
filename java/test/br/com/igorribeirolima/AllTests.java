package br.com.igorribeirolima;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.igorribeirolima.fx.MathFxTest;
import br.com.igorribeirolima.fx.function.FunctionTest;
import br.com.igorribeirolima.fx.operator.OperatorTest;
import br.com.igorribeirolima.fx.regex.RegexTest;

@RunWith(Suite.class)
@SuiteClasses({ MathFxTest.class, FunctionTest.class, OperatorTest.class, RegexTest.class })
public class AllTests {
  
}
