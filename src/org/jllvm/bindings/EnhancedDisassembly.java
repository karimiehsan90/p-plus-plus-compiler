/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.jllvm.bindings;

public class EnhancedDisassembly implements EnhancedDisassemblyConstants {
  public static SWIGTYPE_p_unsigned_int new_UnsignedIntArray(int nelements) {
    long cPtr = EnhancedDisassemblyJNI.new_UnsignedIntArray(nelements);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_int(cPtr, false);
  }

  public static void delete_UnsignedIntArray(SWIGTYPE_p_unsigned_int ary) {
    EnhancedDisassemblyJNI.delete_UnsignedIntArray(SWIGTYPE_p_unsigned_int.getCPtr(ary));
  }

  public static long UnsignedIntArray_getitem(SWIGTYPE_p_unsigned_int ary, int index) {
    return EnhancedDisassemblyJNI.UnsignedIntArray_getitem(SWIGTYPE_p_unsigned_int.getCPtr(ary), index);
  }

  public static void UnsignedIntArray_setitem(SWIGTYPE_p_unsigned_int ary, int index, long value) {
    EnhancedDisassemblyJNI.UnsignedIntArray_setitem(SWIGTYPE_p_unsigned_int.getCPtr(ary), index, value);
  }

  public static SWIGTYPE_p_p_char new_StringArray(int nelements) {
    long cPtr = EnhancedDisassemblyJNI.new_StringArray(nelements);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_char(cPtr, false);
  }

  public static void delete_StringArray(SWIGTYPE_p_p_char ary) {
    EnhancedDisassemblyJNI.delete_StringArray(SWIGTYPE_p_p_char.getCPtr(ary));
  }

  public static String StringArray_getitem(SWIGTYPE_p_p_char ary, int index) {
    return EnhancedDisassemblyJNI.StringArray_getitem(SWIGTYPE_p_p_char.getCPtr(ary), index);
  }

  public static void StringArray_setitem(SWIGTYPE_p_p_char ary, int index, String value) {
    EnhancedDisassemblyJNI.StringArray_setitem(SWIGTYPE_p_p_char.getCPtr(ary), index, value);
  }

  public static int EDGetDisassembler(SWIGTYPE_p_p_void disassembler, String triple, long syntax) {
    return EnhancedDisassemblyJNI.EDGetDisassembler(SWIGTYPE_p_p_void.getCPtr(disassembler), triple, syntax);
  }

  public static int EDGetRegisterName(SWIGTYPE_p_p_char regName, SWIGTYPE_p_void disassembler, long regID) {
    return EnhancedDisassemblyJNI.EDGetRegisterName(SWIGTYPE_p_p_char.getCPtr(regName), SWIGTYPE_p_void.getCPtr(disassembler), regID);
  }

  public static int EDRegisterIsStackPointer(SWIGTYPE_p_void disassembler, long regID) {
    return EnhancedDisassemblyJNI.EDRegisterIsStackPointer(SWIGTYPE_p_void.getCPtr(disassembler), regID);
  }

  public static int EDRegisterIsProgramCounter(SWIGTYPE_p_void disassembler, long regID) {
    return EnhancedDisassemblyJNI.EDRegisterIsProgramCounter(SWIGTYPE_p_void.getCPtr(disassembler), regID);
  }

  public static long EDCreateInsts(SWIGTYPE_p_p_void insts, long count, SWIGTYPE_p_void disassembler, SWIGTYPE_p_f_p_uint8_t_uint64_t_p_void__int byteReader, SWIGTYPE_p_uint64_t address, SWIGTYPE_p_void arg) {
    return EnhancedDisassemblyJNI.EDCreateInsts(SWIGTYPE_p_p_void.getCPtr(insts), count, SWIGTYPE_p_void.getCPtr(disassembler), SWIGTYPE_p_f_p_uint8_t_uint64_t_p_void__int.getCPtr(byteReader), SWIGTYPE_p_uint64_t.getCPtr(address), SWIGTYPE_p_void.getCPtr(arg));
  }

  public static void EDReleaseInst(SWIGTYPE_p_void inst) {
    EnhancedDisassemblyJNI.EDReleaseInst(SWIGTYPE_p_void.getCPtr(inst));
  }

  public static int EDInstByteSize(SWIGTYPE_p_void inst) {
    return EnhancedDisassemblyJNI.EDInstByteSize(SWIGTYPE_p_void.getCPtr(inst));
  }

  public static int EDGetInstString(SWIGTYPE_p_p_char buf, SWIGTYPE_p_void inst) {
    return EnhancedDisassemblyJNI.EDGetInstString(SWIGTYPE_p_p_char.getCPtr(buf), SWIGTYPE_p_void.getCPtr(inst));
  }

  public static int EDInstID(SWIGTYPE_p_unsigned_int instID, SWIGTYPE_p_void inst) {
    return EnhancedDisassemblyJNI.EDInstID(SWIGTYPE_p_unsigned_int.getCPtr(instID), SWIGTYPE_p_void.getCPtr(inst));
  }

  public static int EDInstIsBranch(SWIGTYPE_p_void inst) {
    return EnhancedDisassemblyJNI.EDInstIsBranch(SWIGTYPE_p_void.getCPtr(inst));
  }

  public static int EDInstIsMove(SWIGTYPE_p_void inst) {
    return EnhancedDisassemblyJNI.EDInstIsMove(SWIGTYPE_p_void.getCPtr(inst));
  }

  public static int EDBranchTargetID(SWIGTYPE_p_void inst) {
    return EnhancedDisassemblyJNI.EDBranchTargetID(SWIGTYPE_p_void.getCPtr(inst));
  }

  public static int EDMoveSourceID(SWIGTYPE_p_void inst) {
    return EnhancedDisassemblyJNI.EDMoveSourceID(SWIGTYPE_p_void.getCPtr(inst));
  }

  public static int EDMoveTargetID(SWIGTYPE_p_void inst) {
    return EnhancedDisassemblyJNI.EDMoveTargetID(SWIGTYPE_p_void.getCPtr(inst));
  }

  public static int EDNumTokens(SWIGTYPE_p_void inst) {
    return EnhancedDisassemblyJNI.EDNumTokens(SWIGTYPE_p_void.getCPtr(inst));
  }

  public static int EDGetToken(SWIGTYPE_p_p_void token, SWIGTYPE_p_void inst, int index) {
    return EnhancedDisassemblyJNI.EDGetToken(SWIGTYPE_p_p_void.getCPtr(token), SWIGTYPE_p_void.getCPtr(inst), index);
  }

  public static int EDGetTokenString(SWIGTYPE_p_p_char buf, SWIGTYPE_p_void token) {
    return EnhancedDisassemblyJNI.EDGetTokenString(SWIGTYPE_p_p_char.getCPtr(buf), SWIGTYPE_p_void.getCPtr(token));
  }

  public static int EDOperandIndexForToken(SWIGTYPE_p_void token) {
    return EnhancedDisassemblyJNI.EDOperandIndexForToken(SWIGTYPE_p_void.getCPtr(token));
  }

  public static int EDTokenIsWhitespace(SWIGTYPE_p_void token) {
    return EnhancedDisassemblyJNI.EDTokenIsWhitespace(SWIGTYPE_p_void.getCPtr(token));
  }

  public static int EDTokenIsPunctuation(SWIGTYPE_p_void token) {
    return EnhancedDisassemblyJNI.EDTokenIsPunctuation(SWIGTYPE_p_void.getCPtr(token));
  }

  public static int EDTokenIsOpcode(SWIGTYPE_p_void token) {
    return EnhancedDisassemblyJNI.EDTokenIsOpcode(SWIGTYPE_p_void.getCPtr(token));
  }

  public static int EDTokenIsLiteral(SWIGTYPE_p_void token) {
    return EnhancedDisassemblyJNI.EDTokenIsLiteral(SWIGTYPE_p_void.getCPtr(token));
  }

  public static int EDTokenIsRegister(SWIGTYPE_p_void token) {
    return EnhancedDisassemblyJNI.EDTokenIsRegister(SWIGTYPE_p_void.getCPtr(token));
  }

  public static int EDTokenIsNegativeLiteral(SWIGTYPE_p_void token) {
    return EnhancedDisassemblyJNI.EDTokenIsNegativeLiteral(SWIGTYPE_p_void.getCPtr(token));
  }

  public static int EDLiteralTokenAbsoluteValue(SWIGTYPE_p_uint64_t value, SWIGTYPE_p_void token) {
    return EnhancedDisassemblyJNI.EDLiteralTokenAbsoluteValue(SWIGTYPE_p_uint64_t.getCPtr(value), SWIGTYPE_p_void.getCPtr(token));
  }

  public static int EDRegisterTokenValue(SWIGTYPE_p_unsigned_int registerID, SWIGTYPE_p_void token) {
    return EnhancedDisassemblyJNI.EDRegisterTokenValue(SWIGTYPE_p_unsigned_int.getCPtr(registerID), SWIGTYPE_p_void.getCPtr(token));
  }

  public static int EDNumOperands(SWIGTYPE_p_void inst) {
    return EnhancedDisassemblyJNI.EDNumOperands(SWIGTYPE_p_void.getCPtr(inst));
  }

  public static int EDGetOperand(SWIGTYPE_p_p_void operand, SWIGTYPE_p_void inst, int index) {
    return EnhancedDisassemblyJNI.EDGetOperand(SWIGTYPE_p_p_void.getCPtr(operand), SWIGTYPE_p_void.getCPtr(inst), index);
  }

  public static int EDOperandIsRegister(SWIGTYPE_p_void operand) {
    return EnhancedDisassemblyJNI.EDOperandIsRegister(SWIGTYPE_p_void.getCPtr(operand));
  }

  public static int EDOperandIsImmediate(SWIGTYPE_p_void operand) {
    return EnhancedDisassemblyJNI.EDOperandIsImmediate(SWIGTYPE_p_void.getCPtr(operand));
  }

  public static int EDOperandIsMemory(SWIGTYPE_p_void operand) {
    return EnhancedDisassemblyJNI.EDOperandIsMemory(SWIGTYPE_p_void.getCPtr(operand));
  }

  public static int EDRegisterOperandValue(SWIGTYPE_p_unsigned_int value, SWIGTYPE_p_void operand) {
    return EnhancedDisassemblyJNI.EDRegisterOperandValue(SWIGTYPE_p_unsigned_int.getCPtr(value), SWIGTYPE_p_void.getCPtr(operand));
  }

  public static int EDImmediateOperandValue(SWIGTYPE_p_uint64_t value, SWIGTYPE_p_void operand) {
    return EnhancedDisassemblyJNI.EDImmediateOperandValue(SWIGTYPE_p_uint64_t.getCPtr(value), SWIGTYPE_p_void.getCPtr(operand));
  }

  public static int EDEvaluateOperand(SWIGTYPE_p_uint64_t result, SWIGTYPE_p_void operand, SWIGTYPE_p_f_p_uint64_t_unsigned_int_p_void__int regReader, SWIGTYPE_p_void arg) {
    return EnhancedDisassemblyJNI.EDEvaluateOperand(SWIGTYPE_p_uint64_t.getCPtr(result), SWIGTYPE_p_void.getCPtr(operand), SWIGTYPE_p_f_p_uint64_t_unsigned_int_p_void__int.getCPtr(regReader), SWIGTYPE_p_void.getCPtr(arg));
  }

}
