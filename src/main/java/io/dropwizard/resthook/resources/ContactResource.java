package io.dropwizard.resthook.resources;

import io.dropwizard.resthook.dao.ContactDAO;
import io.dropwizard.resthook.representations.Contact;
import org.skife.jdbi.v2.DBI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by hanishi on 2014/08/02.
 */
@Path("/contact")
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {

    private final ContactDAO contactDAO;

    public ContactResource(DBI jdbi) {
        contactDAO = jdbi.onDemand(ContactDAO.class);
    }


    @GET
    @Path("{id}")
    public Response getContact(@PathParam("id") int id) {
        return Response.ok(new Contact(id, "John", "Doe", "+123456789")).build();
    }

    @POST
    public Response createContact(Contact contact) {
        return Response.created(null).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContact(@PathParam("id") int id) {
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateContact(@PathParam("id") int id, Contact contact) {

        return Response.ok(new Contact(id, contact.getFirstName(),
                contact.getLastName(), contact.getPhone())).build();

    }

}
