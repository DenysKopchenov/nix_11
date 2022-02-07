#!/bin/sh

. ./satentenv.sh

cd app/

ant clear compile build run
