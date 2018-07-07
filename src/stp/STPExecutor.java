package stp;

import ast.*;
import code_generation.*;
import code_generation.Number;
import stp.exception.*;
import sun.security.krb5.internal.crypto.Des;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//not completed
public class STPExecutor {
    private Program program;
    private LinkedList<STP> scopes = new LinkedList<>();
    private STP global;
    private ObjectCode objectCode = new ObjectCode();
    private List<Instruction> instructionList;
    private Stack<Label> continueLabels = new Stack<>();
    private Stack<Label> breakLabels = new Stack<>();
    public STPExecutor(Program program) {
        this.program = program;
    }

    public ObjectCode execute() throws STPException {
        execute(program);
        return objectCode;
    }
    private void execute(Program program) throws STPException {
        init();
        for (ProgramInner pi:program.programInners) {
            Register.reset();
            instructionList = new LinkedList<>();
            Desc desc = null;
            if (pi instanceof FunctionDec){
                desc = execute((FunctionDec)pi);
            }
            else if (pi instanceof ExternDec){
                desc = execute((ExternDec)pi);
            }
            else if (pi instanceof VarDcl){
                desc = execute((VarDcl)pi);
            }
            else if (pi instanceof StructDec){
                desc = execute((StructDec)pi);
            }
            objectCode.add(desc,instructionList);
        }
    }
    //not completed
    private void init(){
        pushSTP();
        global = scopes.get(0);
        StructDesc intDesc = new StructDesc("int",4);
        global.add("int",intDesc);
        StructDesc charDesc = new StructDesc("char",1);
        global.add("char",charDesc);
        StructDesc longDesc = new StructDesc("long",8);
        global.add("long",longDesc);
        StructDesc floatDesc = new StructDesc("float",8);
        global.add("float",floatDesc);
    }
    private void pushSTP(){
        scopes.addFirst(new BST_STP());
    }
    private STP popSTP(){
        return scopes.removeFirst();
    }
    private void pushDesc(Desc desc){
        scopes.get(0).add(desc.getName(),desc);
    }
    private STP getScope(){
        return scopes.get(0);
    }
    private Desc execute(VarDcl varDcl) throws STPException {
        Terminal type = (Terminal) varDcl.type;
        String typeName = (String) type.symbol.value;
        StructDesc desc = getStructDesc(typeName);
        if (desc == null){
            throw new TypeNotDeclaredException("the type : " + typeName + " not declared");
        }
        for (VarDclCnt varDclCnt:varDcl.varDclCnts) {
            IDVariable variable = (IDVariable) varDclCnt.variable;
            String varName = (String) variable.id.symbol.value;
            if (isDeclaredVariable(varName)){
                throw new VariableDeclaredException("variable " + varName + " is already declared!");
            }
            Desc varToAdd = new VarDesc(desc,varName,varDcl.aConst != null);
            if (varDclCnt.expr != null) {
                Desc exprDesc = execute(varDclCnt.expr);
                if (!checkType(varToAdd,exprDesc)){
                    throw new CalculateException("two types does not matched");
                }
                pushDesc(varToAdd);
            }
            else {
                pushDesc(varToAdd);
            }
        }
        return null;
    }
    private StructDesc getStructDesc(String name){
        List<Desc> lookup = global.lookup(name);
        for (Desc desc:lookup) {
            if (desc.getType().equals(Desc.STRUCT)){
                return (StructDesc) desc;
            }
        }
        return null;
    }
    private Desc execute(FunctionDec functionDec) throws STPException {
        String funcName = (String) functionDec.id.symbol.value;
        boolean isComplete = functionDec.block != null;
        TerminalType returnType = (TerminalType) functionDec.type;
        String returnTypeStr = (String) returnType.symbol.value;
        StructDesc returnDesc = getStructDesc(returnTypeStr);
        if (returnDesc == null){
            throw new TypeNotDeclaredException("type : " + returnTypeStr + " not declared");
        }
        Arguments arguments = functionDec.arguments;
        pushSTP();
        List<StructDesc> args = new LinkedList<>();
        List<String> argNames = new LinkedList<>();
        for (Argument argument:arguments) {
            TerminalType type = (TerminalType) argument.type;
            StructDesc typeDesc = getStructDesc((String) type.symbol.value);
            String varName = (String) argument.id.symbol.value;
            if (!canBeArgument(varName)){
                throw new VariableDeclaredException("the variable " + varName + " is Already declared");
            }
            VarDesc varDesc = new VarDesc(typeDesc,varName,false);
            pushDesc(varDesc);
            args.add(typeDesc);
            argNames.add(varName);
        }
        int c = canDeclareFunction(funcName,args,isComplete);
        if (c == -1){
            throw new MethodDeclaredException("this method cannot be declared : " + funcName);
        }
        FuncDesc funcDesc = new FuncDesc(funcName,args,argNames,returnDesc,isComplete,c);
        global.add(funcName,funcDesc);
        if (isComplete){
            execute(functionDec.block);
        }
        popSTP();
        objectCode.add(funcDesc,instructionList);
        return funcDesc;
    }
    private int canDeclareFunction(String name,List<StructDesc> args,boolean isComplete){
        List<Desc> lookup = global.lookup(name);
        for (Desc d:lookup) {
            if (d.getType().equals(Desc.FUNCTION)){
                FuncDesc funcDesc = (FuncDesc)d;
                if (funcDesc.getName().equals(name) && funcDesc.getArgumentsDesc().equals(args) && funcDesc.isComplete() == isComplete){
                    return -1;
                }
            }
            else {
                return -1;
            }
        }
        return lookup.size();
    }
    //not completed
    private Desc execute(ExternDec externDec){
        return null;
    }
    private Desc execute(StructDec structDec) throws STPException {
        String structName = (String) structDec.id.symbol.value;
        if (!canDeclareStruct(structName)){
            throw new StructDeclaredException("struct cannot declare : " + structName);
        }
        pushSTP();
        for (VarDcl varDcl:structDec.varDcls) {
            execute(varDcl);
        }
        STP stp = popSTP();
        StructDesc structDesc = new StructDesc(structName,stp);
        pushDesc(structDesc);
        return structDesc;
    }
    private boolean canDeclareStruct(String name){
        return global.lookup(name).size() == 0;
    }
    //not completed
    private Desc getFather(Desc d1,Desc d2) {
        return d1;
    }
    private Desc execute(Expr expr) throws STPException{
        if (expr instanceof BinaryExpr){
            return execute((BinaryExpr)expr);
        }
        if (expr instanceof ParenthisOperation){
            return execute((ParenthisOperation)expr);
        }
        if (expr instanceof MethodCall){
            return execute((MethodCall) expr);
        }
        if (expr instanceof Variable){
            return execute((Variable) expr);
        }
        if (expr instanceof Const){
            return execute((Const)expr);
        }
        if (expr instanceof MinusExpr){
            return execute((MinusExpr) expr);
        }
        if (expr instanceof BitwiseExpr){
            return execute((BitwiseExpr) expr);
        }
        return execute((SizeofExpr)expr);

    }
    private Desc execute(BinaryExpr expr) throws STPException{
        Expr e1 = expr.expr1;
        Desc d1 = execute(e1);
        LLVM_Var out1 = null;
        if (instructionList.get(instructionList.size() - 1) instanceof BasicInstruction) {
            BasicInstruction i1 = (BasicInstruction) instructionList.get(instructionList.size() - 1);
            out1 = i1.out;
        }
        else if (instructionList.get(instructionList.size() - 1) instanceof MethodCallInstruction){
            MethodCallInstruction i1 = (MethodCallInstruction) instructionList.get(instructionList.size() - 1);
            out1 = i1.out;
        }
        Expr e2 = expr.expr2;
        Desc d2 = execute(e2);
        LLVM_Var out2 = null;
        if (instructionList.get(instructionList.size() - 1) instanceof BasicInstruction) {
            BasicInstruction i2 = (BasicInstruction) instructionList.get(instructionList.size() - 1);
            out2 = i2.out;
        }
        else if (instructionList.get(instructionList.size() - 1) instanceof MethodCallInstruction){
            MethodCallInstruction i2 = (MethodCallInstruction)instructionList.get(instructionList.size() - 1);
            out2 = i2.out;
        }
        Desc varDesc1 = null;
        if (d1 instanceof StructDesc){
            varDesc1 = (StructDesc)d1;
        }
        if (d1 instanceof VarDesc){
            varDesc1 = (VarDesc)d1;
        }
        if (d1 instanceof FuncDesc){
            varDesc1 = (FuncDesc)d1;
        }
        Desc varDesc2 = null;
        if (d2 instanceof StructDesc){
            varDesc2 = (StructDesc)d2;
        }
        if (d2 instanceof VarDesc){
            varDesc2 = (VarDesc)d2;
        }
        if (d2 instanceof FuncDesc){
            varDesc2 = (FuncDesc)d2;
        }
        Desc father1 = getFather(varDesc1, varDesc2);
        LLVM_Type type1 = getType(father1.getName());
        Register out = new Register(type1);
        Opcode op = expr.op.getOpcode();
        Desc father = getFather(d1, d2);
        String name = "";
        if (father instanceof StructDesc){
            name = father.getName();
        }
        else if (father instanceof VarDesc){
            name = ((VarDesc)father).getVarType().getName();
        }
        else if (father instanceof FuncDesc){
            name = ((FuncDesc)father).getReturnType().getName();
        }
        LLVM_Type type = getType(name);
        Instruction i = new BasicInstruction(op,out1,out2,out,type,null);
        instructionList.add(i);
        if (checkType(d1,d2)){
            return getFather(d1,d2);
        }
        throw new CalculateException("types does not matched : " + d1.getName() + "," + d2.getName());
    }
    private Desc execute(ParenthisOperation expr) throws STPException {
        return execute(expr.expr);
    }
    //not completed
    private Desc execute(MethodCall expr) throws STPException {
        List<LLVM_Var> outs = new LinkedList<>();
        for (Expr expr1:expr.parameters) {
            execute(expr1);
            Instruction ir = instructionList.get(instructionList.size() - 1);
            if (ir instanceof BasicInstruction) {
                outs.add(((BasicInstruction)ir).out);
            }
        }
        String name = (String) expr.id.symbol.value;
        List<Desc> lookup = global.lookup(name);
        outer:for (Desc desc:lookup) {
            if (desc instanceof VarDesc || desc instanceof StructDesc){
                throw new MethodNotFoundException("the method not found : " + name);
            }
            else if (desc instanceof FuncDesc){
                FuncDesc funcDesc = (FuncDesc)desc;
                if (funcDesc.getArgumentsDesc().size() == outs.size() && funcDesc.isComplete()){
                    List<StructDesc> structDescs = funcDesc.getArgumentsDesc();
                    for (int i = 0; i < structDescs.size(); i++) {
                        if (!checkType(structDescs.get(i),getType(outs.get(i).type))){
                            continue outer;
                        }
                    }
                    LLVM_Type type = getType(funcDesc.getReturnType().getName());
                    Register register = new Register(type);
                    MethodCallInstruction i = new MethodCallInstruction(type,outs,funcDesc.getLLVMName(),register);
                    instructionList.add(i);
                    return funcDesc;
                }
            }
        }
        throw new MethodNotFoundException("the method does not exists : " + name);
    }
    private Desc execute(Variable expr) throws STPException {
        if (expr instanceof IDVariable){
            return execute((IDVariable)expr);
        }
        if (expr instanceof ObjectVariable){
            return execute((ObjectVariable)expr);
        }
        if (expr instanceof PreIncreamentVariable){
            return execute((PreIncreamentVariable)expr);
        }
        if (expr instanceof PostIncreamentVariable){
            return execute((PostIncreamentVariable) expr);
        }
        if (expr instanceof PreDecreamentVariable){
            return execute((PreDecreamentVariable) expr);
        }
        if (expr instanceof PostDecreamentVariable){
            return execute((PostDecreamentVariable) expr);
        }
        return null;
    }
    private Desc execute(PreIncreamentVariable var) throws STPException {
        Desc d = execute(var.variable);
        boolean isGlobal = false;
        if (global.lookup(d.getName()).contains(d)){
            isGlobal = true;
        }
        BasicInstruction bi = (BasicInstruction) instructionList.get(instructionList.size() - 1);
        LLVM_Type type = getType(((VarDesc)d).getVarType().getName());
        BasicInstruction inc = new BasicInstruction(Opcode.ADD,bi.var1,new Number("1"),bi.var1,type,null);
        instructionList.add(inc);
        return d;

    }
    private Desc execute(PreDecreamentVariable var) throws STPException {
        Desc d = execute(var.variable);
        BasicInstruction bi = (BasicInstruction) instructionList.get(instructionList.size() - 1);
        LLVM_Type type = getType(((VarDesc)d).getVarType().getName());
        BasicInstruction inc = new BasicInstruction(Opcode.SUB,bi.var1,new Number("1"),bi.var1,type,null);
        instructionList.add(inc);
        return d;
    }
    private Desc execute(PostIncreamentVariable var) throws STPException {
        Desc d = execute(var.variable);
        BasicInstruction bi = (BasicInstruction) instructionList.get(instructionList.size() - 1);
        LLVM_Type type = getType(((VarDesc)d).getVarType().getName());
        BasicInstruction inc = new BasicInstruction(Opcode.ADD,bi.var1,new Number("1"),bi.var1,type,null);
        instructionList.add(inc);
        return d;
    }
    private Desc execute(PostDecreamentVariable var) throws STPException {
        Desc d = execute(var.variable);
        BasicInstruction bi = (BasicInstruction) instructionList.get(instructionList.size() - 1);
        LLVM_Type type = getType(((VarDesc)d).getVarType().getName());
        BasicInstruction inc = new BasicInstruction(Opcode.SUB,bi.var1,new Number("1"),bi.var1,type,null);
        instructionList.add(inc);
        return d;
    }
    private Desc execute(IDVariable var) throws STPException{
        String varName = (String) var.id.symbol.value;
        Desc desc = isDeclaredVariableInAll(varName);
        if (desc == null){
            throw new VariableNotDeclaredException("the variable is not declared : " + varName);
        }
        if (desc instanceof VarDesc){
            VarDesc varDesc = (VarDesc)desc;
            boolean isGlobal = false;
            if (global.lookup(varName).contains(varDesc)){
                isGlobal = true;
            }
            LLVM_Type llvm_type = getType(varDesc.getVarType().getName());
            Register reg =  new Register(llvm_type);
            LLVM_Var var1 = new LLVM_Var(varName,llvm_type,isGlobal);
            String typeName = ((VarDesc)desc).getVarType().getName();
            LLVM_Type type = getType(typeName);
            Instruction instruction = new BasicInstruction(Opcode.ASSIGN,var1,null,reg,type,null);
            instructionList.add(instruction);
            return desc;
        }
        throw new VariableNotDeclaredException("the object you want is not variable : " + varName);
    }
    private Desc isDeclaredVariableInAll(String var){
        for (STP stp:scopes) {
            List<Desc> descs = stp.lookup(var);
            if (descs.size() > 0){
                return descs.get(0);
            }
        }
        return null;
    }
    private Desc execute(ObjectVariable var) throws STPException {
        Desc desc = execute(var.variable);
        if (desc instanceof VarDesc){
            VarDesc varDesc = (VarDesc)desc;
            StructDesc varType = varDesc.getVarType();
            String typeName = varType.getName();
            String idName = (String) var.id.symbol.value;
            List<Desc> lookup = varType.getFields().lookup(idName);
            if (lookup.size() > 0){
                return lookup.get(0);
            }
            throw new TypeNotHaveVariable("the type : " + typeName + " has not this var : " + idName);
        }
        throw new VariableNotDeclaredException("this is not variable : " + desc.getName());
    }
    private Desc execute(MinusExpr expr) throws STPException {
        Desc d = execute(expr.expr);
        BasicInstruction instruction = (BasicInstruction) instructionList.get(instructionList.size() - 1);
        String d1 = "";
        if (d instanceof VarDesc){
            d1 = ((VarDesc)d).getVarType().getName();
        }
        else if (d instanceof StructDesc){
            d1 = ((StructDesc)d).getName();
        }
        else if (d instanceof FuncDesc){
            d1 = ((FuncDesc)d).getReturnType().getName();
        }
        LLVM_Type type = getType(d1);
        Register reg = new Register(type);
        LLVM_Var var = new Number("0");
        BasicInstruction ins = new BasicInstruction(Opcode.SUB,var,instruction.out,reg,type,null);
        instructionList.add(ins);
        return d;
    }
    private Desc execute(BitwiseExpr expr) throws STPException {
        Desc d = execute(expr.expr);
        BasicInstruction bi = (BasicInstruction) instructionList.get(instructionList.size() - 1);
        LLVM_Type type = getType(((VarDesc)d).getVarType().getName());
        Register reg = new Register(type);
        BasicInstruction ins = new BasicInstruction(Opcode.BITWISE,bi.out,null,reg,type,null);
        instructionList.add(ins);
        return d;
    }
    private Desc execute(SizeofExpr expr) throws STPException {
        TerminalType type = (TerminalType) expr.type;
        String typeName = (String) type.symbol.value;
        List<Desc> lookup = global.lookup(typeName);
        if (lookup.size() == 0){
            throw new TypeNotDeclaredException("the type does not exists : " + typeName);
        }
        Desc desc = lookup.get(0);
        if (desc instanceof StructDesc){
            StructDesc structDesc = (StructDesc)desc;
            int size = structDesc.getSize();
            LLVM_Var var = new Number(String.valueOf(size));
            Register reg = new Register(LLVM_Type.i32);
            Instruction ins = new BasicInstruction(Opcode.ASSIGN,var,null,reg,LLVM_Type.i32,null);
            instructionList.add(ins);
            return global.lookup("int").get(0);
        }
        throw new TypeNotDeclaredException("the type does not exists : " + typeName);
    }
    private Desc execute(Const expr){
        if (expr instanceof IntConst){
            IntConst ic = (IntConst)expr;
            LLVM_Var var = new Number((String) ic.symbol.value);
            Register reg = new Register(LLVM_Type.i32);
            Instruction i = new BasicInstruction(Opcode.ASSIGN,var,null,reg,LLVM_Type.i32,null);
            instructionList.add(i);
            return global.lookup("int").get(0);
        }
        if (expr instanceof RealConst){
            RealConst ic = (RealConst)expr;
            LLVM_Var var = new Number((String) ic.symbol.value);
            Register reg = new Register(LLVM_Type.floatType);
            Instruction i = new BasicInstruction(Opcode.ASSIGN,var,null,reg,new LLVM_Type("float"),null);
            instructionList.add(i);
            return global.lookup("float").get(0);
        }
        if (expr instanceof CharConst){
            CharConst ic = (CharConst) expr;
            LLVM_Var var = new Number((String) ic.symbol.value);
            Register reg = new Register(LLVM_Type.i8);
            Instruction i = new BasicInstruction(Opcode.ASSIGN,var,null,reg,LLVM_Type.i8,null);
            instructionList.add(i);
            return global.lookup("char").get(0);
        }
        if (expr instanceof BoolConst){
            BoolConst ic = (BoolConst)expr;
            LLVM_Var var = new Number((String) ic.symbol.value);
            Register reg = new Register(LLVM_Type.i1);
            Instruction i = new BasicInstruction(Opcode.ASSIGN,var,null,reg,new LLVM_Type("i1"),null);
            instructionList.add(i);
            return global.lookup("bool").get(0);
        }
        if (expr instanceof StringConst){
            StringConst ic = (StringConst) expr;
            String c = (String) ic.symbol.value;
            LLVM_Var var = new Number(c);
            LLVM_Type type = new LLVM_Type("i8",c.length() - 1);
            Register reg = new Register(type);
            Instruction i = new BasicInstruction(Opcode.ASSIGN,var,null,reg,LLVM_Type.i32,null);
            instructionList.add(i);
            return global.lookup("string").get(0);
        }
        if (expr instanceof LongConst){
            LongConst ic = (LongConst)expr;
            LLVM_Var var = new Number((String) ic.symbol.value);
            Register reg = new Register(LLVM_Type.i64);
            Instruction i = new BasicInstruction(Opcode.ASSIGN,var,null,reg,LLVM_Type.i64,null);
            instructionList.add(i);
            return global.lookup("long").get(0);
        }
        return null;
    }
    //not completed
    private boolean checkType(Desc d1,Desc d2){
        return true;
    }
    private boolean isDeclaredVariable(String str) {
        STP stp = getScope();
        List<Desc> lookup = stp.lookup(str);
        if (lookup.size() > 0) {
            return true;
        }
        return false;
    }
    private boolean canBeArgument(String str){
        return scopes.get(0).lookup(str).size() == 0;
    }
    private Desc execute(Block block) throws STPException {
        BlockInnerList blockInners = block.blockInners;
        for (BlockInner blockInner:blockInners) {
            if (blockInner instanceof VarDcl){
                execute((VarDcl) blockInner);
            }
            else {
                execute((Statement) blockInner);
            }
        }
        return null;
    }
    private Desc execute(Statement statement) throws STPException {
        if (statement instanceof AssignmentStatement){
            return execute((AssignmentStatement) statement);
        }
        if (statement instanceof Assignment){
            return execute((Assignment)statement);
        }
        if (statement instanceof MethodCallStatement){
            return execute((MethodCallStatement)statement);
        }
        if (statement instanceof LoopStatement){
            return execute((LoopStatement)statement);
        }
        if (statement instanceof CondStatement){
            return execute((CondStatement)statement);
        }
        if (statement instanceof BreakStatement){
            return execute((BreakStatement)statement);
        }
        if (statement instanceof ContinueStatement){
            return execute((ContinueStatement)statement);
        }
        if (statement instanceof ReturnStatement){
            return execute((ReturnStatement)statement);
        }
        if (statement instanceof Expr){
            return execute((Expr)statement);
        }
        return null;
    }
    private Desc execute(Assignment statement) throws STPException {
        LLVM_Var out2 = null,out1=null,in1 = null;
        Desc d2 = execute(statement.expr);
        Instruction ir = instructionList.get(instructionList.size() - 1);
        if (ir instanceof BasicInstruction) {
            BasicInstruction i2 = (BasicInstruction) ir;
            out2 = i2.out;
        }
        else if (ir instanceof MethodCallInstruction){
            MethodCallInstruction i2 = (MethodCallInstruction) ir;
            out2 = i2.out;
        }
        Desc d1 = execute(statement.variable);
        ir = instructionList.get(instructionList.size() - 1);
        Desc father = getFather(d1, d2);
        LLVM_Type type = getType(father.getType());
        if (ir instanceof BasicInstruction) {
            BasicInstruction i1 = (BasicInstruction) ir;
            out1 = i1.out;
            in1 = i1.var1;
        }
        if (statement.assignOpr instanceof Assign){
            Instruction i = new BasicInstruction(Opcode.ASSIGN,out2,null,in1,type,null);
            instructionList.add(i);
        }
        else if (statement.assignOpr instanceof AddAssign){
            Instruction i = new BasicInstruction(Opcode.ADD,out1,out2,in1,type,null);
            instructionList.add(i);
        }
        else if (statement.assignOpr instanceof SubAssign){
            Instruction i = new BasicInstruction(Opcode.SUB,out1,out2,in1,type,null);
            instructionList.add(i);
        }
        else if (statement.assignOpr instanceof ProdAssign){
            Instruction i = new BasicInstruction(Opcode.MUL,out1,out2,in1,type,null);
            instructionList.add(i);
        }
        else {
            Instruction i = new BasicInstruction(Opcode.DIV,out1,out2,in1,type,null);
            instructionList.add(i);
        }
        if (checkType(d1,d2)){
            return getFather(d1,d2);
        }
        throw new CalculateException("types does not matched : " + d1.getName() + " " + d2.getName());
    }
    private Desc execute(AssignmentStatement assignment) throws STPException {
        return execute(assignment.assignment);
    }
    private Desc execute(MethodCallStatement statement) throws STPException {
        return execute(statement.methodCall);
    }
    private Desc execute(LoopStatement statement) throws STPException {
        pushSTP();
        if (statement instanceof ForStatement){
            return execute((ForStatement)statement);
        }
        if (statement instanceof ForeachStatement){
            return execute((ForeachStatement)statement);
        }
        if (statement instanceof RepeatStatement){
            return execute((RepeatStatement)statement);
        }
        popSTP();
        return null;
    }
    private Desc execute(ForStatement statement) throws STPException {
        Label firstLoop = new Label();
        Label outLoop = new Label();
        Label continueLoop = new Label();
        Label firstBlock = new Label();
        continueLabels.push(continueLoop);
        breakLabels.push(outLoop);
        if (statement.assignment != null) {
            execute(statement.assignment);
        }
        JumpInstruction ji = new JumpInstruction(firstLoop);
        instructionList.add(ji);
        Instruction firstLoopInstruction = new BlankInstruction(firstLoop);
        instructionList.add(firstLoopInstruction);
        if (statement.expr != null){
            execute(statement.expr);
            BasicInstruction i = (BasicInstruction) instructionList.get(instructionList.size() - 1);
            ConditionalJumpInstruction cji = new ConditionalJumpInstruction(i.out,firstBlock,outLoop);
            instructionList.add(cji);
        }
        BlankInstruction bi = new BlankInstruction(firstBlock);
        instructionList.add(bi);
        execute(statement.block);
        JumpInstruction ins = new JumpInstruction(continueLoop);
        instructionList.add(ins);
        Instruction continueLoopInstruction = new BlankInstruction(continueLoop);
        instructionList.add(continueLoopInstruction);
        if (statement.updateStatement != null) {
            execute(statement.updateStatement);
        }
        Instruction endLoopJump = new JumpInstruction(firstLoop);
        instructionList.add(endLoopJump);
        Instruction i = new BlankInstruction(outLoop);
        instructionList.add(i);
        breakLabels.pop();
        continueLabels.pop();
        return null;
    }
    private Desc execute(ForeachStatement statement) throws STPException {
        String firstVar = (String) statement.id.symbol.value;
        String secondVar = (String) statement.id1.symbol.value;
        boolean declaredFirst = isDeclaredVariable(firstVar);
        boolean isList = isList(secondVar);
        if (declaredFirst && isList){
            execute(statement.block);
        }
        if (!declaredFirst){
            throw new VariableNotDeclaredException("variable is not declared : " + firstVar);
        }
        if (!isList){
            throw new VariableNotDeclaredException("variable is not iterable : " + secondVar);
        }
        return null;
    }
    //not completed
    private boolean isList(String str){
        return isDeclaredVariable(str);
    }
    private Desc execute(RepeatStatement statement) throws STPException {
        Label firstLoop = new Label();
        Label continueLoop = new Label();
        Label outLoop = new Label();
        continueLabels.push(continueLoop);
        breakLabels.push(outLoop);
        JumpInstruction jtoFirst = new JumpInstruction(firstLoop);
        instructionList.add(jtoFirst);
        Instruction firstLoopIns = new BlankInstruction(firstLoop);
        instructionList.add(firstLoopIns);
        execute(statement.block);
        JumpInstruction ji = new JumpInstruction(continueLoop);
        instructionList.add(ji);
        Instruction continueLoopIns = new BlankInstruction(continueLoop);
        instructionList.add(continueLoopIns);
        execute(statement.expr);
        BasicInstruction bi = (BasicInstruction) instructionList.get(instructionList.size() - 1);
        Label next = new Label();
        Instruction cond = new ConditionalJumpInstruction(bi.out,next,outLoop);
        instructionList.add(cond);
        BlankInstruction bins = new BlankInstruction(next);
        instructionList.add(bins);
        Instruction gotoFirstLoop = new JumpInstruction(firstLoop);
        instructionList.add(gotoFirstLoop);
        Instruction outIns = new BlankInstruction(outLoop);
        instructionList.add(outIns);
        continueLabels.pop();
        breakLabels.pop();
        return null;
    }
    private Desc execute(CondStatement statement) throws STPException {
        if (statement instanceof IfStatement){
            return execute((IfStatement)statement);
        }
        return execute((SwitchStatement)statement);
    }
    private Desc execute(IfStatement statement) throws STPException {
        pushSTP();
        Label elseLabel = new Label();
        Label outLabel = new Label();
        Label nextIf = new Label();
        execute(statement.expr);
        BasicInstruction bi = (BasicInstruction) instructionList.get(instructionList.size() - 1);
        ConditionalJumpInstruction cji = new ConditionalJumpInstruction(bi.out,nextIf,elseLabel);
        instructionList.add(cji);
        BlankInstruction bins = new BlankInstruction(nextIf);
        instructionList.add(bins);
        execute(statement.block);
        JumpInstruction ji = new JumpInstruction(outLabel);
        instructionList.add(ji);
        popSTP();
        pushSTP();
        BlankInstruction beforeElse = new BlankInstruction(elseLabel);
        instructionList.add(beforeElse);
        if (statement.elseStatement != null) {
            execute(statement.elseStatement.block);
        }
        JumpInstruction ji1 = new JumpInstruction(outLabel);
        instructionList.add(ji1);
        BlankInstruction afterStatement = new BlankInstruction(outLabel);
        instructionList.add(afterStatement);
        popSTP();
        return null;
    }
    private boolean isGlobal(String name,Desc desc){
        List<Desc> lookup = global.lookup(name);
        if (lookup.contains(desc)){
            return true;
        }
        return false;
    }
    private Desc execute(SwitchStatement statement) throws STPException {
        pushSTP();
        String varName = (String) statement.id.symbol.value;
        Desc inAll = isDeclaredVariableInAll(varName);
        LLVM_Var baseVar = new LLVM_Var(varName,LLVM_Type.i32,isGlobal(varName,inAll));
        if (!isInt(varName)){
            throw new CannotBeInSwitch("the variable cannot be in switch! just int variables can be : " + varName);
        }
        List<Integer> list = new LinkedList<>();
        statement.caseList.sort(null);
        Label out = new Label();
        for (CaseStatement caseStatement:statement.caseList) {
            Register reg = new Register(LLVM_Type.i32);
            Label next = new Label();
            LLVM_Var var = new Number((String)caseStatement.ic.symbol.value);
            BasicInstruction ins = new BasicInstruction(Opcode.EQ,baseVar,var,reg,LLVM_Type.i32,null);
            Label nextTrue = new Label();
            instructionList.add(ins);
            ConditionalJumpInstruction cji = new ConditionalJumpInstruction(reg,nextTrue,next);
            instructionList.add(cji);
            BlankInstruction bins = new BlankInstruction(nextTrue);
            instructionList.add(bins);
            execute(caseStatement.block);
            JumpInstruction gotoOut = new JumpInstruction(out);
            instructionList.add(gotoOut);
            BlankInstruction nextIns = new BlankInstruction(next);
            instructionList.add(nextIns);
            int a = getInt((String)caseStatement.ic.symbol.value);
            if (list.contains(a)){
                throw new DuplicateICInCases("the ic is duplicated in case list : " + a);
            }
            list.add(a);
            popSTP();
            pushSTP();
        }
        execute(statement.defaultStatement.block);
        JumpInstruction ji = new JumpInstruction(out);
        instructionList.add(ji);
        BlankInstruction outIns = new BlankInstruction(out);
        instructionList.add(outIns);
        popSTP();
        return null;
    }
    private int getInt(String s){
        return Integer.valueOf(s);
    }
    private boolean isInt(String name){
        Desc desc = global.lookup("int").get(0);
        Desc desc1 = isDeclaredVariableInAll(name);
        return checkType(desc,desc1);
    }
    private Desc execute(BreakStatement statement) throws BreakOutOfLoopException {
        if (breakLabels.size() > 0) {
            JumpInstruction ji = new JumpInstruction(breakLabels.peek());
            instructionList.add(ji);
        }
        else {
            throw new BreakOutOfLoopException("the break is out of loop!!!");
        }
        return null;
    }
    private Desc execute(ContinueStatement statement) throws BreakOutOfLoopException {
        if (continueLabels.size() > 0) {
            JumpInstruction ji = new JumpInstruction(continueLabels.peek());
            instructionList.add(ji);
        }
        else {
            throw new BreakOutOfLoopException("the continue is out of loop!!!");
        }
        return null;
    }
    private Desc execute(ReturnStatement statement) throws STPException {
        Desc func = global.getLast();
        if (statement.expr != null) {
            Desc d = execute(statement.expr);
            if(checkType(d,func)){
                String name = "";
                if (d instanceof VarDesc){
                    name = ((VarDesc)d).getVarType().getName();
                }
                else if (d instanceof StructDesc){
                    name = d.getName();
                }
                else if (d instanceof FuncDesc){
                    name = ((FuncDesc)d).getReturnType().getName();
                }
                Instruction i = instructionList.get(instructionList.size() - 1);
                if (i instanceof BasicInstruction){
                    BasicInstruction bi = (BasicInstruction)i;
                    ReturnInstruction ri = new ReturnInstruction(getType(name),bi.out);
                    instructionList.add(ri);
                }
                else if (i instanceof MethodCallInstruction){
                    MethodCallInstruction mi = (MethodCallInstruction)i;
                    ReturnInstruction ri = new ReturnInstruction(getType(name),mi.out);
                    instructionList.add(ri);
                }
                return null;
            }
            else {
                throw new CalculateException("the types does not matched : " + d.getName() + " " + func.getName());
            }
        }
        Desc desc = global.lookup("void").get(0);
        if (checkType(func,desc)){
            return null;
        }
        throw new CalculateException("the types does not matched : " + desc.getName() + " " + func.getName());
    }
    private LLVM_Type getType(String type){
        return LLVM_Type.i32;
    }
    private Desc getType(LLVM_Type type){
        return global.lookup("int").get(0);
    }
}