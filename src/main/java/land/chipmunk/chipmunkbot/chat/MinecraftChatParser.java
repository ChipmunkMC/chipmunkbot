package land.chipmunk.chipmunkbot.chat;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TranslatableComponent;
import java.util.UUID;
import java.util.List;

public class MinecraftChatParser implements ChatParser {
  private MessageType getMessageType (TranslatableComponent component) {
    String key = component.key();
    if (key.equals("chat.type.text")) return MessageType.TEXT;
    if (key.equals("chat.type.announcement")) return MessageType.ANNOUNCEMENT;
    if (key.equals("chat.type.emote")) return MessageType.EMOTE;
    if (key.equals("chat.type.command")) return MessageType.WHISPER;
    return null;
  }

  public PlayerMessage parseMessage (ChatMessage message) {
    Component component = message.component();
    if (component instanceof TranslatableComponent) return parseTranslatable((TranslatableComponent) component, message.sender());
    return null;
  }

  public PlayerMessage parseTranslatable (TranslatableComponent component, UUID providedSender) {
    TranslatableComponent translate = (TranslatableComponent) component;
    MessageType type = getMessageType(translate);
    if (type == null) return null;

    List<Component> args = component.args();

    // Component displayName = args.get(0);
    Component contents = args.get(1);

    return new PlayerMessage(null, contents, type); // TODO: Use player list
  }
}
