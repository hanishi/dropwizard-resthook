package io.dropwizard.resthook;

import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.resthook.resources.ContactResource;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class App extends Application<PhoneBookConfiguration> {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public void initialize(Bootstrap<PhoneBookConfiguration> configurationBootstrap) {

    }

    @Override
    public void run(PhoneBookConfiguration configuration, Environment environment) throws Exception {

        LOG.info("Method App#run() called");
        for (int i=0; i < configuration.getMessageRepetitions(); i++) {
            System.out.println(configuration.getMessage());
        }
        System.out.println(configuration.getAdditionalMessage());

        // Create a DBI factory and build a JDBI instance
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory
                .build(environment, configuration.getDataSourceFactory(), "mysql");
        // Add the resource to the environment
        environment.jersey().register(new ContactResource(jdbi));
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}

