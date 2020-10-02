# User Guide

## Features 

### Tasks
Ability to add, remove, list, mark as done and save different type of tasks.

## Usage

### `todo`

Adds todo item with a description

Example of usage: 

`todo (description)`

Expected outcome:

```
todo lunch
    ____________________________________________________________
     Got it. I've added this task: 
       [T][✘] eat
     Now you have 1 tasks in the list.
    ____________________________________________________________
```

### `event`

Adds event with a description and specific date

Example of usage: 

`event (description) /at (yyyy-mm-dd)`

Expected outcome:

```
event lecture /at 2020-10-01
    ____________________________________________________________
     Got it. I've added this task: 
       [E][✘] lecture (at: Oct 01 2020)
     Now you have 1 tasks in the list.
    ____________________________________________________________
```

### `deadline`

Adds deadline with a description and specific date

Example of usage: 

`deadline (description) /by (yyyy-mm-dd)`

Expected outcome:

```
deadline assignment /by 2020-10-01
    ____________________________________________________________
     Got it. I've added this task: 
       [D][✘] assignment (by: Oct 01 2020)
     Now you have 1 tasks in the list.
    ____________________________________________________________
```

### `list`

List all unremoved tasks, including completed and uncompleted

Example of usage: 

`list`

Expected outcome:

```
list
    ____________________________________________________________
     Here are the tasks in your list:
     1. [D][✘] homework (by: Jan 10 2020)
     2. [T][✘] sleep /at 2020/10/01 1pm
     3. [E][✘] lecture (at: Oct 01 2020)
     4. [T][✘] eat
     5. [E][✘] lecture (at: Oct 01 2020)
     6. [D][✘] assignment (by: Oct 01 2020)
    ____________________________________________________________
```

### `done`

Mark task as done given task index

Example of usage: 

`done (index)`

Expected outcome:

```
done 2
    ____________________________________________________________
     Here are the tasks in your list:
     1. [D][✘] homework (by: Jan 10 2020)
     2. [T][✓] sleep /at 2020/10/01 1pm
     3. [E][✘] lecture (at: Oct 01 2020)
     4. [T][✘] eat
     5. [E][✘] lecture (at: Oct 01 2020)
     6. [D][✘] assignment (by: Oct 01 2020)
    ____________________________________________________________
```
