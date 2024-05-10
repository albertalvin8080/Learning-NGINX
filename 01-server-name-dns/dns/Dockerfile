FROM alpine:20240329

# This line installs two packages into the container using the Alpine package manager `apk`. The packages installed are:
# - bind: This is the package for BIND (Berkeley Internet Name Domain), which is a widely used Domain Name System (DNS) software.
# - openrc: This is the package for OpenRC, which is a dependency-based init system that works with the system-provided init program. It is used to control services that need to be started at boot time.
RUN apk add bind openrc

# This line is adding the named service (which is the BIND DNS server) to the default runlevel in OpenRC. The -u option updates the service dependencies.
# The name `named` comes from “name daemon”, which is the program that runs the DNS server.
RUN rc-update -u named