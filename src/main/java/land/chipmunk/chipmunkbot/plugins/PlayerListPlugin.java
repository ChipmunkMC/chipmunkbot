package land.chipmunk.chipmunkbot.plugins;

import land.chipmunk.chipmunkbot.Plugin;
import land.chipmunk.chipmunkbot.Client;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundPlayerInfoPacket;
import com.github.steveice10.packetlib.packet.Packet;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.event.session.SessionAdapter;
import com.github.steveice10.mc.protocol.data.game.PlayerListEntry;
import com.github.steveice10.mc.protocol.data.game.PlayerListEntryAction;
import land.chipmunk.chipmunkbot.data.MutablePlayerListEntry;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class PlayerListPlugin extends Plugin {
  public List<MutablePlayerListEntry> list = new ArrayList<MutablePlayerListEntry>();

  public PlayerListPlugin (Client client) {
    super(client, "player_list");

    client.session().addListener(new SessionAdapter() {
      @Override
      public void packetReceived (Session session, Packet packet) {
        if (packet instanceof ClientboundPlayerInfoPacket) {
          ClientboundPlayerInfoPacket _packet = (ClientboundPlayerInfoPacket) packet;

          PlayerListEntryAction action = _packet.getAction();

          for (PlayerListEntry entry : _packet.getEntries()) {
            if (action == PlayerListEntryAction.ADD_PLAYER) addPlayer(entry);
            else if (action == PlayerListEntryAction.UPDATE_GAMEMODE) updateGamemode(entry);
            else if (action == PlayerListEntryAction.UPDATE_LATENCY) updateLatency(entry);
            else if (action == PlayerListEntryAction.UPDATE_DISPLAY_NAME) updateDisplayName(entry);
            else if (action == PlayerListEntryAction.REMOVE_PLAYER) removePlayer(entry);
          }
        }
      }
    });
  }

  public final MutablePlayerListEntry getEntry (UUID uuid) {
    for (MutablePlayerListEntry candidate : list) {
      if (candidate.profile().getId().equals(uuid)) {
        return candidate;
      }
    }

    return null;
  }

  public final MutablePlayerListEntry getEntry (String username) {
    for (MutablePlayerListEntry candidate : list) {
      if (candidate.profile().getName().equals(username)) {
        return candidate;
      }
    }

    return null;
  }

  private final MutablePlayerListEntry getEntry (PlayerListEntry other) {
    return getEntry(other.getProfile().getId());
  }

  private void addPlayer (PlayerListEntry newEntry) {
    final MutablePlayerListEntry duplicate = getEntry(newEntry);
    if (duplicate != null) list.remove(duplicate);

    list.add(new MutablePlayerListEntry(newEntry));
    System.out.println("Added " + newEntry.getProfile().getName() + " to the player list.");
  }

  private void updateGamemode (PlayerListEntry newEntry) {
    final MutablePlayerListEntry target = getEntry(newEntry);
    if (target == null) return;

    target.gamemode(newEntry.getGameMode());
  }

  private void updateLatency (PlayerListEntry newEntry) {
    final MutablePlayerListEntry target = getEntry(newEntry);
    if (target == null) return;

    target.latency(newEntry.getPing());
  }

  private void updateDisplayName (PlayerListEntry newEntry) {
    final MutablePlayerListEntry target = getEntry(newEntry);
    if (target == null) return;

    target.displayName(newEntry.getDisplayName());
  }

  private void removePlayer (PlayerListEntry newEntry) {
    final MutablePlayerListEntry target = getEntry(newEntry);
    if (target == null) return;

    list.remove(target);
  }
}
