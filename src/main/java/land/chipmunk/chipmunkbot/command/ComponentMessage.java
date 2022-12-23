package land.chipmunk.chipmunkbot.command;

import net.kyori.adventure.text.Component;
import com.mojang.brigadier.Message;
import lombok.Getter;

public class ComponentMessage implements Message {
  @Getter private final Component component;

  private ComponentMessage (Component component) {
    this.component = component;
  }

  public static ComponentMessage wrap (Component component) {
    return new ComponentMessage(component);
  }

  public String getString () {
    return component.toString(); // ? Is this the best way to get the string?
  }

  public String toString () {
    return component.toString();
  }
}
