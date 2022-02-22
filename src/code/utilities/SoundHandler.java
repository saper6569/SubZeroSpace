package code.utilities;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.audio.AudioData;
import com.jme3.audio.AudioNode;
import com.jme3.audio.AudioSource;

/**
 * @author Playper3 on 2021-12-31.
 * @project SubZeroSpace
 * @pakage utilities
 */
public class SoundHandler extends AbstractAppState {
    private SimpleApplication app;
    private static AudioNode walkingFX, laserFX, OST1, OST2, OST3, OST4, OST5;
    private static float time = 0;

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app;

        walkingFX = new AudioNode(this.app.getAssetManager(), "Sounds/effects/footsteps.wav", AudioData.DataType.Buffer);
        walkingFX.setLooping(true);
        walkingFX.setPositional(false);
        walkingFX.setVolume(0.5f);
        laserFX = new AudioNode(this.app.getAssetManager(), "Sounds/effects/laser.wav", AudioData.DataType.Buffer);
        laserFX.setPositional(false);
        OST1 = new AudioNode(this.app.getAssetManager(), "Sounds/OST v.1/Ambient Symphony.ogg", AudioData.DataType.Stream);
        OST1.setPositional(false);
        OST1.setVolume(Variables.VOLUME);
        OST2 = new AudioNode(this.app.getAssetManager(), "Sounds/OST v.1/Black Screen.ogg", AudioData.DataType.Stream);
        OST2.setPositional(false);
        OST2.setVolume(Variables.VOLUME);
        OST3 = new AudioNode(this.app.getAssetManager(), "Sounds/OST v.1/Chloe.ogg", AudioData.DataType.Stream);
        OST3.setPositional(false);
        OST3.setVolume(Variables.VOLUME);
        OST4 = new AudioNode(this.app.getAssetManager(), "Sounds/OST v.1/Electronic Lullaby.ogg", AudioData.DataType.Stream);
        OST4.setPositional(false);
        OST4.setVolume(Variables.VOLUME);
        OST5 = new AudioNode(this.app.getAssetManager(), "Sounds/OST v.1/Nocturnal.ogg", AudioData.DataType.Stream);
        OST5.setPositional(false);
        OST5.setVolume(Variables.VOLUME);
    }

    public void walking() {
        walkingFX.play();
    }

    public void stopWalking() {
        walkingFX.stop();
    }

    public void shoot() {
        laserFX.play();
    }

    @Override
    public void update(float tpf) {
        time += tpf;
        if (time > 500 && !isPlaying()) {
            int trackNum = (int)(Math.random() * ((5 - 1) + 1)) + 1;
            System.out.println(trackNum);
            if (trackNum == 1) {
                OST1.play();
            }
            if (trackNum == 2) {
                OST2.play();
            }
            if (trackNum == 3) {
                OST3.play();
            }
            if (trackNum == 4) {
                OST4.play();
            }
            if (trackNum == 5) {
                OST5.play();
            }
            time = 0;
        }
    }

    private boolean isPlaying() {
        if (OST1.getStatus().equals(AudioSource.Status.Playing)) {
            return true;
        }
        else if (OST2.getStatus().equals(AudioSource.Status.Playing)) {
            return true;
        }
        else if (OST3.getStatus().equals(AudioSource.Status.Playing)) {
            return true;
        }
        else if (OST4.getStatus().equals(AudioSource.Status.Playing)) {
            return true;
        }
        else if (OST5.getStatus().equals(AudioSource.Status.Playing)) {
            return true;
        }
        else {
            return false;
        }
    }
}
