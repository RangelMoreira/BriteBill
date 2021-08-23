# BriteBill Improvements

## Overview

This repository is composed of improvement tips for a grading singleton as well as coding with the mentioned improvements.

By evaluating the submitted code, and analyzing the business requirements and application context, I was able to make the following observations to be passed on to the developer.

## Improvement Tips

First, it is not a good practice to use global variables in the application, it is recommended that the values be sent by parameters. As in the case of the "passfail()" method, it would be more recommended that the "grade" value be sent directly as a parameter, because this value is already obtained in the return of the "check()" method.

For the “check()” method, it would be better to pass only the parameter corresponding to the list, as its size can be returned using “.size()”, facilitating the subsequent reuse of this method.

To declare a list, like what happens in the "check()" method it would be better to import "java.util.list" with the other imports of the project and declare the list in this way "List<Answer> answers".

Instead of creating an instance of AnswerValidation() for each time the loop is executed, it is better to use dependency injection, as it saves memory when running the program and is also considered a good practice, as it facilitates the process of subsequent maintenance.

There is no need to use try and catch because because we are going through a list of answers from beginning to end, taking each answer by its index, there is no possibility of an index for a non-existent value.

For the "passfail()" method, the "pass" variable is unnecessary, as you can directly return the value, instead of passing the value to "pass" to return its value, saving memory space.

There is also a logic error in the "passfail()" method, because even if the first condition is true it will keep checking the other conditions, so for a value "grade>8" as the value would also be greater than 5, you would get the value returned as “1”.

The "if(grade <5)" is also unnecessary as it can be replaced by an "else" with a return value of "0" or just a return value of "0" after all conditions, thus saving processing time.

As the "passfail" method is only for use in this class, it must be declared as "private".

One last improvement, but also very important, is that it would be better to keep everything in a single method, as there is no need for numerous methods when they are called only once in the code.
Also, joining everything in a single method in this case also reduces unnecessary checks, such as checking "if(grade <5)" twice to see if "0" is returned and also setting the value "test.setStatus("Failed");"
