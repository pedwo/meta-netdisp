SUMMARY = "Renesas RZ Network demo app"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += "qtbase"

PR = "r0"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/pedwo/netdisp.git"

S = "${WORKDIR}/git"

require recipes-qt/qt5/qt5.inc

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/netdisp ${D}${bindir}
    install -m 0755 ${S}/Renesas_blue.png ${D}${bindir}
    install -m 0755 ${S}/Renesas-RZ.png ${D}${bindir}
    install -m 0755 ${S}/port-unused.png ${D}${bindir}
    install -m 0755 ${S}/port-active.png ${D}${bindir}
    install -m 0755 ${S}/port-inactive.png ${D}${bindir}
}

FILES_${PN} = "${bindir}"

RDEPENDS_${PN} = "qtbase-plugins"