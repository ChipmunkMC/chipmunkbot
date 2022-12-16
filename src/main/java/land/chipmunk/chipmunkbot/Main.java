package land.chipmunk.chipmunkbot;

import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundLoginPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.ServerboundChatPacket;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.event.session.SessionAdapter;
import com.github.steveice10.packetlib.packet.Packet;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;

import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import land.chipmunk.chipmunkbot.plugins.ChatPlugin;

import com.google.gson.Gson;
import land.chipmunk.chipmunkbot.plugins.PlayerListPlugin;

public class Main {
  private static File CONFIG_FILE = new File("config.json");

  private static JsonObject getConfig () throws Exception {
    InputStream opt = new FileInputStream(CONFIG_FILE);
    BufferedReader reader = new BufferedReader(new InputStreamReader(opt));

    return JsonParser.parseReader(reader).getAsJsonObject();
  }

  public static ClientOptions parseClientOptions (JsonObject options) {
    return new ClientOptions()
      .host(options.has("host") ? options.get("host").getAsString() : "0.0.0.0")
      .port(options.has("port") ? options.get("port").getAsInt() : 25565)
      .username(options.has("username") ? options.get("username").getAsString() : "username");
  }

  public static void main (String[] arguments) {
    System.out.println("ChipmunkBot is starting...");

    JsonObject config = null;
    try {
      config = getConfig();
    } catch (Exception exception) {
      exception.printStackTrace();
      System.exit(1);
    }

    for (JsonElement element : config.get("bots").getAsJsonArray()) {
      ClientOptions options = parseClientOptions(element.getAsJsonObject());
      Client client = new Client(options); // TODO: Maybe create a list of some sort
      client.loadPlugin(PlayerListPlugin.class);
    }
  }
}
