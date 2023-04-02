package com.paulograbin.ccv2api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Problem detail message (https://tools.ietf.org/html/rfc7807)
 */

@Schema(name = "ErrorDTO", description = "Problem detail message (https://tools.ietf.org/html/rfc7807)")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class ErrorDTO {

  @JsonProperty("title")
  private String title;

  @JsonProperty("detail")
  private String detail;

  public ErrorDTO title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Human-readable summary of the problem type
   * @return title
  */
  
  @Schema(name = "title", accessMode = Schema.AccessMode.READ_ONLY, description = "Human-readable summary of the problem type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ErrorDTO detail(String detail) {
    this.detail = detail;
    return this;
  }

  /**
   * Human-readable explanation specific to this occurrence of the problem
   * @return detail
  */
  
  @Schema(name = "detail", accessMode = Schema.AccessMode.READ_ONLY, description = "Human-readable explanation specific to this occurrence of the problem", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorDTO errorDTO = (ErrorDTO) o;
    return Objects.equals(this.title, errorDTO.title) &&
        Objects.equals(this.detail, errorDTO.detail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, detail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorDTO {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

