#!/bin/sh

# install git-secret
sudo apt-get update && sudo apt-get install apt-transport-https
sudo sh -c "echo 'deb https://gitsecret.jfrog.io/artifactory/git-secret-deb git-secret main' >> /etc/apt/sources.list"
wget -qO - 'https://gitsecret.jfrog.io/artifactory/api/gpg/key/public' | sudo apt-key add -
sudo apt-get update && sudo apt-get install -y git-secret

# import GPG key
echo $GPG_KEY | gpg --import --quiet

# reveal secret
git secret reveal -f
