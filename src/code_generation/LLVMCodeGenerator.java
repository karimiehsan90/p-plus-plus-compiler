package code_generation;

import stp.Desc;
import stp.FuncDesc;
import stp.StructDesc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public class LLVMCodeGenerator implements CodeGenerator {
    private String llvmFile;
    private String machineFile;
    private ObjectCode objectCode;

    public LLVMCodeGenerator(String llvmFile, String machineFile, ObjectCode objectCode) {
        this.llvmFile = llvmFile;
        this.machineFile = machineFile;
        this.objectCode = objectCode;
    }

    @Override
    public void generate() throws IOException {
        generate(llvmFile, machineFile);
    }

    private void generate(String llvmFile,String machineFile) throws IOException {
        PrintStream ps = new PrintStream(llvmFile);
        Map<Desc, List<Instruction>> code = objectCode.getCode();
        for (Desc d:code.keySet()) {
            if (d != null) {
                if (d.getName().equals("start")){
                    if (d.getType().equals(Desc.FUNCTION)){
                        ps.println("define i32 @main(){");
                        List<Instruction> instructions = code.get(d);
                        for (Instruction ins : instructions) {
                            ins.createCode(ps);
                        }
                        ps.println("ret i32 0");
                        ps.println("}");
                    }
                }
                else if (d.getName().equals("main")){

                }
                else {
                    if (d.getType().equals(Desc.FUNCTION) && ((FuncDesc)d).isComplete()) {
                        FuncDesc desc = (FuncDesc)d;
                        ps.print("define " + getType(desc.getReturnType().getName()).name + " @" + ((FuncDesc) d).getLLVMName() + "(");
                        boolean isFirst = false;
                        for (int i = 0; i < desc.getArgumentsDesc().size(); i++) {
                            Desc d1 = desc.getArgumentsDesc().get(i);
                            String name = desc.getArgumentNames().get(i);
                            if (isFirst){
                                ps.print(",");
                            }
                            ps.print(getType(d1.getName()).name + " %" + name);
                            isFirst = true;
                        }
                        ps.println("){");
                        List<Instruction> instructions = code.get(d);
                        for (Instruction ins : instructions) {
                            ins.createCode(ps);
                        }
                        ps.println("}");
                    }
                    else if (d.getType().equals(Desc.FUNCTION)){
                        FuncDesc desc = (FuncDesc)d;
                        ps.print("declare " + getType(desc.getReturnType().getName()).name + " @" + ((FuncDesc) d).getLLVMName() + "(");
                        boolean isFirst = false;
                        for (StructDesc d1:desc.getArgumentsDesc()) {
                            if (isFirst){
                                ps.print(",");
                            }
                            ps.print(getType(d1.getName()).name);
                            isFirst = true;
                        }
                        ps.println(")");
                    }
                }
            }
        }
        ps.flush();
        Runtime.getRuntime().exec("clang " + llvmFile + " -o " + machineFile);
    }
    private LLVM_Type getType(String type){
        return LLVM_Type.i32;
    }
}
