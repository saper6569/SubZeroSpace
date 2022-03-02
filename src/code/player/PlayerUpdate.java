package code.player;

import code.utilities.FileHandler;
import code.utilities.GameObject;
import code.utilities.Variables;
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Playper3 on 2022-01-23.
 * @project SubZeroSpace
 * @pakage player
 */
public class PlayerUpdate extends AbstractAppState {
    private static float HEALTH;
    private static String NAME;
    private static Vector3f LOCATION;
    public static float HUNGER;
    public static String HAND;
    public static float HYDRATION;
    public static GameObject[] INVENTORY;
    float time = 0;

    private SimpleApplication app;

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app;

        try {
            FileHandler.setPlayerStats(Variables.PLAYER_DATA, HUNGER, HYDRATION, HEALTH, NAME);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(float tpf) {
        time += tpf;
    }

    public static void updateHunger(int increment) {
        HUNGER += increment;
    }

    public static void updateHydration(int increment) {
        HYDRATION += increment;
    }

    public static void updateHealth(int increment) {
        HEALTH += increment;
    }

    private static void AutoSave() throws IOException {
        FileHandler.writeLog(Variables.PLAYER_DATA);
    }
}
