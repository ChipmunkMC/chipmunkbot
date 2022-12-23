package land.chipmunk.chipmunkbot.plugins;

import land.chipmunk.chipmunkbot.Plugin;
import land.chipmunk.chipmunkbot.Client;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundPlayerChatPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundSystemChatPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.ServerboundChatPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.ServerboundChatCommandPacket;
import com.github.steveice10.packetlib.packet.Packet;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.event.session.SessionAdapter;
import com.google.gson.JsonObject;
import java.util.BitSet;
import java.util.ArrayList;
import java.util.List;
import java.time.Instant;

public class ChatPlugin implements Plugin {
  private Client client;

  @Override public String id () { return "chat"; }

  public void inject (Client client, JsonObject options) {
    this.client = client;
  }

  public void message (String message) {
    final ServerboundChatPacket packet = new ServerboundChatPacket(message, Instant.now().toEpochMilli(), 0, new byte[0], false, new ArrayList<>(), null);
    client.session().send(packet);
  }

  public void command (String command) {
    final ServerboundChatCommandPacket packet = new ServerboundChatCommandPacket(command, Instant.now().toEpochMilli(), 0, new ArrayList<>(), false, new ArrayList<>(), null);
    client.session().send(packet);
  }
}
