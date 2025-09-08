Create User
=====================
Created by alper on 8.09.2025

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

## Create user with valid arguments
* Create user that
    |username|mail        |
    |--------|------------|
    |test    |test@test.co|

* Response status code should be "201"
* "username" should be "test" in response
* "mail" should be "test@test.co" in response

## Create user with invalid username
* Create user that
    |username|mail      |
    |--------|----------|
    |te    |test@test.co|

* Response status code should be "400"

## Create user with invalid mail
* Create user that
    |username|mail   |
    |--------|-------|
    |test    |test.co|

* Response status code should be "400"