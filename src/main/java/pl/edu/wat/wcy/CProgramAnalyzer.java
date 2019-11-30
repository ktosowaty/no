package pl.edu.wat.wcy;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Path;

public class CProgramAnalyzer {

    public void analyze(Path path) {
        try {
            System.out.println("Analyzing program: " + path.getFileName());
            CLexer lexer = new CLexer(new ANTLRFileStream(path.toString()));
            CParser parser = new CParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.compilationUnit();
            CVisitorImpl visitor = new CVisitorImpl();
            visitor.visit(tree);
            ProgramParams params = visitor.getParams();
            HalsteadMetrics halsteadMetrics = new HalsteadMetrics(params);
            params.print();
            halsteadMetrics.print();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
