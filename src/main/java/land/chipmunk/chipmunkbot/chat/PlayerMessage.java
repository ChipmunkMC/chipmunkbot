package land.chipmunk.chipmunkbot.chat;

import net.kyori.adventure.text.Component;
import com.github.steveice10.mc.protocol.data.game.PlayerListEntry;

public class PlayerMessage {
  private PlayerListEntry sender;
  private Component contents;
  private MessageType type;

  PlayerMessage (PlayerListEntry sender, Component contents, MessageType type) {
    this.sender = sender;
    this.contents = contents;
    this.type = type;
  }

  PlayerMessage (PlayerListEntry sender, Component contents) {
    this(sender, contents, MessageType.TEXT);
  }

  public PlayerListEntry sender () {
    return sender;
  }

  public PlayerMessage sender (PlayerListEntry value) {
    sender = value;
    return this;
  }

  public Component contents () {
    return contents;
  }

  public PlayerMessage contents (Component value) {
    contents = value;
    return this;
  }

  public MessageType type () {
    return type;
  }

  public PlayerMessage type (MessageType value) {
    type = value;
    return this;
  }
}
