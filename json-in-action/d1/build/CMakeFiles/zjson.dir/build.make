# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.6

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/local/Cellar/cmake/3.6.2/bin/cmake

# The command to remove a file.
RM = /usr/local/Cellar/cmake/3.6.2/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Users/zuston/dev/code-library/json-in-action/d1

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/zuston/dev/code-library/json-in-action/d1/build

# Include any dependencies generated for this target.
include CMakeFiles/zjson.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/zjson.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/zjson.dir/flags.make

CMakeFiles/zjson.dir/json.c.o: CMakeFiles/zjson.dir/flags.make
CMakeFiles/zjson.dir/json.c.o: ../json.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/zuston/dev/code-library/json-in-action/d1/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/zjson.dir/json.c.o"
	/Library/Developer/CommandLineTools/usr/bin/cc  $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/zjson.dir/json.c.o   -c /Users/zuston/dev/code-library/json-in-action/d1/json.c

CMakeFiles/zjson.dir/json.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/zjson.dir/json.c.i"
	/Library/Developer/CommandLineTools/usr/bin/cc  $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /Users/zuston/dev/code-library/json-in-action/d1/json.c > CMakeFiles/zjson.dir/json.c.i

CMakeFiles/zjson.dir/json.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/zjson.dir/json.c.s"
	/Library/Developer/CommandLineTools/usr/bin/cc  $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /Users/zuston/dev/code-library/json-in-action/d1/json.c -o CMakeFiles/zjson.dir/json.c.s

CMakeFiles/zjson.dir/json.c.o.requires:

.PHONY : CMakeFiles/zjson.dir/json.c.o.requires

CMakeFiles/zjson.dir/json.c.o.provides: CMakeFiles/zjson.dir/json.c.o.requires
	$(MAKE) -f CMakeFiles/zjson.dir/build.make CMakeFiles/zjson.dir/json.c.o.provides.build
.PHONY : CMakeFiles/zjson.dir/json.c.o.provides

CMakeFiles/zjson.dir/json.c.o.provides.build: CMakeFiles/zjson.dir/json.c.o


# Object files for target zjson
zjson_OBJECTS = \
"CMakeFiles/zjson.dir/json.c.o"

# External object files for target zjson
zjson_EXTERNAL_OBJECTS =

libzjson.a: CMakeFiles/zjson.dir/json.c.o
libzjson.a: CMakeFiles/zjson.dir/build.make
libzjson.a: CMakeFiles/zjson.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/zuston/dev/code-library/json-in-action/d1/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C static library libzjson.a"
	$(CMAKE_COMMAND) -P CMakeFiles/zjson.dir/cmake_clean_target.cmake
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/zjson.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/zjson.dir/build: libzjson.a

.PHONY : CMakeFiles/zjson.dir/build

CMakeFiles/zjson.dir/requires: CMakeFiles/zjson.dir/json.c.o.requires

.PHONY : CMakeFiles/zjson.dir/requires

CMakeFiles/zjson.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/zjson.dir/cmake_clean.cmake
.PHONY : CMakeFiles/zjson.dir/clean

CMakeFiles/zjson.dir/depend:
	cd /Users/zuston/dev/code-library/json-in-action/d1/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/zuston/dev/code-library/json-in-action/d1 /Users/zuston/dev/code-library/json-in-action/d1 /Users/zuston/dev/code-library/json-in-action/d1/build /Users/zuston/dev/code-library/json-in-action/d1/build /Users/zuston/dev/code-library/json-in-action/d1/build/CMakeFiles/zjson.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/zjson.dir/depend

