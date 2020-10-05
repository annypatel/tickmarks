#!/bin/sh

git secret hide -d

gpg --batch --yes --quiet --delete-secret-keys $GPG_KEY_ID
gpg --batch --yes --quiet --delete-keys $GPG_KEY_ID
