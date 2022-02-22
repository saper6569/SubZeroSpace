package code.screens;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.math.ColorRGBA;

/**
 * @author Playper3 on 2022-01-24.
 * @project SubZeroSpace
 * @pakage screens
 */
public class Gui extends AbstractAppState {
    
    private SimpleApplication app;

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app;
        HUD();
    }

    private void HUD() {
        BitmapFont guiFont = this.app.getAssetManager().loadFont("Interface/Fonts/Default.fnt");
        BitmapText crosshair = new BitmapText(guiFont, false);
        crosshair.setSize(guiFont.getCharSet().getRenderedSize() * 2);
        crosshair.setText("+"); 
        crosshair.setLocalTranslation( this.app.getCamera().getWidth() / 2 - crosshair.getLineWidth()/2,this.app.getCamera().getHeight() / 2 + crosshair.getLineHeight()/2, 0);
        this.app.getGuiNode().attachChild(crosshair);
        
        BitmapText healthDisplay = new BitmapText(guiFont, false);
        healthDisplay.setSize(guiFont.getCharSet().getRenderedSize() * 1.25f);
        healthDisplay.setColor(ColorRGBA.Black);                             
        healthDisplay.setText("Health :");            
        healthDisplay.setLocalTranslation(0, this.app.getCamera().getHeight(), 0);
        this.app.getGuiNode().attachChild(healthDisplay);
    }
}
