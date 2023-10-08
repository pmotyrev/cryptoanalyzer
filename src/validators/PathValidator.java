package validators;

import constants.Constants;

public class PathValidator {
    /**
     * @param pathString - path to the file
     * @return true if path has forbidden directories and false if path doesn't have it.
     */
    public boolean isForbiddenPath(String pathString) {
        boolean isPathForbidden = false;
        if (pathString.length() > 0) {
            String[] splitPathString = pathString.split("/|\\\\");

            for (String s : splitPathString) {
                if (Constants.setForbiddenDirectories.contains(s)) {
                    isPathForbidden = true;
                    break;
                }
            }
        }
        return isPathForbidden;
    }
}
