package land.chipmunk.chipmunkbot.chat;

import net.kyori.adventure.text.Component;

public interface ChatParser {
  public PlayerMessage parseMessage(ChatMessage message);
}
