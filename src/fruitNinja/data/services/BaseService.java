package fruitNinja.data.services;

import java.io.File;

public abstract class BaseService<T> implements Service<T> {
    private File playersFile;
    private File urlsFile;
    private File scoresFile;

    public BaseService()
    {
        setFiles();
    }

    private void setFiles()
    {
        playersFile = new File("src/fruitNinja/data/files/players.xml");
        urlsFile=new File("src/fruitNinja/data/files/url.xml");
        scoresFile=new File("src/fruitNinja/data/files/scores.xml");
    }


    public File getPlayersFile() {
        return playersFile;
    }
    public File getUrlsFile(){
        return urlsFile;
    }
    public File getScoresFile(){
        return scoresFile;
    }
}
