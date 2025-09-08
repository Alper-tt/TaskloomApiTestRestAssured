Update Task Status
=====================
Created by alper on 2.09.2025

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

## Patch task status
* Patch task by id
    |id|status|
    |--|------|
    |1 |DONE  |
* Response status code should be "202"
* Response type should be "TaskResponse"
* "id" should be "1" in response
* "status" should be "DONE" in response
