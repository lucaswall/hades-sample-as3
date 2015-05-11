#!/bin/bash

set -ex

cp ../ANEHadesPush/bin/ANEHadesPush.swc .

( cd ../AndroidHadesPush && ant jar )
mkdir -p android
cp ../AndroidHadesPush/bin/AndroidHadesPushLib.jar android/libAndroidHadesPushLib.jar
unzip -o ANEHadesPush.swc library.swf -d android

mkdir -p default
unzip -o ../DefaultHadesPush/bin/DefaultHadesPush.swc library.swf -d default

"/Applications/Adobe Flash Builder 4.7/eclipse/plugins/com.adobe.flash.compiler_4.7.0.349722/AIRSDK/bin/adt" \
	-package \
	-storetype pkcs12 -keystore keystore.p12 -storepass qwerty \
	-target ane HadesPush.ane extension.xml -swc ANEHadesPush.swc \
	-platform Android-ARM -C android . -platformoptions platform-android.xml \
	-platform default -C default .
#	-platform iPhone-ARM -C ios . -platformoptions platformoptions.xml \

