#!/bin/bash
docker run --rm -v "$PWD":/usr/src/myapp -w /usr/src/myapp fmarconi/zot zot $1
