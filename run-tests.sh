#!/usr/bin/env bash

# Default to regular Chrome
HEADLESS=false

# Check for command-line argument
if [[ "$1" == "headless" ]]; then
    HEADLESS=true
fi

# Run tests with the selected mode
mvn test -Dcucumber.options="--tags @regression" -Dheadless=$HEADLESS
