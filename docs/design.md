# Komam PDF — Design notes

Overview:
- Android app (Kotlin) hosts the UI and invokes native JNI functions.
- Native layer (C/C++) is responsible for:
  - Extracting Python assets from APK to app's filesDir.
  - Bootstrapping embedded Python runtime (or integrating with Chaquopy).
  - Loading and calling Python modules that use PyMuPDF bindings.
- Python layer contains the high-level wrapper (python/komam_pdf) that uses PyMuPDF API.

Embedding options:
- Chaquopy: Easiest to get Python in Android; but integrating with C extensions (MuPDF native bindings) may be challenging.
- Custom CPython cross-compile: Gives full control, but requires cross-compiling CPython and PyMuPDF (C-extensions) for Android ABIs.
- Kivy / PyJNIus / BeeWare: Alternative ecosystems; may not fit if you need native Android UI.

Build notes:
- Cross-compile MuPDF for Android ABIs and build PyMuPDF wheel against that MuPDF.
- Place compiled .so native libraries under app/libs/<abi>/ so Gradle packages them.
- Ensure that Python extension modules are available inside the Android filesystem before importing.

Security & storage:
- PDFs may require storage permissions; consider using SAF (Storage Access Framework) and not requesting WRITE_EXTERNAL_STORAGE on modern Android if possible.

Next steps:
- Choose embedding approach.
- Create CI scripts to cross-compile MuPDF and PyMuPDF for target ABIs.
- Implement native bootstrap to extract python assets and initialize runtime.
