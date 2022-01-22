package code.screens;

/**
 * @author Playper3 on 2021-12-23.
 * @project SubZeroSpace
 * @pakage screens
 */

import code.environment.ChunkLoader;
import code.player.PlayerBody;
import code.player.PlayerMovement;
import code.utilities.Picking;
import code.utilities.SoundHandler;
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.light.Light;


public class MainScreenInit extends AbstractAppState {

    private SimpleApplication app;
    PlayerBody player = new PlayerBody();

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app;
        this.app.setDisplayStatView(false);

        //attaching app states and game objects
        PlayerMovement movement = new PlayerMovement();
        ChunkLoader chunkLoader = new ChunkLoader();
        Picking picker = new Picking();
        SoundHandler sound = new SoundHandler();

        stateManager.attach(player);
        stateManager.attach(movement);
        stateManager.attach(chunkLoader);
        stateManager.attach(picker);
        stateManager.attach(sound);
    }

    public Object getPlayer() {
        return player.getPlayer();
    }

    public void attachLight(Light light) {
        this.app.getRootNode().addLight(light);
    }
}
