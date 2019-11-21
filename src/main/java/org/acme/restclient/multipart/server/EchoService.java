package org.acme.restclient.multipart.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.acme.restclient.multipart.MultipartBody;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@Path("/echo")
public class EchoService {

  @Path("/multipart")
  @POST
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Produces(MediaType.APPLICATION_JSON)
  public String multipart(@MultipartForm MultipartBody requestBody) throws Exception {
    return String.format("{\"tokenType\":\"%s\", \"access_token\":\"%s\"}", requestBody.formField,
        requestBody.formField);
  }

  @Path("/param")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String postBody(MultipartBody requestBody) throws Exception {
    return String.format("{\"tokenType\":\"%s\", \"access_token\":\"%s\"}", requestBody.formField,
        requestBody.formField);
  }
}