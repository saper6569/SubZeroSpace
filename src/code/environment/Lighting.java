package code.environment;

/**
 * @author Playper3 on 2021-12-23.
 * @project SubZeroSpace
 * @pakage environment
 */

import com.jme3.light.AmbientLight;
import com.jme3.light.SpotLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.renderer.Camera;

public class Lighting {

    public static AmbientLight setupLight(ColorRGBA colour) {
        AmbientLight light = new AmbientLight();
        light.setColor(colour);
        return light;
    }

    public static SpotLight setupLight(Camera cam) {
        SpotLight spot = new SpotLight();
        spot.setSpotRange(100f);
        spot.setSpotInnerAngle(15f * FastMath.DEG_TO_RAD);
        spot.setSpotOuterAngle(35f * FastMath.DEG_TO_RAD);
        spot.setColor(ColorRGBA.White.mult(1.3f));
        spot.setPosition(cam.getLocation());
        spot.setDirection(cam.getDirection());
        return spot;
    }

    public static void LoadLight() {

    }
}
