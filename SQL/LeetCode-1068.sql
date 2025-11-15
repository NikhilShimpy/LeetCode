# Write your MySQL query statement below
-- (sale_id, year) is the primary key 
-- product_id is a foreign key REF Product Table

select p.product_name , s.year , s.price 
from Sales s 
JOIN Product p ON s.product_id = p.product_id;
