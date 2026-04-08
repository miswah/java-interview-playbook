public class ConfigurationManager {

    private static volatile ConfigurationManager instance = null;
    private volatile ServerConfig config;

    private ConfigurationManager(){

        if(instance != null){
            throw new RuntimeException("Instance Already Exists");
        }
            config = new ServerConfig("127.0.0.1", 8080, 100, true);
    }

    public static ConfigurationManager getInstance(){
        if(instance == null){
            synchronized(ConfigurationManager.class){
                if(instance == null){
                  instance = new ConfigurationManager();
                 }
            }
        }

        return instance;
    }

    public ServerConfig getConfig() {
        return config;
    }

    public void updateConfig(ServerConfig newConfig){
        config = newConfig;
    }

}
