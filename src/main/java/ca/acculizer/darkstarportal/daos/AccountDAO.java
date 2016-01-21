package ca.acculizer.darkstarportal.daos;

import ca.acculizer.darkstarportal.daos.mappers.AccountMapper;
import ca.acculizer.darkstarportal.model.Account;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by Francois Dickey on 2016-01-19.
 */
@RegisterMapper(AccountMapper.class)
public interface AccountDAO {
    @SqlUpdate("insert into accounts (id, login, password, email, content_ids, status, priv) values (:id, :login, password(:password), :email, :contentIds, :status, :privilege)")
    void insert(@BindBean Account account, @Bind("password") String password);


    @SqlQuery("select * from accounts where id = :id")
    Account findById(@Bind("id") int id);

    @SqlQuery("select * from accounts where login = :login")
    Account findByName(@Bind("login") String login);

    @SqlQuery("select * from accounts where login = :login and password = password(:password)")
    Account findByLogin(@Bind("login") String login, @Bind("password") String password);
}
