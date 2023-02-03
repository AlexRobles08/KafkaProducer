package org.example.resources;

import org.apache.kafka.clients.producer.Producer;
import org.example.MessageProducer;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("send-message")
public class SendMessage {
  public static class Message {
    private String message;

    public Message() {}

    public Message(String message) {
      this.message = message;
    }

    public String getMessage() {
      return message;
    }

    public Message setMessage(String message) {
      this.message = message;
      return this;
    }
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response sendMessage(Message message) {
    String responseMessage = "This message was sent: " + message.getMessage();
    MessageProducer messageProducer = new MessageProducer();
    messageProducer.sendMessageToTopic(message.getMessage());
    return Response.ok().entity(responseMessage).build();
  }
}
