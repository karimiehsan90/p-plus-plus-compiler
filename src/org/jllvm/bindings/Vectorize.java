/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.jllvm.bindings;

public class Vectorize {
  public static void LLVMAddBBVectorizePass(SWIGTYPE_p_LLVMOpaquePassManager PM) {
    VectorizeJNI.LLVMAddBBVectorizePass(SWIGTYPE_p_LLVMOpaquePassManager.getCPtr(PM));
  }

  public static void LLVMAddLoopVectorizePass(SWIGTYPE_p_LLVMOpaquePassManager PM) {
    VectorizeJNI.LLVMAddLoopVectorizePass(SWIGTYPE_p_LLVMOpaquePassManager.getCPtr(PM));
  }

}
