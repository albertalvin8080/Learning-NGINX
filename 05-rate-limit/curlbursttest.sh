#!/bin/bash

curl http://main.com/test &
curl http://main.com/test &
curl http://main.com/test &
curl http://main.com/test &
curl http://main.com/test &
curl http://main.com/test &
# curl http://main.com/test & # causes 429 if `rate=1r/s` and `burst=5`