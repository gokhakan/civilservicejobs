package uk.gov.service.civilservicejobs.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "uk/gov/service/civilservicejobs/stepDefinitions",
        dryRun = false,
        tags = "@wip"
)

public class CukesRunner {
}