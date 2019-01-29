package org.repanda.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Khaled BOUSSAIDI
 */
public class FileTest {

    public String locateFile(String fileName) throws IOException {
        String home = System.getProperty("user.home");

        Path p = Paths.get(home + File.separator + "working" + File.separator + "mygit" + File.separator + "shell");

        Optional<Path> findAny = Files.walk(p, Integer.MAX_VALUE).filter((t) -> {
            return t.toFile().isFile() && t.getFileName().toString().equals(fileName);
        }).findAny();

        if (findAny.isPresent()) {
            Path get = findAny.get();
            return get.toString();
        }

        return null;
    }

    @Test
    public void GivenFileName_WhenLocateIt_ThenGetItsAbsolutePath() throws IOException {

        assertNotNull(locateFile("toto"));
        assertNull(locateFile("shell")); // exclude folders
    }

}
