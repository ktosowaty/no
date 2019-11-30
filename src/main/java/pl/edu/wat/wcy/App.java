package pl.edu.wat.wcy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class App {

    private static final String BASE_ROOT_PATH = "src/main/resources";

    public static void main(String[] args) {
        String rootPath = getRootPath(args);
        CProgramAnalyzer analyzer = new CProgramAnalyzer();
        try (Stream<Path> paths = Files.walk(Paths.get(rootPath))) {
            paths.filter(path -> Files.isRegularFile(path))
                    .filter(path -> path.toString().endsWith(".c"))
                    .forEach(analyzer::analyze);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getRootPath(String[] args) {
        return (args.length != 0) ? args[0] : BASE_ROOT_PATH;
    }

}
