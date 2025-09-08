Update Task
=====================
Created by alper on 2.09.2025

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

## Update task with valid arguments
* Update task that
  |id|title     |description|status|assignedUserId|
  |--|----------|-----------|------|--------------|
  |1 |make calls|John, Alice|DONE  |3             |

* Response status code should be "202"
* Response type should be "TaskResponse"
* "id" should be "1" in response
* "title" should be "make calls" in response
* "description" should be "John, Alice" in response
* "status" should be "DONE" in response


## Update task with incorrect description
* Update task that
  |id|title     |description|status|assignedUserId|
  |--|----------|-----------|------|--------------|
  |1 |make calls|do         |TODO  |3             |

* Response status code should be "400"

## Update Task with not exist user id
* Update task that
  |id|title     |description|status|assignedUserId|
  |--|----------|-----------|------|--------------|
  |1 |make calls|John, Alice|TODO  |10            |

* Response status code should be "400"

## Update Task without user id
* Update task that
  |id|title     |description|status|
  |--|----------|-----------|------|
  |1 |make calls|John, Alice|TODO  |

* Response status code should be "422"