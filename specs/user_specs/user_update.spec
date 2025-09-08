Update User
=====================
Created by alper on 8.09.2025

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

## Update user with valid arguments
* Update user that
    |id|username|mail    |
    |--|--------|--------|
    |2 |example |ex@ex.co|

* Response status code should be "202"
* "id" should be "2" in response
* "username" should be "example" in response
* "mail" should be "ex@ex.co" in response

## Update user with invalid username
* Create user that
    |id|username|mail    |
    |--|--------|--------|
    |2 |ex      |ex@ex.co|

* Response status code should be "400"

## Update user with invalid mail
* Create user that
    |id|username|mail    |
    |--|--------|--------|
    |2 |example |exam.co |

* Response status code should be "400"