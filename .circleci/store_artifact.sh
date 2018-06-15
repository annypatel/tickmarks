#!/bin/sh

FROM=$1
TO=$2

echo "Storing artifacts from '$FROM' to '$TO'."
mkdir -p $TO
find . -type f -regex $FROM -exec cp --parents {} $TO \;