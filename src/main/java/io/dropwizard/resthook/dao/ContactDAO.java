package io.dropwizard.resthook.dao;

import io.dropwizard.resthook.dao.mappers.ContactMapper;
import io.dropwizard.resthook.representations.Contact;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * Created by hanishi on 2014/08/02.
 */
public interface ContactDAO {
    @Mapper(ContactMapper.class)
    @SqlQuery("select * from contact where id=:id")
    Contact getContactById(@Bind("id") int id);
}
