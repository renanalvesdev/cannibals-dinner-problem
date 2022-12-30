# cannibals-dinner-problem

A tribe of savage cannibals is dining on captured missionaries. They stand around a large cauldron containing M portions of boiled missionary stew. When a wildling is hungry, he pours himself into the cauldron unless it is empty. When the cauldron is empty, a wild cannibal needs to wake the cook so that he can prepare a new portion of stew and fill the cauldron again. If the cauldron is empty, the wildling goes to sleep after waking the cook to await the feast. After filling the cauldron, the cook wakes up the wild cannibals who have been waiting for the stew to be ready and goes back to sleep.

#Program Details

The program must contain the process "cannibal()" and the process "cozinheiro()" that must work concurrently. Furthermore you should use a shared buffer "melting pot" of size M=5.

#Cannibal()

Each cannibal must have the following behavior, starts awake, goes to serve itself(), eat() continuously. The time it takes each cannibal to serve himself is 1 second and the time to eat is 3 seconds.
Assume there are 3 cannibals to eat. If the cauldron is empty, the cannibal wakes the cook and goes to sleep.

#Chef()
The cook has the following behavior: he starts sleeping, when he is awake he prepares the stew and prepares_dinner() and then goes back to sleep. There is only one cook in the tribe. Dinner prep time is 5 seconds.

#Restrictions
Cannibals cannot serve each other at the same time.
Cannibals can eat at the same time.
Cannibals cannot help themselves if the cauldron is empty.
Cannibals can only help themselves after the cook has finished preparing dinner.
If the cauldron is empty, the cannibals wait in sleep.
The cook can only fill the cauldron when it is empty.

#Task
Develop a concurrent program for the actions of the cannibals and the cook. The program can be written in C, C++, Java or Python.
The program should run for 2 min without deadlock or starvation. Indicate the events during program execution: cannibals serving, eating and sleeping, cook preparing or sleeping. At the end of the run, show how many times the cook needed to fill the cauldron, how many times each cannibal ate
