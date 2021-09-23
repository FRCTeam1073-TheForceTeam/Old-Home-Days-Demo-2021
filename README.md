# Project Name: Robocow
# Description: This code runs the robocow which was used for cow patty bingo at Old Home Days and may be used at future events.
# Components:
1. Standard roboRIO WPILib robot code, based on robot21
1. Python code and MP3 files which run the sound effects and the "pooper" mechanism on the Raspberry Pi
	
# Usage Notes:
## Controls
* The robot driving is done with a single x-box controller with arcade drive
* The X button causees the cow to moo
* The Y button 
	1. Runs a random 0-30s timer, then moos (with a slightly different moo)
	1. Runs another random 0-30s timer, then makes the "poop" sound
	1. Moves the poop dropper servo down for 5 seconds then back up
	
## roboRIO to Raspberry Pi communication
* The communication between the roboRIO and the RaspberryPi is done via GPIO.  It is one way communication from roboRIO to Pi.
* The roboRIO pulses a GPIO pin to signle the Pi.  Meanwhile the Pi python code is running in a loop checking the status of the GPIO pins and if it sees one change state it triggers the action.
* The wiring diagram for this can be found in the file RobocowWiringDiagram.jpg in the top directory of the project.

## Running and debugging the python code on the Raspberry Pi
* The raspberry Pi will cause the cow to moo twice in succession when it boots. This is useful to know if it has booted and to know if it has spontaneously rebooted.
* To log into the pi, from a command window on the driver station laptop: 
	* ssh pi@10.10.73.22
	* password: raspberry
* The code is under /home/pi/robocow
* The script to run the cow is doitall.py, the command to run it is "python doitall.py".  

## Known issues, things to be aware of
* The Pi is set up to automatically start the python code when it boots (Mr. St.Hilaire did this using systemd).  However when running that way it seems to not respond reliably to the poop signal and it sometimes just reboots in the middle of operation.
* The workaround to this it to log in to the Pi whenever the robot is powered on, and then killing the running python script and then restarting it manually.
    1. To find the PID of the python code: "ps ax |grep python", this will return a few strings one of which will include doitall.py and will begine with a number (4 or 5 digits) this number is the PID (Process ID)
	1. To stop the script "sudo kill <PID>"
	1. To start it manually "cd /home/pi/robocow && python doitall.py"
* The bullhorn that is used for sound effects has a rechargable battery pack that should be charged for a few hours before being used.  If it is not charged, the bullhorn can run off of 6 C batteries.