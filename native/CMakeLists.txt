cmake_minimum_required(VERSION 3.10)
project(komam)

# Specify the library name and source files
add_library(komam SHARED
    src/komam_wrapper.c
)

# Find JNI
find_library(log-lib log)

# Link to log library
target_link_libraries(komam
    ${log-lib}
)

# Add include directories if needed, for example CPython headers or MuPDF headers
# target_include_directories(komam PRIVATE /path/to/include)
