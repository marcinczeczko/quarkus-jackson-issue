package org.acme.restclient.multipart;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.StringJoiner;

public class SomeResponse {

  private String tokenType;

  @JsonProperty(value = "access_token")
  private String accessToken;

  public String getTokenType() {
    return tokenType;
  }

  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", SomeResponse.class.getSimpleName() + "[", "]")
        .add("tokenType='" + tokenType + "'")
        .add("accessToken='" + accessToken + "'")
        .toString();
  }
}
