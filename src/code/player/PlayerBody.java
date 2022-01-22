package code.player;

/**
 * @author Playper3 on 2021-12-23.
 * @project SubZeroSpace
 * @pakage player
 */

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;

public class PlayerBody extends AbstractAppState {

    private static CharacterControl player;
    private SimpleApplication app;
    private static Spatial hand;

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app;

        CapsuleCollisionShape capsuleShape = new CapsuleCollisionShape(1.5f, 6f, 1);
        player = new CharacterControl(capsuleShape, 0.05f);
        player.setJumpSpeed(15);
        player.setFallSpeed(15);
        player.setGravity(30);

        updateHand("gun_default", this.app.getAssetManager());
        hand.addControl(player);
        hand.setLocalScale(3);
        hand.setLocalTranslation(player.getPhysicsLocation());
        this.app.getRootNode().attachChild(hand);

        player.setPhysicsLocation(new Vector3f(0, 5, 0));
    }

    public static void updateHand(String item, AssetManager assetManager) {
        hand = assetManager.loadModel("Models/" + item + ".gltf");
    }

    public static CharacterControl getPlayer() {
        return player;
    }

    @Override
    public void update(float tpf) {
        player.setViewDirection(this.app.getCamera().getDirection().multLocal(-1));
    }

    public static void jump() {
        player.jump();
    }

    public static boolean isOnGround() {
        return player.onGround();
    }

    public static void setWalkDirection(Vector3f walkDirection) {
        player.setWalkDirection(walkDirection);
    }

    public static Vector3f getPhysicsLocation() {
        return player.getPhysicsLocation();
    }
}
