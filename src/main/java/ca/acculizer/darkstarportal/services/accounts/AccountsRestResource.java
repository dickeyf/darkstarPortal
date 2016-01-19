package ca.acculizer.darkstarportal.services.accounts;

import ca.acculizer.darkstarportal.model.Account;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by Francois Dickey on 2016-01-18.
 */
@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
public class AccountsRestResource {
    @GET
    @Timed
    public Account login(@QueryParam("login") String login) {
        Account account = new Account();
        return account;
    }
}
