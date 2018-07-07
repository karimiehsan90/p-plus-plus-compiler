/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.jllvm.bindings;

public class TargetMachine {
  public static SWIGTYPE_p_p_char new_StringArray(int nelements) {
    long cPtr = TargetMachineJNI.new_StringArray(nelements);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_char(cPtr, false);
  }

  public static void delete_StringArray(SWIGTYPE_p_p_char ary) {
    TargetMachineJNI.delete_StringArray(SWIGTYPE_p_p_char.getCPtr(ary));
  }

  public static String StringArray_getitem(SWIGTYPE_p_p_char ary, int index) {
    return TargetMachineJNI.StringArray_getitem(SWIGTYPE_p_p_char.getCPtr(ary), index);
  }

  public static void StringArray_setitem(SWIGTYPE_p_p_char ary, int index, String value) {
    TargetMachineJNI.StringArray_setitem(SWIGTYPE_p_p_char.getCPtr(ary), index, value);
  }

  public static SWIGTYPE_p_LLVMTarget LLVMGetFirstTarget() {
    long cPtr = TargetMachineJNI.LLVMGetFirstTarget();
    return (cPtr == 0) ? null : new SWIGTYPE_p_LLVMTarget(cPtr, false);
  }

  public static SWIGTYPE_p_LLVMTarget LLVMGetNextTarget(SWIGTYPE_p_LLVMTarget T) {
    long cPtr = TargetMachineJNI.LLVMGetNextTarget(SWIGTYPE_p_LLVMTarget.getCPtr(T));
    return (cPtr == 0) ? null : new SWIGTYPE_p_LLVMTarget(cPtr, false);
  }

  public static String LLVMGetTargetName(SWIGTYPE_p_LLVMTarget T) {
    return TargetMachineJNI.LLVMGetTargetName(SWIGTYPE_p_LLVMTarget.getCPtr(T));
  }

  public static String LLVMGetTargetDescription(SWIGTYPE_p_LLVMTarget T) {
    return TargetMachineJNI.LLVMGetTargetDescription(SWIGTYPE_p_LLVMTarget.getCPtr(T));
  }

  public static int LLVMTargetHasJIT(SWIGTYPE_p_LLVMTarget T) {
    return TargetMachineJNI.LLVMTargetHasJIT(SWIGTYPE_p_LLVMTarget.getCPtr(T));
  }

  public static int LLVMTargetHasTargetMachine(SWIGTYPE_p_LLVMTarget T) {
    return TargetMachineJNI.LLVMTargetHasTargetMachine(SWIGTYPE_p_LLVMTarget.getCPtr(T));
  }

  public static int LLVMTargetHasAsmBackend(SWIGTYPE_p_LLVMTarget T) {
    return TargetMachineJNI.LLVMTargetHasAsmBackend(SWIGTYPE_p_LLVMTarget.getCPtr(T));
  }

  public static SWIGTYPE_p_LLVMTargetMachine LLVMCreateTargetMachine(SWIGTYPE_p_LLVMTarget T, String Triple, String CPU, String Features, LLVMCodeGenOptLevel Level, LLVMRelocMode Reloc, LLVMCodeModel CodeModel) {
    long cPtr = TargetMachineJNI.LLVMCreateTargetMachine(SWIGTYPE_p_LLVMTarget.getCPtr(T), Triple, CPU, Features, Level.swigValue(), Reloc.swigValue(), CodeModel.swigValue());
    return (cPtr == 0) ? null : new SWIGTYPE_p_LLVMTargetMachine(cPtr, false);
  }

  public static void LLVMDisposeTargetMachine(SWIGTYPE_p_LLVMTargetMachine T) {
    TargetMachineJNI.LLVMDisposeTargetMachine(SWIGTYPE_p_LLVMTargetMachine.getCPtr(T));
  }

  public static SWIGTYPE_p_LLVMTarget LLVMGetTargetMachineTarget(SWIGTYPE_p_LLVMTargetMachine T) {
    long cPtr = TargetMachineJNI.LLVMGetTargetMachineTarget(SWIGTYPE_p_LLVMTargetMachine.getCPtr(T));
    return (cPtr == 0) ? null : new SWIGTYPE_p_LLVMTarget(cPtr, false);
  }

  public static String LLVMGetTargetMachineTriple(SWIGTYPE_p_LLVMTargetMachine T) {
    return TargetMachineJNI.LLVMGetTargetMachineTriple(SWIGTYPE_p_LLVMTargetMachine.getCPtr(T));
  }

  public static String LLVMGetTargetMachineCPU(SWIGTYPE_p_LLVMTargetMachine T) {
    return TargetMachineJNI.LLVMGetTargetMachineCPU(SWIGTYPE_p_LLVMTargetMachine.getCPtr(T));
  }

  public static String LLVMGetTargetMachineFeatureString(SWIGTYPE_p_LLVMTargetMachine T) {
    return TargetMachineJNI.LLVMGetTargetMachineFeatureString(SWIGTYPE_p_LLVMTargetMachine.getCPtr(T));
  }

  public static SWIGTYPE_p_LLVMOpaqueTargetData LLVMGetTargetMachineData(SWIGTYPE_p_LLVMTargetMachine T) {
    long cPtr = TargetMachineJNI.LLVMGetTargetMachineData(SWIGTYPE_p_LLVMTargetMachine.getCPtr(T));
    return (cPtr == 0) ? null : new SWIGTYPE_p_LLVMOpaqueTargetData(cPtr, false);
  }

  public static int LLVMTargetMachineEmitToFile(SWIGTYPE_p_LLVMTargetMachine T, SWIGTYPE_p_LLVMOpaqueModule M, String Filename, LLVMCodeGenFileType codegen, SWIGTYPE_p_p_char ErrorMessage) {
    return TargetMachineJNI.LLVMTargetMachineEmitToFile(SWIGTYPE_p_LLVMTargetMachine.getCPtr(T), SWIGTYPE_p_LLVMOpaqueModule.getCPtr(M), Filename, codegen.swigValue(), SWIGTYPE_p_p_char.getCPtr(ErrorMessage));
  }

}
