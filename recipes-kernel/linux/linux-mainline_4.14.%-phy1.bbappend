FILESEXTRAPATHS_prepend_nio-controller := "${THISDIR}/linux-phytec-common:"

SRC_URI_append_nio-controller = " 		                		                 \
    file://0001-fix-sdma-event-bug-applicable-for-uart6-on-imx-contr.patch     	 \
    file://nio-controller-mx6ul.dts                                              \
    file://nio-controller.dtsi                                                   \
"

do_configure_prepend_mx6ul-comm-module() {
    cp ${WORKDIR}/*.dtsi ${S}/arch/arm/boot/dts/
    cp ${WORKDIR}/*.dts ${S}/arch/arm/boot/dts/
}

COMPATIBLE_MACHINE .= "|nio-controller"

