package com.komam.pdf

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        init {
            // Load native JNI bridge. Implementation must produce libkomam.so
            System.loadLibrary("komam")
        }
    }

    // Native methods implemented in native/komam_wrapper.c
    external fun initializePythonBridge(dataPath: String): Boolean
    external fun shutdownPythonBridge()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val status = findViewById<TextView>(R.id.status)
        // Example call to the native bridge to initialize python + module assets.
        val initialized = initializePythonBridge(filesDir.absolutePath)
        status.text = if (initialized) "Komam PDF: Bridge initialized" else "Komam PDF: Init failed"
    }

    override fun onDestroy() {
        shutdownPythonBridge()
        super.onDestroy()
    }
}
