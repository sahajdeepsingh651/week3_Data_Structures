public class CircularTour {

    // Function to find the starting petrol pump from which the tour can be completed
    public static int circularTour(int[] petrol, int[] distance) {
        int totalSurplus = 0;  // Total petrol available across all pumps
        int currentSurplus = 0;  // Surplus for the current journey
        int startIndex = 0;  // Index of the potential starting pump

        // Traverse through all the petrol pumps
        for (int i = 0; i < petrol.length; i++) {
            // Calculate the surplus petrol at the current pump
            totalSurplus += petrol[i] - distance[i];
            currentSurplus += petrol[i] - distance[i];

            // If currentSurplus is negative, we cannot start the tour from this pump
            // So, we reset the starting point to the next pump
            if (currentSurplus < 0) {
                startIndex = i + 1;  // Set next pump as the start point
                currentSurplus = 0;  // Reset current surplus
            }
        }

        // If totalSurplus is non-negative, the tour can be completed from startIndex
        return totalSurplus >= 0 ? startIndex : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int result = circularTour(petrol, distance);
        if (result != -1) {
            System.out.println("The tour can be completed starting at pump " + result);
        } else {
            System.out.println("No valid starting point exists.");
        }
    }
}
