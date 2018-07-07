import ast.Program;
import ast.ProgramInner;
import ast.ProgramInnerList;
import code_generation.CodeGenerator;
import code_generation.LLVMCodeGenerator;
import code_generation.ObjectCode;
import org.jllvm.LLVMInstruction;
import org.jllvm.bindings.LLVMCodeGenFileType;
import org.jllvm.bindings.LLVMOpcode;
import parsers.Parser;
import scanner.LexerAnalyser;
import stp.STPExecutor;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class LexerTester {
    public static void main(String[] args) throws Exception {
        Reader reader = new FileReader("src/test_cases/10-repeat.ppp");
        LexerAnalyser analyser = new LexerAnalyser(reader);
        Parser parser = new Parser(analyser);
        Object parse = parser.parse().value;
        Program program = (Program)parse;
        STPExecutor executor = new STPExecutor(program);
        ObjectCode execute = executor.execute();
//        System.out.println(execute);
        CodeGenerator generator = new LLVMCodeGenerator("a.ll","a.out",execute);
        generator.generate();
//        LLVMInstruction instruction = new LLVMInstruction()
        /*while (true){
            Symbol symbol = analyser.next_token();
            if (symbol.sym == parsers.Sym.EOF){
                break;
            }
            else {
                System.out.println(symbol.sym);
            }
        }*/

    }
}
