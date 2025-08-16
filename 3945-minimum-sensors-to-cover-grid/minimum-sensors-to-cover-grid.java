class Solution {
    public int minSensors(int n, int m, int k) {
        int size= 2* k+1;
        int rows = (int) Math.ceil((double) n / size);
    //Math.ceil expects a double and also returns a double 
       // int rows=(n+size -1)/size;
        int c=(m +size -1)/size;
        return rows*c;

    }
}
/*WHAT IS K HERE?
This means each sensor covers a square of side length 2k + 1, centered at (r, c).

WHYT IS ROWS AND C?
rows tells us how many vertical blocks we need
cols tells us how many horizontal blocks we need
Total blocks = rows * cols

   WHY CEIL AND NOT FLOOR?
   \U0001f9f1 Real-Life Analogy
Imagine you’re tiling a floor:

Floor length = 5 meters

Tile length = 3 meters
5 / 3 = 1.666...
But you can’t buy 1.666 tiles. You need to buy 2 full tiles to cover the floor.
*/