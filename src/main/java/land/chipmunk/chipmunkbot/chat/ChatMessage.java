package land.chipmunk.chipmunkbot.chat;

import net.kyori.adventure.text.Component;
import java.util.UUID;

public class ChatMessage {
  // * I do not really care about signatures, they were likely made for the sus chat reporting system anyway, but I still include the sender as it really helps with stuff such as commands.
  private Component component;
  private UUID sender;

  public ChatMessage (Component component, UUID sender) {
    this.component = component;
    this.sender = sender;
  }

  public ChatMessage (Component component) {
    this(component, new UUID(0, 0));
  }

  public Component component () {
    return component;
  }

  public ChatMessage component (Component value) {
    component = value;
    return this; 
  }

  public UUID sender () {
    return sender;
  }

  public ChatMessage sender (UUID value) {
    sender = value;
    return this; 
  }
}
