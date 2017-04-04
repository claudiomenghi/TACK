#!/bin/bash
echo "***********************************"
echo "Executing run_zot.sh"
echo "Running docker"

zot $1
#docker run --rm -v "$PWD":/usr/src/myapp -w /usr/src/myapp fmarconi/zot zot $1
