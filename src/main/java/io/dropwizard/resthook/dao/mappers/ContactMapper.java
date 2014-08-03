package io.dropwizard.resthook.dao.mappers;

import io.dropwizard.resthook.representations.Contact;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hanishi on 2014/08/02.
 */
public class ContactMapper implements ResultSetMapper<Contact> {

    @Override
    public Contact map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Contact(resultSet.getInt("id"),resultSet.getString("firstName"),
                resultSet.getString("lastName"), resultSet.getString("phone"));
    }
}
