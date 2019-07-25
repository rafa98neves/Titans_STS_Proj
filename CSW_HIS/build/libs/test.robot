*** Settings ***
Library  hello.py
Documentation	Test different inputs on greetings

*** Test Cases ***

Default Test
  ${name}  Send Default Request  greeting
  Log  ${name}

Default Test w/ invalid endpoint
  ${name}  Send Default Request  Bacalhau
  Log  ${name}

Valid endpoint and valid name
  ${name}  Send Request  greeting  Rafa
  Log  ${name}

Valid endpoint and invalid name
  ${name}  Send Request  greeting  jOÃO
  Log  ${name}

Invalid endpoint and valid name
  ${name}  Send Request  Bacalhau  ComNata
  Log  ${name}

Invalid endpoint and invalid name
  ${name}  Send Request  Bacalhau  "
  Log  ${name}

Test user
  ${name}  Send NewUser  setuser  natalia  as  pombal
  Log  ${name}
