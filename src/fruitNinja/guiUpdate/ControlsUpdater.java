package fruitNinja.guiUpdate;

public class ControlsUpdater {
    public EventManager eventManager;

    public ControlsUpdater()
    {
        eventManager = new EventManager();
    }

    public void sliceOrdinaryFruit(int amount)
    {
        eventManager.notify("sliceOrdinary", String.valueOf(amount));
    }

}
