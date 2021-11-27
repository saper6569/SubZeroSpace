package code.environment;

import com.jme3.light.AmbientLight;
import com.jme3.math.ColorRGBA;

public class Lighting {

    public static AmbientLight setupLight(ColorRGBA colour) {
        AmbientLight light = new AmbientLight();
        light.setColor(colour);
        return light;
    }

    public static 
}
