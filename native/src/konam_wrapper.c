#include <jni.h>
#include <android/log.h>
#include <string.h>

#define LOG_TAG "komam_native"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)

/*
 Placeholder JNI bridge.

 Responsibilities:
 - Initialize embedded Python runtime (or Chaquopy) and ensure python/komam_pdf package
   is available in sys.path (e.g., by extracting assets to app filesDir).
 - Import komam_pdf.bridge and call initialization functions to load the PyMuPDF wrapper.
 - Provide JNI functions to call PDF operations (open, render page, search).
 - Shutdown and cleanup when requested.

 Note: Implementing the Python runtime and embedding properly requires cross-compiled CPython or
 using a library like Chaquopy. This file provides the function signatures and logging.
*/

JNIEXPORT jboolean JNICALL
Java_com_komam_pdf_MainActivity_initializePythonBridge(JNIEnv* env, jobject thiz, jstring j_data_path) {
    const char* data_path = (*env)->GetStringUTFChars(env, j_data_path, 0);
    LOGI("Initializing Python bridge. data path: %s", data_path);

    // TODO:
    // 1) Extract python assets from APK to data_path (if not already).
    // 2) Initialize CPython runtime (Py_Initialize) and configure sys.path to include data_path.
    // 3) Import komam_pdf.bridge and call its init function.
    // For now, return true as placeholder.

    (*env)->ReleaseStringUTFChars(env, j_data_path, data_path);
    return JNI_TRUE;
}

JNIEXPORT void JNICALL
Java_com_komam_pdf_MainActivity_shutdownPythonBridge(JNIEnv* env, jobject thiz) {
    LOGI("Shutting down Python bridge (placeholder).");
    // TODO: call Py_FinalizeEx() or appropriate shutdown.
}
