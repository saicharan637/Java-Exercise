# Java-Exercise

A gaming system contains the following fields
game_id, player_id, played_date, points

1. Generate random synthetic data for the above fields with following constraints:
Number of games: 5
Number of players in each game: 75 to 125 (Note: same player can be repeated multiple times on different dates but on same date. Meaning, same player shouldn't play on the same date but can play on different dates)
played_date: All games should have played in the month of August 2021 but not on Tuesdays
points: The point for each player should be in the range of 75 to 200 only

2. Once the above random synthetic data is created then store the results in a CSV file
3. Read the above CSV file and perform the following aggregations:
Find out the top 5 players by points in each of the games and display the results (game_id, player_id, total_points)
Find out the bottom 5 players by points in each of the games and display the results (game_id, player_id, total_points)
Find out the top 5 players in each game whose total points in a game is greater than the average of all players points of that game (hint: if average points of all players in game 1 is 90 then find out all the top 5 players whose points are greater than 90)
Find out top 5 players in each game by their total points for each week (hint: list 5 players in game 1 with top scores between Aug 1st - Augt 7th)
Find out top 5 players in each game by their total points bi-weekly - every 2 weeks (hint: list 5 players in game 1 with top scores between Aug 1st - Augt 14th)

4. Create a proper project structure for the above problem statement, indent the code properly, add comments to the code, perform all git operations on the code (git clone, add, commit, fetch, pull, etc). Each of the above requirements should be an individual commit to the github
![1](https://user-images.githubusercontent.com/22254732/156906796-31c04a5a-f2c2-4670-b140-89ca2656eff9.png)
![2](https://user-images.githubusercontent.com/22254732/156906798-182d5755-0620-41c5-bce5-85a1d170e7b5.png)
![3](https://user-images.githubusercontent.com/22254732/156906799-b15a7e6d-5f05-4e83-acd3-7789a9409aac.png)
