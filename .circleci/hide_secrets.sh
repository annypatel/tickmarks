#!/bin/sh

git secret hide -d

gpg --batch --yes --delete-secret-keys $GPG_KEY_ID
gpg --batch --yes --delete-keys $GPG_KEY_ID
