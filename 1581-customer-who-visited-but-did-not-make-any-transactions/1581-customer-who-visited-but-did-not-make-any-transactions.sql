# Write your MySQL query statement below
SELECT v.customer_id , COUNT(v.customer_id) AS count_no_trans
FROM Visits AS v
LEFT JOIN Transactions AS t
ON v.visit_id = t.visit_id
WHERE t.transaction_id IS null
GROUP BY v.customer_id