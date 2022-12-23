package land.chipmunk.chipmunkbot.command;

import com.mojang.brigadier.Message;
import net.kyori.adventure.text.Component;

public class ConsoleCommandSource implements CommandSource {
  @Override
  public void sendOutput (Component message, boolean broadcast) {
    System.out.println(message);
    // TODO: broadcast
  }

  @Override
  public void sendOutput (Component message) {
    sendOutput(message, true);
  }

  @Override
  public Component displayName () {
    return Component.text("Console");
  }
}
