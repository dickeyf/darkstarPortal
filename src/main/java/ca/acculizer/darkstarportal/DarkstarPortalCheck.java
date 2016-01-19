package ca.acculizer.darkstarportal;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by Francois Dickey on 2016-01-18.
 */
public class DarkstarPortalCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
