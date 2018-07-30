Feature:  Get info about character

As an user
I want to get info about character of favorite films
so that I become happier

Scenario Outline: Info about Star Wars

Given an character <charact> with id <id>
And his planet is <planet> with population <popul>
When I find <film_#>st film for his planet
Then film <title> is displayed
And character and his planet belong to that film

Examples:
| charact        | id | planet   | popul  | film_#  | title                |
| Luke Skywalker | 1  | Tatooine | 200000 | 1       | Attack of the Clones |



