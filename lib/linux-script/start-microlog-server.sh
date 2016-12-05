bluecove=$(ls bluecove-[0-9].*.jar)
bluecovegpl=$(ls bluecove-gpl-*.jar)
microlog=$(ls microlog-server-bluetooth-*.jar)
echo "The Microlog Bluetooth server loading: " $bluecove $bluecovegpl $microlog
gksu "java -cp $bluecovegpl:$bluecove:$microlog net.sf.microlog.server.btspp.gui.MicrologBluetoothServerUI"