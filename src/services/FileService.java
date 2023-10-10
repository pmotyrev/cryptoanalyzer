package services;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {
    /**
     * @param pathFileSource - String path to the source file
     * @return String - data from the file path pathFileSource.
     */
    public String readText(String pathFileSource) {
        try {
            return Files.readString(Path.of(pathFileSource));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method write data from textForWriting to the file using pathFileDestination path.
     * @param pathFileDestination - String path to the destination file
     * @param textForWriting - String text for writing
     */
    public void writeText(String pathFileDestination, String textForWriting) {
        try {
            Files.writeString(Path.of(pathFileDestination), textForWriting);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
