package land.chipmunk.chipmunkbot.chat;

import net.kyori.adventure.text.Component;
import com.github.steveice10.mc.protocol.data.game.PlayerListEntry;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class PlayerMessage {
  private PlayerListEntry sender;
  private Component contents;
  private MessageType type;
}
