import java.util.Arrays;

void main() {

    PrintLongestStraightLine(new int[]{2, 2}, new int[]{1, 1}, new int[]{2, 1}, new int[]{3, 3}, new int[]{4, 4}, new int[]{1, 3}, new int[]{-1, -1});

    System.out.println("===========================================================");

    PrintLongestStraightLine(new int[]{0, 0}, new int[]{1, 3}, new int[]{1, 2}, new int[]{2, 4}, new int[]{2, 2}, new int[]{3, 1}, new int[]{4, 0});

    System.out.println("===========================================================");
    //[-2, 0], [3, -1], [1, 2], [-4, 4]
    PrintLongestStraightLine(new int[]{-2, 0}, new int[]{3, -1}, new int[]{1, 2}, new int[]{-4, 4});

}

void PrintLongestStraightLine(int[]... coordinatePairs) {

    double maxLengthLineSlope = findSlope(findMaxLenPair(coordinatePairs)[0], findMaxLenPair(coordinatePairs)[1]);

    // print the pairs which have same slop of maxLengthLineSlope
    System.out.println(Arrays.toString(findMaxLenPair(coordinatePairs)[0]));
    for (int i = 0; i < coordinatePairs.length; i++) {

        if (findSlope(findMaxLenPair(coordinatePairs)[0], coordinatePairs[i]) == maxLengthLineSlope) {
            System.out.println(Arrays.toString(coordinatePairs[i]));
        }
    }
}

/*
find the maximum length pair using z^2 = x^2 + y^2
maximum z^2 pair return as maximum length line pair
 */
int[][] findMaxLenPair(int[]... coordinatePairs) {
    int maxLength = 0;
    int[][] maxLengthPair = new int[2][2];
    for (int i = 0; i < coordinatePairs.length; i++) {
        for (int j = i + 1; j < coordinatePairs.length; j++) {
            if (findSquarelength(coordinatePairs[i], coordinatePairs[j]) > maxLength) {
                maxLength = findSquarelength(coordinatePairs[i], coordinatePairs[j]);
                maxLengthPair[0] = coordinatePairs[i];
                maxLengthPair[1] = coordinatePairs[j];
            }
        }
    }
    return maxLengthPair;
}

/*
return the z^2
z^2 = x^2 + y^2;
 */
int findSquarelength(int[] coordinate1, int[] coordinate2) {
    int x1 = coordinate1[0];
    int y1 = coordinate1[1];
    int x2 = coordinate2[0];
    int y2 = coordinate2[1];

    return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
}

/*
return the slop (m)
 */
double findSlope(int[] coordinate1, int[] coordinate2) {
    double x1 = coordinate1[0];
    double y1 = coordinate1[1];
    double x2 = coordinate2[0];
    double y2 = coordinate2[1];

    return (y2 - y1) / (x2 - x1);
}




