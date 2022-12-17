package land.chipmunk.chipmunkbot;

import com.github.steveice10.mc.auth.service.AuthenticationService;
import com.github.steveice10.mc.protocol.MinecraftProtocol;
import com.github.steveice10.packetlib.ProxyInfo;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.tcp.TcpClientSession;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientOptions {
  private String host;
  private int port;
  private MinecraftProtocol protocol;
  private ProxyInfo proxy;

  /* public ClientOptions profile (GameProfile profile) {
    protocol(new MinecraftProtocol(profile));
    return this;
  } */

  public ClientOptions username (String username) {
    protocol(new MinecraftProtocol(username));
    return this;
  }
}
