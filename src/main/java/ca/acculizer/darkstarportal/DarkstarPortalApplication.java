package ca.acculizer.darkstarportal;

import ca.acculizer.darkstarportal.services.accounts.AccountsRestResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by Francois Dickey on 2016-01-18.
 */
public class DarkstarPortalApplication extends Application<DarkstarPortalConfiguration> {
    public static void main(String[] args) throws Exception {
        new DarkstarPortalApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<DarkstarPortalConfiguration> bootstrap) {
    }


    @Override
    public void run(DarkstarPortalConfiguration configuration, Environment environment) throws Exception {
        final AccountsRestResource accountsRestResource = new AccountsRestResource();
        environment.jersey().register(accountsRestResource);

        final DarkstarPortalCheck healthCheck = new DarkstarPortalCheck();
        environment.healthChecks().register("portalCheck", healthCheck);
    }
}
