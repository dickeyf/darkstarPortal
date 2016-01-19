package ca.acculizer.darkstarportal;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Francois Dickey on 2016-01-18.
 */
public class DarkstarPortalConfiguration extends Configuration {
    @NotEmpty
    private
    String testConfig;

    @JsonProperty
    public String getTestConfig() {
        return testConfig;
    }

    @JsonProperty
    public void setTestConfig(String testConfig) {
        this.testConfig = testConfig;
    }
}
