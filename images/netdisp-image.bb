SUMMARY = "A Qt netdisp image"
LICENSE = "MIT"

inherit core-image

QT_TOOLS = " \
    qtbase \
    qtbase-mkspecs \
    qtbase-plugins \
    qt5-env \
"

FONTS = " \
    fontconfig \
    fontconfig-utils \
    ttf-bitstream-vera \
"

QT_SERIALPORT = " \
    qtserialport-mkspecs \
"

TSLIB = " \
    tslib \
    tslib-conf \
    tslib-calibrate \
    tslib-tests \
"

IMAGE_INSTALL += " \
    ${FONTS} \
    ${QT_TOOLS} \
    ${QT_SERIALPORT} \
    ${TSLIB} \
    netdisp \
"

export IMAGE_BASENAME = "netdisp-image"
