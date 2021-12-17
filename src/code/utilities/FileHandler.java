package code.utilities;

import code.environment.ChunkLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {

    public static void readChunkInfo(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        ChunkLoader chunkLoader = new ChunkLoader();
        while (scanner.hasNextLine()) {
            chunkLoader.loadChunk(scanner.nextLine());
        }
    }

    public static void readLine(String fileName, int line) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        ChunkLoader chunkLoader = new ChunkLoader();
        for (int i = 1; i <= line; i++) {
            if (i == line) {
                chunkLoader.loadChunk(scanner.nextLine());
                break;
            }
            scanner.nextLine();
        }
    }

    public static int getLines(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int lines = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            lines++;
        }
        return lines;
    }
}
