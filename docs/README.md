# Gojo User Guide

Meet **_Gojo_**, the ultimate task manager inspired by the strongest sorcerer himself! Whether you're organizing deadlines, scheduling events, or keeping track of to-dos, Gojo ensures your productivity stays as sharp as his Infinity.

1. [Quick start](#quick-start)
2. [Features](#features-) 
   - [Adding Tasks](#adding-tasks)
        - Deadlines
        - To-Dos
        - Events
   - [Managing Tasks](#managing-tasks)
        - Mark
        - Unmark
        - List
        - Delete
3. [Finding Tasks](#finding-tasks)
4. [Saving](#saving)
5. [Exiting](#exiting)
6. [Miscellaneous](#miscellaneous)
   - [Gojo](#gojo) 
   - [Help](#help)
7. [Command Summary](#command-summary)


# Quick start
1. Ensure you have Java `17` installed in your computer

# Features 
## Adding Tasks
Gojo Chatbot makes task management effortless by allowing you to add different types of tasks to your list. Whether it’s a simple to-do, a deadline, or an event, Gojo keeps everything organized so you can focus on what truly matters.


**Deadlines**

The deadline task takes in a task description, as well as when is the task due by.

_command:_ `deadline <task description> /by <YYYY-MM-DD>`

_example:_ `deadline Finish report /by 2025-03-10`

_expected output:_
``` 
Got it! Task added.  
[D][ ] Finish report (by: Mar 10 2025)  
Now you have X tasks in the list.
```

**To-Dos**

The todo task takes in the description of the task.

_command:_ `todo <task description>`

_example:_ `todo Buy groceries`

_expected output:_
``` 
Got it! Task added.  
[T][ ] Buy groceries  
Now you have X tasks in the list.
```

**Events**

The events task takes in a task description, as well as the time duration of the given event.

_command:_ `event <task description> /from <start> /to <end>`

_example:_ `event Project meeting /from 10AM /to 12PM`

_expected output:_
``` 
Got it! Task added.  
[E][ ] Project meeting (from: 10AM to: 12PM)  
Now you have X tasks in the list.
```

## Managing Tasks

**Marking**

This command allows the user to Mark a task that is done.

_command:_ `mark <task number>`

_example:_ `mark 2`

_expected output:_
``` 
Awesome! Task marked as completed:  
[D][X] Submit assignment (by: Mar 15 2025)
```

**Unmarking**

This command allows the user to unmark the task, if it is already marked as done.

_command:_ `unmark <task number>`

_example:_ `unmark 2`

_expected output:_
``` 
Okay, I've marked this as not done yet. Guess even perfection takes a little time, huh?    
[D][ ] Submit assignment (by: Mar 15 2025)
```

**List**

Lists out all the current tasks in the list.

_command:_ `list`

_example:_ `list`

_expected output:_
``` 
Alright, here's the lineup of tasks on your list! Let's breeze through them.  
1. [T][ ] Buy groceries  
2. [D][X] Submit assignment (by: Mar 15 2025)  
3. [E][ ] Attend meeting (from: Mar 20 2025 to: Mar 21 2025)
```

**Delete**

Delete any unnecessary tasks.

_command:_ `delete <task number>`

_example:_ `delete 2`

_expected output:_
``` 
Ah, I see what you did there! Was that a sneaky Gojo-style move to make the task disappear?  
[D][X] Submit assignment (by: Mar 15 2025)  
Now you have 2 tasks in the list.
```

## Finding Tasks

Struggling to find a specific task in your list? The Find feature lets you quickly search for tasks using keywords. Gojo will locate and display all matching tasks with the specified keywords!

**Find**

Helps the user locate tasks with their specified keywords.

_command:_ `find <keyword>`

_example:_ `find meeting`

_expected output:_
``` 
Boom! Found your matching tasks.  
2. [E][ ] Attend meeting (from: Mar 20 2025 to: Mar 21 2025)  
4. [T][X] Prepare for team meeting  
```
## Saving
Gojo saves the data automatically after exiting the program, there is no need to save manually.

## Exiting
Exits the program

_command:_ `bye`

_expected output:_
``` 
Bye! Don't miss me too much, okay?
```

# Miscellaneous
## Gojo
Outputs a random fact about Gojo Satoru.

_command:_ `gojo`

_expected output:_
``` 
He considers himself 'the strongest'—and he's not wrong!
```

## Help
Outputs all commands the chatbot can take in.

_command:_ `help`

_expected output:_
``` 
1. list (Shows the current list of items)
2. todo <task description> (Adds a todo task)
3. deadline <task description> /by <YYYY-MM-DD> (Adds a deadline task)
4. event <task description> /from <start> /to <end> (Adds an event task)
5. mark <list index> (Marks a task)
6. unmark <list index> (Unmarks a task)
7. delete <list index> (Deletes a task)
8. find <keyword> (Finds a task with the specified keyword)
9. bye (Exits Gojo chatbot)
10. gojo (Try me)
11. help (Lists out all possible commands)
```

# Command Summary

| Action     | Format & Example                                                                                           |
|------------|------------------------------------------------------------------------------------------------------------|
| `deadline` | `deadline <task description> /by <YYYY-MM-DD>` <br> _e.g._ `deadline Finish report /by 2025-03-10`         |
| `todo`     | `todo <task description>` <br> _e.g._ `todo Buy groceries`                                                 |
| `event`    | `event <task description> /from <start> /to <end>` <br> _e.g._ `event Project meeting /from 10AM /to 12PM` |
| `mark`     | `mark <task number>` <br> _e.g._ `mark 2`                                                                  |
| `unmark`   | `unmark <task number>` <br> _e.g._ `unmark 2`                                                              |
| `list`     | `list`                                                                                                     |
| `delete`   | `delete <task number>` <br> _e.g._ `delete 2`                                                              |
| `find`     | `find <keyword>` <br> _e.g._ `find meeting`                                                                |
| `bye`      | `bye`                                                                                                      |
| `gojo`     | `gojo`                                                                                                     |
| `help`     | `help`                                                                                                     |

