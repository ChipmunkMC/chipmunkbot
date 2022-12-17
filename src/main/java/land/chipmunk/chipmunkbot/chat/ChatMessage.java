package land.chipmunk.chipmunkbot.chat;

import net.kyori.adventure.text.Component;
import java.util.UUID;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class ChatMessage {
  // * I do not really care about signatures, they were likely made for the sussy wussy chat reporting system anyway, but I still include the sender as it really helps with stuff such as commands.
  private Component component;
  private UUID sender;

  public ChatMessage (Component component) {
    this(component, new UUID(0, 0));
  }
}
