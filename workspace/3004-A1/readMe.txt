Preston, Matthew 100900955

https://github.com/moose0030/4004-A1-SimplePoker

Requirements
1: Test for Duplicate cards and suites
CardTest.java
-checkCardValidity2

2: Test for Minimum and maximum number of players (2 to 4)
RoundTest
-testNumberOfPlayersMax
-testNumberOfPlayersMin

3: Test to ensure there are 5 cards dealt to each player
HandTest.java
-testGetCardsSize

4: Hands are ranked in order !
HandTest.java
-testAllHandsRankings
-testCompareTo4OAK2
-testCompareToStraight
-testCompareToFullHouse

5: Test for duplicate hands e.g. Royal Flush and ensure they are listed at 
the top of the ranking order
HandTest.java
-testCompareToRoyalFlushEq
-testCompareTo4OAK2
-testCompareToStraight
-testCompareToFullHouse

RoundTest.java
-testBetterHandSameRank
-testBetterHandSameHands

6: Test for invalid cards e.g. fourteenClubs, threeShovels, thDiamonds etc.
CardTest.java
-checkCardValidity3
-checkCardValidity4

GameTest.java
-getTwoSameCards

7: Test for valid player ids
GameTest.java
-verifyIdAndCardsCorrect
-verifyIdAndCardsTooMany
-verifyIdAndCardsWrong

HandTest.java
-testGetID

8: Ensure the order of entry is correct - e.g. player id and then the cards
GameTest.java
-verifyIdAndCardsCorrect
-verifyIdAndCardsTooMany
-verifyIdAndCardsWrong



Known issues:
If a player enters AceSpades AceHearts TwoSpddd ThreeHearts FourDiamonds, then the 4 valid cards become unplayable. The player should be able to pick 5 new cards to play though.

How to run:
Ignore src directory.
Go to workspace/3004-A1.
Import src folder into eclipse project.
Right click on project to run as JUnit TestSuite or run as console application.
