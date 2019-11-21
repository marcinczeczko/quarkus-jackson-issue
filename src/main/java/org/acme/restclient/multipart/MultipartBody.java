package org.acme.restclient.multipart;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class MultipartBody {

  @FormParam("form_field")
  @PartType(MediaType.TEXT_PLAIN)
  public String formField;
}
