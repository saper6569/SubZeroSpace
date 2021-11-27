package code.screens;

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
    private Spatial map;
    private RigidBodyControl mapSpace;
    private BulletAppState bulletAppState;

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app;
        this.app.setDisplayStatView(false);

        PlayerMovement movement = new PlayerMovement();
        PlayerBody player = new PlayerBody();

        player.initialize(this.app.getRootNode());
        stateManager.attach(movement);

        map = this.app.getAssetManager().loadModel("Models/hallway.gltf");
        map.setLocalScale(2.5f);
        this.app.getRootNode().attachChild(map);

        CollisionShape sceneShape = CollisionShapeFactory.createMeshShape(map);
        mapSpace = new RigidBodyControl(sceneShape, 0);
        map.addControl(mapSpace);

        this.app.getRootNode().addLight(Lighting.setupLight(ColorRGBA.White.mult(10)));
        this.app.getRootNode.addLight(Lighting.)

        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);
        bulletAppState.getPhysicsSpace().add(mapSpace);
        bulletAppState.getPhysicsSpace().add(player.getPlayer());
    }
}
