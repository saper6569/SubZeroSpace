package code;

/**
 * @author Playper3 on 2021-12-23.
 * @project SubZeroSpace
 * @pakage code
 */

import code.screens.MainScreenInit;
import code.utilities.Variables;
import com.jme3.app.SimpleApplication;
import com.jme3.math.ColorRGBA;
import com.jme3.system.AppSettings;

public class Main extends SimpleApplication {

    MainScreenInit mainScreenSetup = new MainScreenInit();

    public static void main(String[] args) {
        AppSettings settings = new AppSettings(true);
        settings.setTitle(Variables.NAME + " " + Variables.REALEASE_VERSION);
        settings.setResolution(1000,700);

        Main app = new Main();
        app.setSettings(settings);
        app.setShowSettings(false);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        stateManager.attach(mainScreenSetup);
        viewPort.setBackgroundColor(new ColorRGBA(0f, 0f, 0f, 1f));
    }
}
