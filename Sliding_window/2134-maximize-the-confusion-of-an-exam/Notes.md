<h2>maximize-the-confusion-of-an-exam Notes</h2><hr>[ Time taken: 78d 20hrs 41m 0s ]
same as other questions of this type where thay hv asked for a subarray conataining consequtive sismilar elements.
Here we use a sliding window approach i=0, j=0 .
length of subarray = j-i +1
remember we need to shrink the subarray or increase i to i = last_occurence of F +1 position. For that we use a while loop; while( f > k)
