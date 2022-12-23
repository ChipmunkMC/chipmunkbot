package land.chipmunk.chipmunkbot;

import com.google.gson.JsonObject;

public interface Plugin {
  String id ();
  void inject (Client client, JsonObject options);
}
