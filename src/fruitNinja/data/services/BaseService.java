package fruitNinja.data.services;

import java.io.File;

public abstract class BaseService<T> implements Service<T> {
    private File playersFile;

    public BaseService()
    {
        setFiles();
    }

    private void setFiles()
    {
        playersFile = new File("src/fruitNinja/data/files/players.xml");
    }


    public File getPlayersFile() {
        return playersFile;
    }
}
