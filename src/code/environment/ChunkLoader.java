package code.environment;

import code.screens.MainScreenInit;
import code.utilities.FileHandler;
import code.utilities.Variables;
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.math.FastMath;
import com.jme3.scene.Spatial;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ChunkLoader extends AbstractAppState {

    private SimpleApplication app;
    private MainScreenInit mainScreen = new MainScreenInit();

    private static String CHUNK_ID;
    private static int xTranslation, zTranslation;
    private static char rotation;

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app;



        BulletAppState bulletAppState = new BulletAppState();

        try {
            for (int i = FileHandler.getLines(Variables.SAVE_DATA); i > 0; i--) {
                try {
                    FileHandler.readLine(Variables.SAVE_DATA, i);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Spatial chunk = this.app.getAssetManager().loadModel("Models/Chunks1-5/" + CHUNK_ID + ".gltf");
                chunk.setLocalScale(3f);
                chunk.setLocalTranslation(xTranslation * 3, 0, zTranslation * 3);

                switch (rotation) {
                    case '1':
                        chunk.rotate(0, 0, 0);
                        break;
                    case '2':
                        chunk.rotate(0, FastMath.PI / 2, 0);
                        break;
                    case '3':
                        chunk.rotate(0, FastMath.PI, 0);
                        break;
                    case '4':
                        chunk.rotate(0, FastMath.PI * 3 / 2, 0);
                        break;
                }

                CollisionShape sceneShape = CollisionShapeFactory.createMeshShape(chunk);
                RigidBodyControl chunkBody = new RigidBodyControl(sceneShape, 0);
                chunk.addControl(chunkBody);

                stateManager.attach(bulletAppState);
                bulletAppState.getPhysicsSpace().add(chunkBody);
                bulletAppState.getPhysicsSpace().add(mainScreen.getPlayer());

                this.app.getRootNode().attachChild(chunk);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void loadChunk(String instruction) {
        ArrayList<String> xCoordinate = new ArrayList<>();
        ArrayList<String> zCoordinate = new ArrayList<>();
        for (int i = 1; i < instruction.length() - 1; i++) {
            if (i < 4) {
                xCoordinate.add(String.valueOf(instruction.charAt(i)));
            }
            if (i > 3 && i < 7) {
                zCoordinate.add(String.valueOf(instruction.charAt(i)));
            }
        }

        xTranslation = Integer.parseInt(String.join("", xCoordinate));
        zTranslation = Integer.parseInt(String.join("", zCoordinate));
        CHUNK_ID = String.valueOf(instruction.charAt(0));
        rotation = instruction.charAt(7);
    }
}
