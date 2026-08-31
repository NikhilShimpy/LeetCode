# Write your MySQL query statement below
SELECT tweet_id
FROM Tweets
WHERE CHAR_LENGTH(content) > 15

-- CHAR_LENGTH() -> Find length -> char
-- LENGTH()      -> Find Length -> bytes

-- another sol
-- select tweet_id from Tweets WHERE length(content)>15;