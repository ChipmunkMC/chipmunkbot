package land.chipmunk.chipmunkbot.data;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.protocol.data.game.PlayerListEntry;
import com.github.steveice10.mc.protocol.data.game.entity.player.GameMode;
import net.kyori.adventure.text.Component;

import java.security.PublicKey;

public class MutablePlayerListEntry {
  private GameProfile profile;
  private GameMode gamemode;
  private int latency;
  private Component displayName;
  private long expiresAt;
  private PublicKey publicKey;
  private byte[] keySignature;

  public MutablePlayerListEntry (GameProfile profile, GameMode gamemode, int latency, Component displayName, long expiresAt, PublicKey publicKey, byte[] keySignature) {
    this.profile = profile;
    this.gamemode = gamemode;
    this.latency = latency;
    this.displayName = displayName;
    this.expiresAt = expiresAt;
    this.publicKey = publicKey;
    this.keySignature = keySignature;
  }

  public MutablePlayerListEntry (PlayerListEntry entry) {
    this(entry.getProfile(), entry.getGameMode(), entry.getPing(), entry.getDisplayName(), entry.getExpiresAt(), entry.getPublicKey(), entry.getKeySignature());
  }

  public GameProfile profile () { return this.profile; }

  public void profile (GameProfile profile) { this.profile = profile; }

  public GameMode gamemode () { return this.gamemode; }

  public void gamemode (GameMode gamemode) { this.gamemode = gamemode; }

  public int latency () { return this.latency; }

  public void latency (int latency) { this.latency = latency; }

  public Component displayName () { return this.displayName; }

  public void displayName (Component displayName) { this.displayName = displayName; }

  public long expiresAt () { return this.expiresAt; }

  public void expiresAt (long expiresAt) { this.expiresAt = expiresAt; }

  public PublicKey publicKey () { return this.publicKey; }

  public void publicKey (PublicKey publicKey) { this.publicKey = publicKey; }

  public byte[] keySignature () { return this.keySignature; }

  public void keySignature (byte[] keySignature) { this.keySignature = keySignature; }
}
