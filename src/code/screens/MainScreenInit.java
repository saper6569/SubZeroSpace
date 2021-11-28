package code.screens;

import code.environment.ChunkLoader;
import code.environment.DefaultChunkLoader;
import code.environment.Lighting;
import code.player.PlayerBody;
import code.player.PlayerMovement;
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Spatial;

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
