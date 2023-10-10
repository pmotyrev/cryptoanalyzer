package validators;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PathValidator {
    private static final String[] forbiddenDirectories = {"bash_history", "bash_logout", "bash_profile", "bashrc",
            "gtkrc", "login", "logout", "profile", "viminfo", "wm_style", "Xdefaults", "Xresources", "xinitrc",
            "xsession", "dev", "etc", "proc", "var", "bin", "boot", "home", "lib", "mnt", "proc", "root", "sbin",
            "tmp", "usr", "var"};
    private static final Set<String> setForbiddenDirectories = new HashSet<>(Arrays.asList(forbiddenDirectories));
    private static final String regex = "/|\\\\";

    /**
     * @param pathString - path to the file
     * @return true if path has forbidden directories and false if path doesn't have it.
     */
    public boolean isForbiddenPath(String pathString) {
        if (pathString.length() > 0) {
            String[] splitPathString = pathString.split(regex);

            for (String s : splitPathString) {
                if (setForbiddenDirectories.contains(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
