package org.acme.restclient.multipart;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@Path("/echo")
@RegisterRestClient
public interface MultipartService {

    @Path("/multipart")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    SomeResponse sendMultipartData(@MultipartForm MultipartBody data);

    @Path("/multipart")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    String sendMultipartDataPlainResponse(@MultipartForm MultipartBody data);

    @Path("/param")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    SomeResponse postBody(MultipartBody data);

}