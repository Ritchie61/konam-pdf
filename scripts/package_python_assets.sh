#!/usr/bin/env bash
set -e

# This script should package python/komam_pdf into app assets so the native side can extract.
# A typical approach is to zip the python package and copy into app/src/main/assets/python.zip
#
ZIP_OUT="../app/src/main/assets/komam_python.zip"
mkdir -p "$(dirname "$ZIP_OUT")"
zip -r "$ZIP_OUT" ../python/komam_pdf -x "*/__pycache__/*"
echo "Packaged python assets to $ZIP_OUT"
