package code.player;

import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

public class PlayerBody {

    private static CharacterControl player;

    public void initialize(Node node) {
        CapsuleCollisionShape capsuleShape = new CapsuleCollisionShape(1.5f, 6f, 1);
        player = new CharacterControl(capsuleShape, 0.05f);

        player.setJumpSpeed(15);
        player.setFallSpeed(10);
        player.setGravity(30);
        player.setPhysicsLocation(new Vector3f(0, 5, 0));
    }

    public Object getPlayer() {
        return player;
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
