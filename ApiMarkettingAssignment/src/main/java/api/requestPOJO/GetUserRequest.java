package api.requestPOJO;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"$id",
"id",
"name",
"email",
"profilepicture",
"location",
"createdat"
})

public class GetUserRequest {

/**
*
* (Required)
*
*/
@JsonProperty("$id")
private String $id;
/**
*
* (Required)
*
*/
@JsonProperty("id")
private int id;
/**
*
* (Required)
*
*/
@JsonProperty("name")
private String name;
/**
*
* (Required)
*
*/
@JsonProperty("email")
private String email;
/**
*
* (Required)
*
*/
@JsonProperty("profilepicture")
private String profilepicture;
/**
*
* (Required)
*
*/
@JsonProperty("location")
private String location;
/**
*
* (Required)
*
*/
@JsonProperty("createdat")
private String createdat;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

/**
*
* (Required)
*
*/
@JsonProperty("$id")
public String get$id() {
return $id;
}

/**
*
* (Required)
*
*/
@JsonProperty("$id")
public void set$id(String $id) {
this.$id = $id;
}

/**
*
* (Required)
*
*/
@JsonProperty("id")
public int getId() {
return id;
}

/**
*
* (Required)
*
*/
@JsonProperty("id")
public void setId(int id) {
this.id = id;
}

/**
*
* (Required)
*
*/
@JsonProperty("name")
public String getName() {
return name;
}

/**
*
* (Required)
*
*/
@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

/**
*
* (Required)
*
*/
@JsonProperty("email")
public String getEmail() {
return email;
}

/**
*
* (Required)
*
*/
@JsonProperty("email")
public void setEmail(String email) {
this.email = email;
}

/**
*
* (Required)
*
*/
@JsonProperty("profilepicture")
public String getProfilepicture() {
return profilepicture;
}

/**
*
* (Required)
*
*/
@JsonProperty("profilepicture")
public void setProfilepicture(String profilepicture) {
this.profilepicture = profilepicture;
}

/**
*
* (Required)
*
*/
@JsonProperty("location")
public String getLocation() {
return location;
}

/**
*
* (Required)
*
*/
@JsonProperty("location")
public void setLocation(String location) {
this.location = location;
}

/**
*
* (Required)
*
*/
@JsonProperty("createdat")
public String getCreatedat() {
return createdat;
}

/**
*
* (Required)
*
*/
@JsonProperty("createdat")
public void setCreatedat(String createdat) {
this.createdat = createdat;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}