# Write your MySQL query statement below
SELECT tweet_id FROM Tweets
WHERE CHAR_LENGTH (content) > 15;
#using CHAR_LENGTH() would be better instead of using LENGTH()
#CHAR_LENGTH() Function:
#It counts the actual number of characters rather than the number of bytes.
#This is particularly useful for strings containing multi-byte characters, such as Unicode.
#'\U0001f60a' in UTF-8: 4 bytes (0xF0 0x9F 0x98 0x8A)
#Length() function-
#Single-byte character (ASCII)

#'A' in ASCII: 1 byte (0x41)
#Returns the length of a string in bytes.
#For strings with single-byte characters (e.g., ASCII), the result is the same as CHAR_LENGTH(). For multi-byte characters, the result may differ.