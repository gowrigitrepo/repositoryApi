package api.utils;

import lombok.extern.slf4j.Slf4j;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;

import java.io.File;
import java.util.Objects;

public class JsonUtil {
    public static void validateSchema(String actualResponse , String schemaFile) {
        //Converting the expected Json to json schema
    	JSONObject jsonSchemaexpected = new JSONObject(
                new JSONTokener(Objects.requireNonNull(JsonUtil.class.getResourceAsStream("/ExpectedJsonSchema" + File.separator + schemaFile))));
       //Actual Json response is converted to json Object
    	JSONObject jsonSubjectActual = new JSONObject(new JSONTokener(actualResponse));  //Deserialization of json response.
        Schema schema = SchemaLoader.load(jsonSchemaexpected);
        try {
            schema.validate(jsonSubjectActual);
        } catch (Exception e) {
            Assert.fail("Schema validation failed due to :: " + e.getMessage());
        }
    }
}
