package code;

import code.screens.MainScreenInit;
import com.jme3.app.SimpleApplication;
import com.jme3.math.ColorRGBA;

public class Main extends SimpleApplication {

    MainScreenInit mainScreenSetup = new MainScreenInit();

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        stateManager.attach(mainScreenSetup);
        viewPort.setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));
        flyCam.setMoveSpeed(100);
    }
}
