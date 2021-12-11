package code.utilities;

import code.environment.ChunkLoader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {

    public void read(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        ChunkLoader chunkLoader = new ChunkLoader();
        while (sc.hasNextLine()) {
            chunkLoader.loadChunk(sc.nextLine());
        }
    }
}
