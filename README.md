# Battleship

You’re required to build a game ‘Find-The-Battleship’ in Java program that fulfil the below requirements/rules. Analyze and develop the Java program as per described using the Object Oriented design. You need to use any levels of inheritance as possible and all the object oriented techniques you’ve learnt. You also need to document your design using the UML class and class relationship diagrams.

- The mission of the player that plays the game is to find the battleship of your enemy through a masked out map. Each ship is in 3-5 characters’ length.

- The game should have a 20 rows x 60 columns size, which you should masked the area with the character ‘#’.

- The game should allow player to choose among 3 stages of difficulties which contain different number of ships, traps and potions. For example:
    - Beginner: 80 ships, 10 traps, 18 potions
    - Intermediate: 50 ships, 20 traps, 18 potions
    - Advanced: 20 ships, 30 traps, 18 potions

- There are two types of trap: 
    - Low danger trap: which will reduce life by 1
    - High danger trap: which will reduce life by 2
    
    Your game should contain the mixture low and high danger traps.

- And, there is three types of potions:
    - Life saver potion: which can increase the life by 1
    - Trap reveal potion: which will reveal a trap
    - Ship reveal potion: which will reveal a ship
    
    For each game, you should have a mixture of each type of potions

- Once the game started, all the ships, traps and potions will be scattered randomly in the map and should not be visible to the player.

- The player is required to choose the location to unmask by coordinates (row, col), and should not be processed if the location is out of the map’s boundary.

- If it is a ship at that location, unmask the whole ship. If it is a trap, reduce the life accordingly; and if it is a potion, process accordingly based on the type of potion.

- Each player will have 15 lives. The screen should display the number of lives left and ships found while the game progress.

- Game will end when player successfully find 5 ships without exhausted all their lives, or game will end if player has no remaining lives.

When the game start, display the Top 10 scores and ask the player for the name. You should count the total steps the player takes along the games. If the player successfully completes the game, and the score is within the top 10 scores, store the player’s score and name in the Top 10 score text file. The list should be ordered by score in descending order.
