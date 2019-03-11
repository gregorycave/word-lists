# word-lists
A program built using Java that stores a list of words, and allows the user to add, remove, and search for words in that list

This program is a frame-based application that allows the user to store a list of words. The layout is such that the buttons are displayed at the top of the panel, user input is provided in a text field at the bottom and system output is displayed in the centre. 

The application provides features and corresponding buttons that allow the user to: 
* add a word to the list (the word to be added is provided in a text field at the bottom of the application). 
* display all of the words from the list that end with a specified letter (this method is case-insensitive, e.g. no matter whether the user input is 'A' or ‘a’, all words ending with 'a' are displayed)
* search the list for a word (that is provided in the text field) and display how many times it is found and the positions in the list in which it is found; if however the text field is empty when this button is pressed, the system will display the total number of all words in the list (together with an appropriate message)
* remove from the list the last occurrence of a word
* remove from the list all occurrences of a word
* clear the list

The list may contain duplicate entries. Words may contain only letters, numbers, and hyphens (-) and must begin with a letter.

For each action specified above an appropriate message is displayed on the centre panel confirming the action, e.g.  “Word ‘toast’ has been added to the list”. 

An appropriate error message is displayed if any of the actions failed, e.g.  “The string ‘12’ was not added to the list as it is not a valid word.”
