package ca.acculizer.darkstarportal;

import ca.acculizer.darkstarportal.daos.AccountDAO;
import ca.acculizer.darkstarportal.security.TokenManager;
import ca.acculizer.darkstarportal.services.accounts.AccountsRestResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

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
        bootstrap.addBundle(new AssetsBundle("/assets", "/", "index.html"));
    }


    @Override
    public void run(DarkstarPortalConfiguration configuration, Environment environment) throws Exception {
        final TokenManager tokenManager = new TokenManager();
        tokenManager.start();
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDatabase(), "mysql");
        final AccountDAO accountDAO = jdbi.onDemand(AccountDAO.class);

        environment.jersey().register(new AccountsRestResource(tokenManager, accountDAO));

        final DarkstarPortalCheck healthCheck = new DarkstarPortalCheck();
        environment.healthChecks().register("portalCheck", healthCheck);
    }
}
