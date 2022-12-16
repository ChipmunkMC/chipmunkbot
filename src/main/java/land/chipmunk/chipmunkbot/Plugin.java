package land.chipmunk.chipmunkbot;

public class Plugin {
  public String id;
  public Client client;

  public Plugin (Client client, String id) {
    this.client = client;
    this.id = id;
  }
}
