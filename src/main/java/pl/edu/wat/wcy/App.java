package pl.edu.wat.wcy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        if (args.length != 0) {
            String rootPath = args[0];
            CProgramAnalyzer analyzer = new CProgramAnalyzer();
            try (Stream<Path> paths = Files.walk(Paths.get(rootPath))) {
                paths.filter(path -> Files.isRegularFile(path))
                        .filter(path -> path.toString().endsWith(".c"))
                        .forEach(analyzer::analyze);
            } catch (IOException e) {
                System.out.println("Wrong path.");
            }
        } else {
            System.out.println("Please provide path to file or directory...");
        }
    }

}
