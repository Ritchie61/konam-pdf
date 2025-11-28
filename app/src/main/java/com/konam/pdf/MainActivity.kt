package com.komam.pdf

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.komam.pdf.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG = "KomamPDF_Chaquopy"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // --- 1. Initialize Chaquopy ---
        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }
        
        // --- 2. Call Python Function ---
        val py = Python.getInstance()
        
        // Get the module object (the name of the python file without .py)
        val module = py.getModule("pdf_processor") 
        
        // Call the 'get_welcome_message' function
        val welcomeResult = module.callAttr("get_welcome_message", "Komam")
        Log.i(TAG, "Python Welcome Message: $welcomeResult")
        
        // --- 3. Calling a function with multiple complex arguments ---
        
        // Simulate a native document ID/pointer
        val nativeDocId: Long = 12345678L
        val pageNumber: Int = 1
        
        // Pass a Map (dictionary) as a complex argument
        val options = mapOf(
            "scale" to 2.5,
            "dpi" to 300,
            "mode" to "grayscale"
        )

        // Call the 'process_page_data' function
        val complexResult = module.callAttr(
            "process_page_data",
            nativeDocId,
            pageNumber,
            options // Maps are automatically converted to Python dictionaries
        )

        // Log the final result from the Python script
        Log.i(TAG, "Python Processing Result: $complexResult")
        
        // Your existing JNI setup remains here, e.g.:
        // System.loadLibrary("komam_wrapper") 
    }
    
    // Your JNI external declarations would go here (already defined):
    // external fun openDocumentNative(filePath: String): Long
    // external fun closeDocumentNative(documentPointer: Long)
    
    // ... rest of your MainActivity class ...
}
