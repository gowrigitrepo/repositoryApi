package api.responsePOJO;

import java.util.LinkedHashMap;
import java.util.List;
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
"page",
"per_page",
"totalrecord",
"total_pages",
"data"
})

public class GetResponse {

/**
*
* (Required)
*
*/
@JsonProperty("$id")
public String $id;
/**
*
* (Required)
*
*/
@JsonProperty("page")
public int page;
/**
*
* (Required)
*
*/
@JsonProperty("per_page")
public int perPage;
/**
*
* (Required)
*
*/
@JsonProperty("totalrecord")
public int totalrecord;
/**
*
* (Required)
*
*/
@JsonProperty("total_pages")
public int totalPages;
/**
*
* (Required)
*
*/
@JsonProperty("data")
public List<GetResponseDataPOJO> data;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("data")
public List<GetResponseDataPOJO> getData() {
return data;
}

@JsonProperty("data")
public void setData(List<GetResponseDataPOJO> data) {
this.data = data;
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