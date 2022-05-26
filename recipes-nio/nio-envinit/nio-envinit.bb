SUMMARY = "Environment initialization scripts"
DESCRIPTION = "These scripts help to initialize the system on the first run"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"


PR = "r1"


SRC_URI = "                                     \
        file://initgpio.sh                      \
        file://07-sshd-dropbear-fix.sh          \
        file://08-sshd-dropbear-keys.sh         \
        file://12-mount-storage.sh              \
        file://20-cp-from-skel.sh               \
        file://21-generate-mac.sh               \
        file://systemd-firstboot.sh             \
        file://se                               \
        file://init-gpio.service                \
        file://systemd-firstboot.service        \
"

inherit systemd

S = "${WORKDIR}"

do_configure() {
	:
}

do_compile() {
	:
}


SYSTEMD_SERVICE_${PN} += "     \
    init-gpio.service                            \
    systemd-firstboot.service                    \
"

do_install(){

    install -d ${D}${systemd_system_unitdir}/
    install -m 0644 ${WORKDIR}/init-gpio.service ${D}${systemd_system_unitdir}/
    install -m 0644 ${WORKDIR}/systemd-firstboot.service ${D}${systemd_system_unitdir}/

    install -d ${D}${base_sbindir}/nio-envinit
    install -m 0755 ${WORKDIR}/*-*.sh ${D}${base_sbindir}/nio-envinit/
    install -m 0755 ${WORKDIR}/initgpio.sh ${D}${base_sbindir}/

    install -m 0755 ${WORKDIR}/systemd-firstboot.sh ${D}${base_sbindir}/
    install -m 0755 ${WORKDIR}/se ${D}${base_sbindir}/

}
