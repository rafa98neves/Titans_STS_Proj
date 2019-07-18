*** Settings ***
Library  hello.py
Documentation	Test different inputs on greetings

*** Test Cases ***
First Test
  ${name}  Send Default Request
  Log  ${name}
Second Test
  ${name}  Send Request  Rafa
  Log  ${name}

Third Test
  ${name}  Send Request  João
  Log  ${name}

Fourth Test
  ${name}  Send Request  "
  Log  ${name}
