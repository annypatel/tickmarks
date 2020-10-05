#!/bin/sh

# install git-secret
sudo apt-get update && sudo apt-get install apt-transport-https
echo "deb https://dl.bintray.com/sobolevn/deb git-secret main" | sudo tee -a /etc/apt/sources.list
wget -qO - https://api.bintray.com/users/sobolevn/keys/gpg/public.key | sudo apt-key add -
sudo apt-get update && sudo apt-get install git-secret

# import GPG key
echo $GPG_KEY | gpg --import

# reveal secret
git secret reveal -f
