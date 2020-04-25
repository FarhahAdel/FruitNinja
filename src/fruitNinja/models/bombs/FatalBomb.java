package fruitNinja.models.bombs;

import fruitNinja.guiUpdate.ControlsUpdaterSingleton;

public class FatalBomb extends Bomb{
    public FatalBomb() {
        super(BombType.FATAL);
        setImage("/fruitNinja/views/images/FatalBomb.png");
    }
    @Override
    public void slice(){
        ControlsUpdaterSingleton.getInstance().sliceFatalBomb();
    }
}
