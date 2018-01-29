SUMMARY = "Renesas RZ/N1 Network Display app"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += "qtbase"

PR = "r0"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/pedwo/netdisp.git \
	file://netdisp.sh \
"

S = "${WORKDIR}/git"

require recipes-qt/qt5/qt5.inc

do_install() {
    install -d ${D}${datadir}/netdisp
    install -m 0755 ${B}/netdisp           ${D}${datadir}/netdisp
    install -m 0755 ${S}/Renesas-RZ.png    ${D}${datadir}/netdisp
    install -m 0755 ${S}/port-unused.png   ${D}${datadir}/netdisp
    install -m 0755 ${S}/port-active.png   ${D}${datadir}/netdisp
    install -m 0755 ${S}/port-inactive.png ${D}${datadir}/netdisp

	# Startup script
	install -d ${D}${sysconfdir}/init.d
	install -m 0644 ${WORKDIR}/netdisp.sh ${D}${sysconfdir}/init.d
	update-rc.d -r ${D} netdisp.sh start 99 5 .
}

FILES_${PN} = "${datadir}/netdisp ${sysconfdir}/rc5.d ${sysconfdir}/init.d"

RDEPENDS_${PN} = "qtbase-plugins"
