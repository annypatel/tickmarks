#!/bin/sh

APP_MODULE=$1
APP_APK=$APP_MODULE/build/outputs/apk/debug/$APP_MODULE-debug.apk

TEST_MODULE=$2
TEST_MODULE_NAME=$(echo $TEST_MODULE | cut -d '/' -f 2)
TEST_APK=$TEST_MODULE/build/outputs/apk/androidTest/debug/$TEST_MODULE_NAME-debug-androidTest.apk

RESULTS_DIR=$3
CI_RESULTS_DIR=$RESULTS_DIR/$TEST_MODULE

FTL_RESULTS_DIR=$CIRCLE_BUILD_NUM/$TEST_MODULE
FTL_RESULTS_BUCKET=$GCLOUD_BUCKET_NAME


# Store the exit code from running the gcloud command. This is returned at the end of the script
GCLOUD_EXIT_CODE=0

gcloud firebase test android run \
    --type instrumentation \
    --app $APP_APK \
    --test $TEST_APK \
    --device model=Pixel2,version=28,locale=en_US,orientation=portrait \
    --timeout 30m \
    --results-bucket $FTL_RESULTS_BUCKET \
    --results-dir $FTL_RESULTS_DIR

# Capture the exit code of the gcloud command
GCLOUD_EXIT_CODE=$?


# Make result dir
mkdir -p $CI_RESULTS_DIR

# Pull down test results
gsutil -m cp -r -U "gs://$FTL_RESULTS_BUCKET/$FTL_RESULTS_DIR/*" $CI_RESULTS_DIR


exit "$GCLOUD_EXIT_CODE"