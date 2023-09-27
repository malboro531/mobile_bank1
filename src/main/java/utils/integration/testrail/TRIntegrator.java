package utils.integration.testrail;

import com.codepine.api.testrail.TestRail;
import config.PropertiesConfig;

public class TRIntegrator {
    public TestRail getTestRail() {
        return TestRail
                .builder(PropertiesConfig.getProperty("endPoint"),
                        PropertiesConfig.getProperty("username"),
                        PropertiesConfig.getProperty("password"))
                .applicationName("Мобильный Банк")
                .build();
    }
}
