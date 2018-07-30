Feature:  Login to Gmail

As an user
I want to login to my gmail account
so that I can read and send emails

Scenario Outline: Positive and negative login to profile

Given an user on login page
When she decides to sign in  with login <login> and password <pass>
Then user is <result> in her profile

Examples:
| login          | pass	         | result     |
| userfortest412 | user123456789 | logged     |
| userfortest412 | user          | not logged |


