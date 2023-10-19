# External module imports
import RPi.GPIO as GPIO
import time
import os
import random

# Pin Definitons:
servoPIN = 4
servoButPIN = 15 #Y button
mooButPIN = 17 #X Button
servoOnCommandPIN

# GPIO setup:
GPIO.setmode(GPIO.BCM)
GPIO.setup(servoPIN, GPIO.OUT)
GPIO.setup(servoButPIN, GPIO.IN, pull_up_down=GPIO.PUD_UP) # Button pin set as input w/ pull-up
GPIO.setup(mooButPIN, GPIO.IN, pull_up_down=GPIO.PUD_UP) # Button pin set as input w/ pull-up
GPIO.setup(servoOnCommandPIN, GPIO.IN, pull_up_down=GPIO.PUD_UP)
p = GPIO.PWM(servoPIN, 50) # GPIO 4 for PWM with 50Hz
p.start(5) # Initialization


time.sleep(2)
try:
  while True:
    if not GPIO.input(servoButPIN): # button is pressed:
        print("servo but pressed, starting random countdown to pooping")
        countdown = random.randrange(15, 60, 1)
        time.sleep(countdown)
        os.system('omxplayer  /home/pi/robocow/mp3_files/cow_moo.mp3 ')
        countdown = random.randrange(15, 60, 1)
        time.sleep(countdown)
        os.system('omxplayer  /home/pi/robocow/mp3_files/fart-04.mp3 ')
        print("cycle = 10")
        p.ChangeDutyCycle(10)
        time.sleep(3)
        print("cycle = 5")
        p.ChangeDutyCycle(5)
        time.sleep(3)
    if not GPIO.input(mooButPIN): # button is pressed:
        print("moo but pressed")
        os.system('omxplayer  /home/pi/robocow/mp3_files/cow_moo.mp3 ')
        time.sleep(2)
    if not GPIO.input(servoOnCommandPIN): # button is pressed:
        print("cycle = 10")
        p.ChangeDutyCycle(10)
        time.sleep(3)
        print("cycle = 5")
        p.ChangeDutyCycle(5)
        time.sleep(3)

except KeyboardInterrupt:
  p.stop()
  GPIO.cleanup()