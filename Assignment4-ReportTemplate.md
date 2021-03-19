**SENG 637 - Dependability and Reliability of Software Systems**


**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:       |  14 |
|-----------------|---|
| Student Names:  |   |
|           Evan Boerchers      |   |
|           Dean Kim      |   |
|                 |   |

# Introduction

This lab covers 2 core concepts of testing. The first concept is mutation testing, a test methodology that is used to validate how well a test suite is designed, and whether it has any weaknesses. This is done by introducing mutants, these being modified code that add bugs in order to test if your current test suite, kills these mutatnts or not. In this lab we will use the test suite in lab 3 to test mutation testing using pitest. We will evaluate our test suite and aim to improve it.

The second part of this lab focuses on GUI and web testing. Given the popularity of websites and GUI the concepts of automating web and GUI testing are very important. To demonstrate the concepts of GUI testing the Selenium plugin was implemented to design our test cases. These automated test cases were executed and the results reported. Additionally, we compared Selenium to another tool, Sikulix.

# Analysis of 10 Mutants of the Range class 

### Mutant 1

Class name: ShiftRangeDoubleZeroCrossingTestCase  
Method name: shiftWithZeroCrossing
Method tested: shift  
Mutant killed:  Y
Mutation:  Removed assignment to member variable range1
Analysis:  This mutant removes the assignment to the range1 variable while calling the shift method, meaning that the changes to range1 the method induces are not stored in the variable. For this reason, this mutant fails the test and is killed. 

### Mutant 2

Class name: ShiftRangeDoubleZeroCrossingTestCase  
Method name: shiftWithZeroCrossing
Method tested: shift  
Mutant killed:  Y
Mutation:  Removed call to org/jfree/data/Range::getLowerBound
Analysis:  This mutant removes the call to the getLowerBound in the assert statement that checks whether the shift method has shifted the bounds of the range correctly, meaning that the assert statement fails. For this reason, the mutant fails the test and is killed.

### Mutant 3

Class name: ShiftRangeDoubleZeroCrossingTestCase  
Method name: shiftWithZeroCrossing
Method tested: shift  
Mutant killed:  Y
Mutation:  Removed conditional - replaced equality check with true
Analysis:  This mutant replaces the check for equality between the getLowerBound and getUpperBound methods that was used to check for an error in earlier versions of Range, where the upper bound method returned would be equal to the lower bound. If the conditional is true, a fail statement for the test case is executed, so for this reason the mutant fails and is killed. 

### Mutant 4

Class name: ShiftRangeDoubleZeroCrossingTestCase  
Method name: shiftWithZeroCrossing
Method tested: shift  
Mutant killed:  Y
Mutation:  Removed call to org/jfree/data/Range::getUpperBound
Analysis:  This mutant removes the call to the getUpperBound in the assert statement that checks whether the shift method has shifted the bounds of the range correctly, meaning that the assert statement fails. For this reason, the mutant fails the test and is killed.

### Mutant 5

Class name: ShiftRangeDoubleZeroCrossingTestCase  
Method name: shiftNoZeroCrossing
Method tested: shift  
Mutant killed:  Y
Mutation:  Removed assignment to member variable range1
Analysis:  This mutant removes the assignment to the range1 variable while calling the shift method, meaning that the changes to range1 the method induces are not stored in the variable. For this reason, this mutant fails the test and is killed. 

### Mutant 6

Class name: RangeExpandToIncludeTest
Method name: expandToIncludeValueOutsideRangeLesser
Method tested: expandToInclude  
Mutant killed:  Y
Mutation:  Removed conditional in first if statement checking if range is equal to null, replace with true
Analysis:  This mutant removes the conditional checking if the range passed to the method is null and replaces it with true, meaning that the method will return a new range of just the value passed to the expandToInclude method. This will cause the range to fail the assertion test that calls getUpperBound and checks if the upper bound is accurate, as it will be replaced with the value passed to the expandToInclude method.

### Mutant 7

Class name: RangeEqualsTest
Method name: No methods catch this mutant
Method tested: equals  
Mutant killed:  N
Mutation:  Replaced boolean return statement false with true after checking if object passed to equals method is instance of range. There is a method in the test suite that calls the equal method on an integer and a Range object, but if this statement is altered in the equals method, this test method will pass and the mutation is unnoticed.

### Mutant 8

Class name: ShiftRangeDoubleZeroCrossingTestCase  
Method name: No methods catch this mutant
Method tested: shift  
Mutant killed:  N
Mutation:  Replaced 0 in max check between value + delta and 0 with -1 in return statement that executes if value is greater than 0.
Analysis:  This mutant isn't killed because there is no test method that calls for a shift by a positive value that would shift the new range's bounds to a value equal to or less than -1.

### Mutant 9

Class name: RangeExpandTest  
Method name: No methods catch this mutant
Method tested: expand  
Mutant killed:  N
Mutation:  Remove call to throw IllegalArgumentException if input range to method is null.
Analysis:  This mutant isn't killed because there is no test method that attempts to use the expand method on a null Range object. The closest test case examines only a Range object with undeclared boundaries.

### Mutant 10

Class name: ShiftRangeDoubleZeroCrossingTestCase  
Method name: No methods catch this mutant
Method tested: shift  
Mutant killed:  N
Mutation:  Replaced 0 in max check between value + delta and 0 with 1 in return statement that executes if value is less than 0.
Analysis:  This mutant isn't killed because there is no test method that calls for a shift by a negative value that would shift the new range's bounds to a value equal to or less than 1.



# Report all the statistics and the mutation score for each test class

## DataUtilities

![](report_images/DataUtilities_after.JPG) 

## Range

![](report_images/Range_after.JPG) 

# Analysis drawn on the effectiveness of each of the test classes

## DataUtilities Test Suite

Overall this test suite is generally effective based on the high coverage and mutant coverage scores. It is important to note that their are likely equivalent mutants present which will be inflating the score (see later section on this topic).

## Range Test Suite

# A discussion on the effect of equivalent mutants on mutation score accuracy

Equivalent mutants are mutants that do not affect the functionality of the software any differently than the original code. The reason this is such a big deal is that these mutants will give a misleading mutation score. This outcome is due to the fact that any test case that passes on the original software will also pass with the equivalent mutant implemented. 

The problem with the presense of these equivalent mutants is they will inflate the mutation score. If a large number of equivalent mutants exist, then your mutation score will be very high regardless of how robust and well designeed the test suite is. The presense of equivalent mutants must always be kept in mind when evaluateing the results of mutation testing.

# A discussion of what could have been done to improve the mutation score of the test suites

In order to improve the mutant coveerage score of our test suites the first step is to analyze the results of the Pitest. The goal of this is to observe which mutants are surviving. Based on the mutants that survive a strategy can be implemented to write a test case that will destroy this mutant. To determine what this test case should look like the Pitest tool allows us to view the mutant code. By viewing the code we will be able to determine what methods need to be further tested, and what the inputs for these methods should be in order to expose the mutant. Once determined a test case will be written applying the same principles of lab 2.

By writing these new test cases our mutant coverage scores will increase, meaning that our test suite will be more effective and robust.

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

We need in order to assess the quality of our test suites. Mutants allow us to introduce defects into our program in order to check and see if our test suite will catch these mutants, or if they will get past our testing. This is important because it allows us to improve our testing in the absence of any real defects in the production code.

**Advantages**
- Allows a quantatative measurement of how robust your test suite is.
- Ensures that bugs are unlikely to slip past your testing.

**Disadvantages**
- Time consuming and requires automation
- Boosting mutation score can be time consuming and may not yield any benefits in terms of fixing actualy bugs in your software.

# Explain your SELENUIM test case design process

# Explain the use of assertions and checkpoints

# how did you test each functionaity with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix

# How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
