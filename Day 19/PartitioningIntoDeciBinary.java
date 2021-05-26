public class PartitioningIntoDeciBinary {
        public int minPartitions(String n) {
            int max = -1;
            // as the deci-binary number will consist of maximum '1', the
            // minimum amount of additions will be the max value of digits present in the string
            for(int i =0; i<n.length(); i++) {
                int num = n.charAt(i) - '0';
                if(num > max)
                    max = num;
            }
            return max;
        }
}