package code.player;

import code.utilities.GameObject;
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;

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
    }

    @Override
    public void update(float tpf) {
        time += tpf;
    }

    public void updateHunger() {

    }

    public void updateHydration() {

    }

    public void updateHealth() {

    }

    private void AutoSave() {

    }
}
