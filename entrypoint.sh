#!/bin/bash
source ~/.bashrc

PATH=/usr/local/zot/bin:$PATH
#cp /TACK/checker/build/libs/checker-all.jar ./tack.jar

exec "$@"