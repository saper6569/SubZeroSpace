package code.screens;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;

/**
 * @author Playper3 on 2022-01-23.
 * @project SubZeroSpace
 * @pakage screens
 */
public class Camera extends AbstractAppState {

    private SimpleApplication app;

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app;
    }

//    @Override
//    public void update(float tpf) {
//        if (this.app.getCamera().getDirection().getY() > 0.9) {
//            this.app.getCamera().getDirection().setY(0.9f);
//        }
//    }

    public com.jme3.renderer.Camera getCamera() {
        return this.app.getCamera();
    }
}
