package code.environment;

import code.screens.MainScreenInit;
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.scene.Spatial;

public class DefaultChunkLoader extends AbstractAppState {

    private SimpleApplication app;
    private Spatial map;
    private RigidBodyControl mapSpace;
    private BulletAppState bulletAppState;
    private MainScreenInit mainScreen = new MainScreenInit();

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app;

        map = this.app.getAssetManager().loadModel("Models/Chunks1-5/1.gltf");
        map.center();
        map.setLocalScale(3f);
        this.app.getRootNode().attachChild(map);

        CollisionShape sceneShape = CollisionShapeFactory.createMeshShape(map);
        mapSpace = new RigidBodyControl(sceneShape, 0);
        map.addControl(mapSpace);

        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);
        bulletAppState.getPhysicsSpace().add(mapSpace);
        bulletAppState.getPhysicsSpace().add(mainScreen.getPlayer());
    }
}
