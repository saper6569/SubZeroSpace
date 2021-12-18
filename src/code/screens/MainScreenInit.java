package code.screens;

import code.environment.ChunkLoader;
import code.environment.DefaultChunkLoader;
import code.player.PlayerBody;
import code.player.PlayerMovement;
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;


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

        player.initialize(this.app.getRootNode());
        stateManager.attach(movement);
        stateManager.attach(chunkLoader);
    }

    public Object getPlayer() {
        return player.getPlayer();
    }
}
