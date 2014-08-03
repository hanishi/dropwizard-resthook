package io.dropwizard.resthook;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;

/**
 * Created by hanishi on 2014/08/02.
 */
public class PhoneBookConfiguration extends Configuration {
    @JsonProperty
    @NotEmpty
    private String message;

    @JsonProperty
    @Max(10)
    private int messageRepetitions;

    @JsonProperty
    private String additionalMessage = "This is optional";

    @JsonProperty
    private DataSourceFactory database = new DataSourceFactory();

    public String getMessage(){
         return message;
    }

    public int getMessageRepetitions(){
        return messageRepetitions;
    }

    public String getAdditionalMessage() {
        return additionalMessage;
    }

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}
