package land.chipmunk.chipmunkbot;

import com.github.steveice10.mc.auth.service.AuthenticationService;
import com.github.steveice10.mc.protocol.MinecraftProtocol;
import com.github.steveice10.packetlib.ProxyInfo;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.tcp.TcpClientSession;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Client {
  private Session session;
  private Map<String, Plugin> plugins = new HashMap();

  public Client (ClientOptions options) {
    Session session = new TcpClientSession(options.host(), options.port(), options.protocol(), options.proxy());
    this.session = session;

    session.connect();
  }

  public Session session () {
    return session;
  }

  public Plugin getPlugin (String id) { return plugins.get(id); }

  public void loadPlugin (Class<? extends Plugin> pluginClass) {
    try {
      Constructor<? extends Plugin> constructor = pluginClass.getConstructor(Client.class);
      Plugin plugin = constructor.newInstance(this);
      plugins.put(plugin.id, plugin);
    } catch (Exception ignored) {
    }
  }

  // TODO: Maybe also add unloading?

  public void inject (Injector injector) {
    injector.inject(this);
  }
}
