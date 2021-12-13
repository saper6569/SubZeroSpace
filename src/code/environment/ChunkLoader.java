package code.environment;

import code.screens.MainScreenInit;
import code.utilities.FileHandler;
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.scene.Spatial;

import java.io.IOException;
import java.util.ArrayList;

public class ChunkLoader extends AbstractAppState {

    private SimpleApplication app;
    private Spatial map;
    private RigidBodyControl mapSpace;
    private BulletAppState bulletAppState;
    private MainScreenInit mainScreen = new MainScreenInit();

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app;

        bulletAppState = new BulletAppState();

        try {
            FileHandler.readChunkInfo("Saves/CHUNK_INFO.txt");
        } catch (IOException e) { e.printStackTrace(); }

        stateManager.attach(bulletAppState);
    }

    public void loadChunk(String instruction) {
        ArrayList<String> xCoord = new ArrayList<>();
        ArrayList<String> yCoord = new ArrayList<>();
        for (int i = 1; i < instruction.length() - 1; i++) {
            if (i < 4) {
                xCoord.add(String.valueOf(instruction.charAt(i)));
            }
            if (i > 3 || i < 7) {
                yCoord.add(String.valueOf(instruction.charAt(i)));
            }
        }
        chunkFinder(instruction.charAt(0), Integer.parseInt(xCoord.toString()), Integer.parseInt(yCoord.toString()), instruction.charAt(7));
    }

    private void chunkFinder(int CHUNK_ID, int xCoord, int yCoord, char rotation) {
        map = this.app.getAssetManager().loadModel("Models/Chunks1-5/" + CHUNK_ID + ".gltf");

        CollisionShape sceneShape = CollisionShapeFactory.createMeshShape(map);
        mapSpace = new RigidBodyControl(sceneShape, 0);
        map.addControl(mapSpace);

        bulletAppState.getPhysicsSpace().add(mapSpace);
        bulletAppState.getPhysicsSpace().add(mainScreen.getPlayer());

        this.app.getRootNode().attachChild(map);
    }
}
