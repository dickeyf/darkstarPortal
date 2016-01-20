package ca.acculizer.darkstarportal.services.accounts;

import ca.acculizer.darkstarportal.daos.AccountDAO;
import ca.acculizer.darkstarportal.model.Account;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Francois Dickey on 2016-01-18.
 */
@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
public class AccountsRestResource {
    private AccountDAO accountDAO;

    public AccountsRestResource(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @GET
    @Timed
    public Response login(@QueryParam("login") String login, @QueryParam("password") String password) {
        Account account = accountDAO.findByLogin(login, password);
        if (account != null) {
            return Response.ok(account).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
