"""
Python bridge that will be imported by the native JNI wrapper.

Responsibilities:
- Initialize the PyMuPDF-based wrapper (mupdf_wrapper).
- Expose functions to Android via JNI (if using a direct JNI->Python call strategy),
  or expose a simple RPC-like API callable over a socket or by calling functions in C that
  distribute requests to Python.

Note: On Android you'll typically:
- Extract this package into an accessible path.
- Ensure CPython is started with this path on sys.path.
"""

import os
from . import mupdf_wrapper

class KomamBridge:
    def __init__(self, data_path: str):
        self.data_path = data_path
        self.mupdf = mupdf_wrapper.MuPDFWrapper()
        # initialize as needed
    def open(self, filename: str):
        return self.mupdf.open(filename)
    def close(self):
        self.mupdf.close()
