package code.screens;

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

        PlayerMovement movement = new PlayerMovement();
        DefaultChunkLoader defaultChunkLoader = new DefaultChunkLoader();

        player.initialize(this.app.getRootNode());
        stateManager.attach(movement);
        stateManager.attach(defaultChunkLoader);
    }

    public Object getPlayer() {
        return player.getPlayer();
    }
}
