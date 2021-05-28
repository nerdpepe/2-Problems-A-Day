class MinMaxSum {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    long sum = 0;
    long max = -1;
    
    for(int n : arr)
        sum += n;
    
    
    long min = sum;
    
    for(int n : arr){
        long num = sum - n;
        
        if(num < min)
            min = num;
            
        if(num > max)
            max = num;
    }
    System.out.println( min + " " + max);
    
    }
}