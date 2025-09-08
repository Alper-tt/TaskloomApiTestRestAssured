Get User
=====================
Created by alper on 8.09.2025

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

## Get all users
* Get all users
* Response status code should be "200"
* Response type should be "List"

## Get user by id
* Get user by id "1"
* "id" should be "1" in response
* Response status code should be "200"

## Get user by username
* Get user by username "string"
* "username" should be "string" in response
* Response status code should be "200"

## Get by mail
* Get user by mail "test@test.com"
* "mail" should be "test@test.com" in response
* Response status code should be "200"
