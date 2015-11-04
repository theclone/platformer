import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Logger;
import java.nio.file.attribute.*;

/*
    Loads DLL files
 */
public class LibraryLoader {
    private static final String TEMPDIR = "tempLibs";
    private final static Logger logger = Logger.getLogger("libraries");
    private final static String JINPUT = "jinput-raw_64";
    private final static String LWJGL = "lwjgl64";
    private final static String OPENAL = "OpenAL64";
    private final static String LIBPATH = "libs";
    private static Path tempPath;

    static {
        logger.info("Loading DLL");
        try {
            System.loadLibrary(JINPUT);
            System.loadLibrary(LWJGL);
            System.loadLibrary(OPENAL);
            logger.info("DLL is loaded from memory");
        } catch (UnsatisfiedLinkError e) {
            loadFromJar();
        }
    }

    /**
     * When packaged into JAR extracts DLLs, places these into
     */
    private static void loadFromJar() {
        // put all DLLs to temp dir
        try {
            tempPath = Files.createTempDirectory(TEMPDIR, (FileAttribute<?>[])null);
        } catch (IOException e) {
            logger.info("Cannot create temp directory");
        }
        loadLib(JINPUT);
        loadLib(LWJGL);
        loadLib(OPENAL);
    }

    /**
     * Puts library to temp dir and loads to memory
     */
    private static void loadLib(String name) {
        Path sourcePath = Paths.get(LIBPATH,name);
        try {
            Path libPath = Files.copy(sourcePath, tempPath, StandardCopyOption.REPLACE_EXISTING);
            System.load(libPath.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
