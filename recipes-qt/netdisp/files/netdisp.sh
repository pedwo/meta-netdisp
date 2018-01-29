#!/bin/sh
# Start the NetDisp application

LD_LIBRARY_PATH=/home/root
export LD_LIBRARY_PATH

export PATH=${PATH}:/usr/bin/qt5

export QT_QPA_PLATFORM=linuxfb
export QT_QPA_FB_TSLIB=1

if [ -e /dev/input/touchscreen0 ]; then
    TSLIB_TSDEVICE=/dev/input/touchscreen0
    export TSLIB_TSDEVICE
fi

if [ ! -f /usr/share/netdisp/netdisp ]; then
	echo "NetDisp application not found"
	exit 0
fi

case "$1" in
	start)
		echo -n "Starting NetDisp application"
		cd /usr/share/netdisp
		./netdisp &
		;;
  	stop)
  		killall netdisp
  		;;
  	restart|reload)
		$0 stop
		$0 start
		;;
	*)
		echo "Usage: $0 {start|stop|restart}"
		exit 1
		;;
esac
