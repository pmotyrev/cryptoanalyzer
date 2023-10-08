package validators;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileValidator {
    /**
     * @param pathString - String path to the checked file
     * @return true if the path is correct and indicates an existing file.
     * If the path invalid, or the path indicate the directory
     * or there is no file at this path method return false.
     */
    public boolean isPathCorrect(String pathString) {
        try {
            Path path = Path.of(pathString);
            return Files.exists(path) && !Files.isDirectory(path);
        } catch (Exception e) {
            return false;
        }
    }
}
