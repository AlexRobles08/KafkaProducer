package org.example.resources;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("healthcheck")
public class HealthCheck {
   @GET
  public Response healthCheck() {
     JsonObject healthcheckMessage = Json.createObjectBuilder().add("message", "My KafkaProducer is alive!").build();
     return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*")
             .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
             .header("Access-Control-Allow-Credentials", "true")
             .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
             .header("Access-Control-Max-Age", "1209600").entity(healthcheckMessage).build();
   }
}
