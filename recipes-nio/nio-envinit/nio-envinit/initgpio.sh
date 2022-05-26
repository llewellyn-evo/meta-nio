#Initialising OE Line for TXB0108
echo 68 > /sys/class/gpio/export
echo "out" > /sys/class/gpio/gpio68/direction
echo 1 > /sys/class/gpio/gpio68/value

