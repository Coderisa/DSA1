class Solution {
    public String restoreString(String s, int[] indices) {
        char []sbb = s.toCharArray();
        for(int i=0;i<indices.length;i++){
            sbb[indices[i]]=s.charAt(i);
        }
        return new String(sbb);
    }
}