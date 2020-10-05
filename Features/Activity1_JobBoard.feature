@JobBoard_activity
Feature: Job Board 

Scenario: Create a new user 
	Given User is on Alchemey the Login Page 
	When User clicks on Add New button and Add New User 
	Then Verify the user was created 
	
@JobBoard_activity
Scenario: Search for jobs and apply them 
	Given User is on Alchemey jobs site 
	When User searches for job 
	Then Apply for job
	
@JobBoard_activity
Scenario: Post job and verify job 
	Given User is on Alchemey jobs site 
	When Post Job tiltle as "Test123" Description as "Testing Cucumber Project" email as "test213@yopmail.com" 
	Then Verify Job with tiltle "Test123" is listing


@JobBoard_activity
Scenario Outline: Post job and verify job with examples
	Given User is on Alchemey jobs site 
	When Post Job tiltle as "<Title>" Description as "<Description>" email as "<Email>" 
	Then Verify Job with tiltle "<Title>" is listing

Examples:
|	Title	|	Description		|	Email				|
|	Job 1	|	Description1	|	test171@yopmail.com	|
|	Job 2	|	Description2	|	test181@yopmail.com	|
|	Job 3	|	Description3	|	test191@yopmail.com	|