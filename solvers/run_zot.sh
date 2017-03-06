#!/bin/bash
echo "***********************************"
echo "Executing run_zot.sh"
echo "Running docker"
docker run --rm -v "$PWD":/usr/src/myapp -w /usr/src/myapp fmarconi/zot zot $1
