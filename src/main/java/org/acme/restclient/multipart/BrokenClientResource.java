package org.acme.restclient.multipart;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/client")
public class BrokenClientResource {

  @Inject
  @RestClient
  MultipartService service;

  @GET
  @Path("/multipart/json")
  @Produces(MediaType.TEXT_PLAIN)
  public String sendMultiPartGetMappedObject() throws Exception {
    SomeResponse someResponse = service.sendMultipartData(getBody());
    return String.format("Response = (%s)", someResponse.toString());
  }

  @GET
  @Path("/multipart/text")
  @Produces(MediaType.TEXT_PLAIN)
  public String sendMultipartGetAsText() throws Exception {
    return String.format("Response = (%s)", service.sendMultipartDataPlainResponse(getBody()));
  }

  @GET
  @Path("/post/json")
  @Produces(MediaType.TEXT_PLAIN)
  public String sendMappedObjectGetMappedObject() throws Exception {
    SomeResponse someResponse = service.postBody(getBody());
    return String.format("Response = (%s)", someResponse.toString());
  }

  private MultipartBody getBody() {
    MultipartBody body = new MultipartBody();
    body.formField = "foo-bar";
    return body;
  }
}