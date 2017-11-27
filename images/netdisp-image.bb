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

# Install QtWebKit even though we do not use it. This is because we also
# use this distro recipe for 3rd parties that use it for Qt development.
IMAGE_INSTALL += " qtwebkit"

# QtWebkit pulls in some optional packages, and these then pull in a lot
# more packages. To keep the size of the distro down, we are explicity
# removing these optional packages
PACKAGES_remove = " qtlocation qtmultimedia qtsensors qtwebchannel"

# Since we want this for 3rd party development, include libs, etc
IMAGE_FEATURES += "dev-pkgs"

export IMAGE_BASENAME = "netdisp-image"

# We only want a tarball output as we are extracting to an SD card.
IMAGE_FSTYPES = "tar.bz2"
