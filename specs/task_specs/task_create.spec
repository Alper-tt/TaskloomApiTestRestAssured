Create Task
=====================
Created by alper on 2.09.2025

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
## Create task with status
* Create task that
  |title           |description       |status|assignedUserId|
  |----------------|------------------|------|--------------|
  |grocery shopping|milk, tea, coffee |TODO  |1             |

* Response status code should be "201"
* Response type should be "TaskResponse"
* "title" should be "grocery shopping" in response
* "description" should be "milk, tea, coffee" in response
* "status" should be "TODO" in response

## Create Task without status response should be TODO
* Create task that
  |title           |description           |assignedUserId|
  |----------------|----------------------|--------------|
  |homeworks       |math, science, history|1             |

* Response status code should be "201"
* Response type should be "TaskResponse"
* "title" should be "homeworks" in response
* "description" should be "math, science, history" in response
* "status" should be "TODO" in response

## Create Task with invalid user id
* Create task that
  |title           |description           |assignedUserId|
  |----------------|----------------------|--------------|
  |homeworks       |math, science, history|10            |

* Response status code should be "400"

## Create Task without user id
* Create task that
  |title           |description           |
  |----------------|----------------------|
  |homeworks       |math, science, history|

* Response status code should be "422"
