import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by oclimova on 12/9/2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        tags = "@Run"
)
public class TestRunner {
}
