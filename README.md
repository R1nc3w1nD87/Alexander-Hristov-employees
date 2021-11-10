# Alexander-Hristov-employees

A simple program that reads from a .txt file and prints results to the console.

The function of the program is to find and print to the console a pair of two employees, who have the longest running team-up relationship on same projects.

The program is designed to read a file, formatted in the following way:

143, 12, 2013-11-01, 2014-01-05
218, 10, 2012-05-16, NULL
143, 10, 2009-01-01, 2011-04-27
...

where a single line of text contains the following information: employeeID, projectID, dateFrom, dateTo*

*If dateTo is NULL, the date is set to "today", meaning the employee is still working on the project at present.
