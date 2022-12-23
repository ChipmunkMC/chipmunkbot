package land.chipmunk.chipmunkbot.plugins;

import com.mojang.brigadier.CommandDispatcher;
import land.chipmunk.chipmunkbot.Client;
import land.chipmunk.chipmunkbot.Plugin;
import land.chipmunk.chipmunkbot.command.CommandSource;
import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;

public class CommandManagerPlugin implements Plugin {
  private Client client;
  @Getter @Setter private CommandDispatcher<CommandSource> dispatcher = new CommandDispatcher<>();

  @Override public String id () { return "command_manager"; }

  @Override
  public void inject (Client client, JsonObject options) {
    this.client = client;
  }
}
