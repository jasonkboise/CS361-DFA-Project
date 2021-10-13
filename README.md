# Project X: Project Name

* Author: Jason, Kuphaldt
* Class: CS361 
* Semester: Fall 2021

## Overview

Concisely explain what the program does. If this exceeds a couple of
sentences, you're going too far. Generally you should be pulling this
right from the project specification. I don't want you to just cut and
paste, but paraphrase what is stated in the project specification.

The program reads a text file and creates a DFA. The DFA is given states
and the states are given transitions. The DFA is then tested against strings
to see if the string is valid or not. 

## Compiling and Using

This section should tell the user how to compile your code.  It is
also appropriate to instruct the user how to use your code. Does your
program require user input? If so, what does your user need to know
about it to use it as quickly as possible?

## Discussion

Discuss the issues and successes you encountered during programming
(development). Here are some questions to get you started. You don't
have to answer all of them in order - they are a guideline to get you
thinking.
  * What problems did you have? What went well?
	The biggest issue we had was a null pointer exception. It took
	a long time to figure out but it turned out to be a very minor
	change (changing == to .equals())
  * What process did you go through to create the program?
	We went through the program driver and implemented
	the methods that the driver used as needed as well
	as other methods to support it.
  * What did you have to research and learn on your own?
	We did a lot of research on Maps, and the null
	pointer exception issue. 
  * What kinds of errors did you get? How did you fix them?
	Null pointer exception which we changed the == to 
	.equals in our transition method. 
  * What parts of the project did you find challenging?
	The most challenging part of the project was 
	trying to pick up where someone left off. 
	We had to read the intitial classes multiple times
	in order to get the hang of what was going
	on.
  * Is there anything that finally "clicked" for you in the process 
  of working on this project?
	When working on the project it finally clicked with me
	what methods a DFA would need, what a DFAState would need.
  * Is there anything that you would change about the project?
	I feel like this project helped me become a better programmer.
	It helps that my partner really knew what he was doing and I
	learned a lot. I think its a good project as is. 
  * Can you apply what you learned in this project to future projects?
	For sure I think it was good practice for programmers of
	my skill level. 

## Testing

We had initially made a test class that has since been removed. In the
test class we created dfas and tested various strings on it to make sure
that our transition method was working. We then tested it using the main
Driver and once we passed all of the tests provided by the instructor
we were confident about our final design.
