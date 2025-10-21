import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = 0;

        for (int house : houses) {
            int closest = findClosestHeater(house, heaters);
            radius = Math.max(radius, closest);
        }

        return radius;
    }

    private int findClosestHeater(int house, int[] heaters) {
        int left = 0, right = heaters.length - 1;

        // Binary search to find the closest heater
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (heaters[mid] == house) {
                return 0;
            } else if (heaters[mid] < house) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int dist1 = (right >= 0) ? Math.abs(house - heaters[right]) : Integer.MAX_VALUE;
        int dist2 = (left < heaters.length) ? Math.abs(house - heaters[left]) : Integer.MAX_VALUE;

        return Math.min(dist1, dist2);
    }
}
