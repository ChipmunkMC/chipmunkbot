package land.chipmunk.chipmunkbot.command;

import com.mojang.brigadier.Message;
import net.kyori.adventure.text.Component;

public interface CommandSource {
  // ? Should I support message objects?
  void sendOutput (Component message, boolean broadcast);
  void sendOutput (Component message);

  Component displayName ();
}
