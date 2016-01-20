package ca.acculizer.darkstarportal.services.accounts;

import ca.acculizer.darkstarportal.daos.AccountDAO;
import ca.acculizer.darkstarportal.model.Account;
import ca.acculizer.darkstarportal.security.Token;
import ca.acculizer.darkstarportal.security.TokenManager;
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
    private TokenManager tokenManager;

    public AccountsRestResource(TokenManager tokenManager, AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
        this.tokenManager = tokenManager;
    }

    @GET
    @Timed
    public Response login(@QueryParam("login") String login, @QueryParam("password") String password) {
        Account account = accountDAO.findByLogin(login, password);
        if (account != null) {
            Token token = tokenManager.getTokenForAccount(account);
            return Response.ok(token).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
