Feature: Login page feature
Background: user is on login page
Given user is on login page 


@test1
Scenario:Login with correct credentials
Given user is on the link
When user enters username "rohitpachauri2@gmail.com"
And user enters password "Selenium@1234"
And user clicks on login button
Then user gets the page title
And  title of page should be "Automation Exercise"


@test2
Scenario: Contact us form
Given user is on the link
When user clicks on Contact Us button
And user can see get in touch text
Then user can write "<name>" "<email>" "<subject>" and "<message>"
And user can upload a file
And user can submit and click ok
And user can see success message
And user can click home button to land on home page successfully

Examples:
| name  | email                     | subject        | message            |
| Rohit | rohitpachauri2@gmail.com  | sample subject | this is my message |

@test3
Scenario: Verify Test Cases Page
Given home page is visible successfully 
When clicks on test cases hyperlink
Then user is navigated to test cases page successfully
And user is able to fetch all the test cases in console

@test4

Scenario Outline: Search product
Given home page is visible successfully 
When Click on Products button
Then user is navigated to ALL PRODUCTS page successfully
And Enter "<product_name>" in search input and click search button
And "<product_name>" is visible
And all the products related to search are visible

Examples:
|product_name|
|Top|





#link-https://automationexercise.com/

#username="rohitpachauri2@gmail.com"
#pass="Selenium@1234"

