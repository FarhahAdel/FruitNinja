package fruitNinja.models.gameActions;

import fruitNinja.models.GameObject;

public interface GameActions {
   GameObject createGameObject();
   void updateObjectsLocations();
   void sliceObjects();
   void saveGame();
   void loadGame();
   void resetGame();
}
