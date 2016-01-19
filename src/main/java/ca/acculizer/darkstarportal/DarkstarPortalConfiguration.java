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
    String mysql;

    @JsonProperty
    public String getMysql() {
        return mysql;
    }

    @JsonProperty
    public void setMysql(String mysql) {
        this.mysql = mysql;
    }
}
