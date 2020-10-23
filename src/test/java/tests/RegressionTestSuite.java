package tests;
/**
 * Regression Test Suite. Classes are executed in exact order from @SuiteClasses
 * SupportedBrowsersTest/UnSupportedBrowsersTest are at top because they don't use @Managed driver to override userAgent
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.PetTests.GetPetTests;
import tests.PetTests.UpdatePetTests;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        GetPetTests.class,
        UpdatePetTests.class
})
public class RegressionTestSuite {
}
