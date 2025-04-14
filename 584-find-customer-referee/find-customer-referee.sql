# Write your MySQL query statement below 
#The reason we include IS NULL is that we need to account for customers who have a NULL value in the referee_id column.
# The != 2 condition alone will only exclude the rows where referee_id is exactly 2. 
#It won't include rows where referee_id is NULL because NULL represents an absence of data, 
#and comparing it with a value using != (or any other comparison operator) doesn't return TRUE or FALSE—it returns UNKNOWN.
Select name from Customer where referee_id !=2 or referee_id is null;