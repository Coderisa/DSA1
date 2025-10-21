class Solution {
    public boolean isNumber(String s) {
        String numberRegex = "^[+-]?((\\d+(\\.\\d*)?)|(\\.\\d+))([eE][+-]?\\d+)?$";
        return s.matches(numberRegex);
    }
}
