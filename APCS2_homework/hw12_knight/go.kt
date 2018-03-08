Addison Huang
APCS2 pd2
HW12 -- __+3R|\/|1|\|4|_  1|_|_|\|3$$__
2018 03 02

Q0: I never knew a single .java file could have multiple class definitions but I guess this works because one of them doesn't have any protection. The file is still named after the class with the protection though.

Q1: The command line arguments are processed by the boardsize and the delay. The syntax is java Demo [BOARDSIZE] [DELAY]. The arguments are processed in the main method of demo.

Q2: If none are given it uses a default value for boardsize and delay. The default for boardsize is 8 and delay is 500.

Q3: The nature of the recursion is in the go method. It goes for a certain amount of moves before it stops. It is not necessary for the animation because you can just use a forloop.

Q4: I expect to see a board of all 0s. Then, the 0s will change to numbers based on which move it is. The numbers will appear in random locations.

Q5: I expect it to run for n moves * delay.

Q6: ANSI is American National Standards Institute. It creates the standards for the computer industry.

Q7: My expectations were different from my observations because I noticed that not all of the board was full.

Q8: I will adapt this framework for animating a probing for a knights tour by replacing boardasaurus with my knights tour algorithm.

My new knights tour algo:

A knight is placed at row[0,0].
It checks all possible moves.
It makes the move where there will be the least amount of places to go after that.
Repeat until finished.
If there is no solution, it stops.

