# Write your MySQL query statement below
SELECT 
    name
FROM
    Customer
WHERE 
    referee_id IS null OR referee_id != 2
-- <> is same as != 
-- by default sql null value return nhi krta isliye is null wali condition use karenge 