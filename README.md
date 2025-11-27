# Komam PDF — Android wrapper for PyMuPDF

This repository is a starter scaffold for Komam PDF — an Android app wrapper that exposes functionality from a PyMuPDF fork (MuPDF + Python bindings) to an Android UI.

Goals:
- Provide an Android app that can call into a Python-based PDF wrapper backed by MuPDF.
- Provide native JNI glue so the Android app can start/stop the Python runtime and call into the PyMuPDF wrapper.
- Package Python modules and native libraries as Android assets / .so files.

Important next steps (high-level):
1. Choose an Android-Python embedding strategy (Chaquopy, custom CPython cross-compiled, or other).
2. Cross-compile MuPDF and the PyMuPDF bindings for Android (armeabi-v7a, arm64-v8a, etc.).
3. Implement and test the JNI <-> Python bridge (native/komam_wrapper.c).
4. Add UI and feature work (open PDF, render pages, search, annotate).

This scaffold contains minimal placeholders and scripts to help organize work. I can continue by:
- Adding examples for Chaquopy integration, or
- Adding detailed CMake + toolchain files to cross-compile CPython + MuPDF,
- Or creating an initial APK build pipeline.

Tell me which approach you prefer and I’ll generate the next steps and required build files.
