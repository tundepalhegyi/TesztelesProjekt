Feature: Check if the scrum epic add
	As Sapientia scrum tool user I want to be able to add epics

   Scenario: Title1Epic
   Given I open the scrum tool add page
   When I enter "title1" in  the title textbox and I push the add button
   Then I should get result "title1" in epics list