package ca.acculizer.darkstarportal.daos.mappers;

import ca.acculizer.darkstarportal.model.Account;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Francois Dickey on 2016-01-19.
 */
public class AccountMapper implements ResultSetMapper<Account> {
    @Override
    public Account map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        Account account = new Account();
        account.setId(r.getLong("id"));
        account.setLogin(r.getString("login"));
        account.setEmail(r.getString("email"));
        account.setContentIds(r.getInt("content_ids"));
        account.setStatus(r.getInt("status"));
        account.setPrivilege(r.getInt("priv"));
        return account;
    }
}
