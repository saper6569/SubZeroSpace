package code.environment;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;

public class ChunkLoader extends AbstractAppState {

    private SimpleApplication app;

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app;
    }

    public void loadChunk(String instruction) {
        for (int i = 0; i > instruction.length() - 1; i++){
            if (i < 10) {
                chunkFinder(instruction.charAt(i));
                if (i < 3) {

                    if (i < 7) {

                    }
                }
            }
        }
    }

    private void chunkFinder(int CHUNK_ID) {

    }
}
