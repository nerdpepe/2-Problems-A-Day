public class MinRefuelStops {
    static int minRefuelStops(int target, int startFuel, int[][] stations) {
        int count = 0, distanceTravelled = 0;
        int distanceAfterRefuel = startFuel;
        if(startFuel >= target)
            return count;

        int i = -1, stationLoc = 0;
        int min = 0;

        while(distanceTravelled < target) {
            min = Integer.MIN_VALUE;
            System.out.println(i);

            if( i == stations.length-1 && (stations[i][0] + stations[i][1] < target))
                break;


            for(int pos = i+1; pos < stations.length && stations[pos][0] <= distanceAfterRefuel; pos ++) {
                System.out.println("Checking pos "  + pos);
                int possibleFromPos = distanceAfterRefuel - (stations[pos][0] - distanceTravelled) + stations[pos][1];
                System.out.println(possibleFromPos);
                if(target - (possibleFromPos + stations[pos][0]) <= 0)
                    return count+1;

                if( target - (possibleFromPos + stations[pos][0]) < min) {
                    stationLoc = pos;
                    min = target - possibleFromPos;
                }
            }
            ++count;
            i = stationLoc;
            System.out.println("Station at i = " + i + " at " + stations[i][0] + " miles with fuel available : " + stations[i][1]);
            stations[i][1] += (distanceAfterRefuel- stations[i][0]);
            
            distanceTravelled = stations[i][0];
            distanceAfterRefuel = stations[i][1];
            System.out.println("Distance Travelled : - " + distanceTravelled);
            System.out.println("Distance Possible from here : - " + distanceAfterRefuel);
            //if(i==0)
            //    break;
        }

        return -1;
    }
    public static void main(String ...arg) {
        int target = 100;
        int startFuel = 10;
        int stations[][] = new int[][]{{10,60},{20,30},{30,30},{60,40}};
        int ans = minRefuelStops(target, startFuel, stations);
        System.out.print("Ended : " + ans);
    }
}
