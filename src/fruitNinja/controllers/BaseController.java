package fruitNinja.controllers;

import fruitNinja.models.audios.AudioController;
import fruitNinja.utils.Utils;
import fruitNinja.views.guiUtils.Alerts;
import fruitNinja.views.guiUtils.Navigation;

public abstract class BaseController {
    protected Navigation navigation = new Navigation();
    protected Utils utils = new Utils();
    protected Alerts alerts = new Alerts();
    protected AudioController audioController = new AudioController();
}
