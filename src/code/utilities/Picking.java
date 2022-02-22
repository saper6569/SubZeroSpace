package code.utilities;

import code.environment.ChunkLoader;
import code.player.PlayerBody;
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.collision.CollisionResult;
import com.jme3.collision.CollisionResults;
import com.jme3.effect.ParticleEmitter;
import com.jme3.effect.ParticleMesh;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

/**
 * @author Playper3 on 2021-12-28.
 * @project SubZeroSpace
 * @pakage utilities
 */

public class Picking extends AbstractAppState implements ActionListener {

    private SimpleApplication app;
    private Node physicsObjects;
    private ChunkLoader chunkLoader;
    private static ParticleEmitter effect;
    private CollisionResults results;
    private float time;
    private SoundHandler FX = new SoundHandler();

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication)app;

        chunkLoader = new ChunkLoader();
        physicsObjects = new Node("Shootables");
        physicsObjects.attachChild(chunkLoader.getMap());
        this.app.getRootNode().attachChild(physicsObjects);

        initKeys();

        effect = new ParticleEmitter("Debris", ParticleMesh.Type.Triangle, 10);
        Material effect_mat = new Material(this.app.getAssetManager(), "Common/MatDefs/Misc/Particle.j3md");
        effect_mat.setTexture("Texture", this.app.getAssetManager().loadTexture("Effects/debris.png"));
        effect.setMaterial(effect_mat);
        effect.setSelectRandomImage(true);
        effect.setRandomAngle(true);
        effect.setRotateSpeed(FastMath.TWO_PI * 4);
        effect.setStartColor(new ColorRGBA(ColorRGBA.Gray));
        effect.setEndColor(new ColorRGBA(ColorRGBA.DarkGray));
        effect.setStartSize(.2f);
        effect.setEndSize(.2f);

        effect.setParticlesPerSec(0);
        effect.setGravity(0, 12f, 0);
        effect.setLowLife(1.4f);
        effect.setHighLife(1.5f);
        effect.getParticleInfluencer().setInitialVelocity(new Vector3f(0, 15, 0));
        effect.getParticleInfluencer().setVelocityVariation(.60f);
        effect.setImagesX(3);
        effect.setImagesY(3);
        this.app.getRootNode().attachChild(effect);
    }

    private void initKeys() {
        this.app.getInputManager().addMapping("Shoot", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
        this.app.getInputManager().addListener(this, "Shoot");
    }

    @Override
    public void onAction(String name, boolean keyPressed, float tpf) {
        if (name.equals("Shoot") && !keyPressed) {
            PlayerBody.updateHand("gun_default", this.app.getAssetManager());
            results = new CollisionResults();
            Ray ray = new Ray(this.app.getCamera().getLocation(), this.app.getCamera().getDirection());
            physicsObjects.collideWith(ray, results);

            if (results.size() > 0) {
                time = 0;
                FX.shoot();
                CollisionResult closest = results.getClosestCollision();
                effect.setLocalTranslation(closest.getContactPoint());
                effect.emitAllParticles();
                results.clear();
            }
        }
    }

    @Override
    public void update(float tpf) {
        time = tpf + time;

        if (time > 1) {
            effect.killAllParticles();
            time = 0;
        }
    }
}
