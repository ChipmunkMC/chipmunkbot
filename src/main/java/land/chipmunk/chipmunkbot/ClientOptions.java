package land.chipmunk.chipmunkbot;

import com.github.steveice10.mc.auth.service.AuthenticationService;
import com.github.steveice10.mc.protocol.MinecraftProtocol;
import com.github.steveice10.packetlib.ProxyInfo;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.tcp.TcpClientSession;

public class ClientOptions {
  private String host;
  private int port;
  private MinecraftProtocol protocol;
  private ProxyInfo proxy;

  public ClientOptions (String host, int port, MinecraftProtocol protocol, ProxyInfo proxy) {
    this.host = host;
    this.port = port;
    this.protocol = protocol;
    this.proxy = proxy;
  }

  public ClientOptions () { // So it can easily be used as a builder
  }

  public String host () {
    return host;
  }

  public ClientOptions host (String value) {
    host = value;
    return this;
  }

  public int port () {
    return port;
  }

  public ClientOptions port (int value) {
    port = value;
    return this;
  }

  public MinecraftProtocol protocol () {
    return protocol;
  }

  public ClientOptions protocol (MinecraftProtocol value) {
    protocol = value;
    return this;
  }

  /* public ClientOptions profile (GameProfile profile) {
    protocol(new MinecraftProtocol(profile));
    return this;
  } */

  public ClientOptions username (String username) {
    protocol(new MinecraftProtocol(username));
    return this;
  }

  public ProxyInfo proxy () {
    return proxy;
  }

  public ClientOptions proxy (ProxyInfo value) {
    proxy = value;
    return this;
  }
}
