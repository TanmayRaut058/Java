class SY2022bit058 {

	public long[] getNumbers(int n){
	     long arr[] = new long[n];
	     
       	     for(int i = 0; i < n; i++){
		arr[i] = System.nanoTime() % 1000000;
	     }
	     
	     return arr;
	}
	
	public int countPrime(long[] nums){
	    int primeNumber = 0;
	    
	    for(int i = 0; i < nums.length; i++){
		long num = nums[i];
		boolean flag = true;
		for(int j = 3; j < Math.sqrt(num); j+=2){
		   if(num % j == 0){
		      flag = false;
		      break;
		   }
		}
		
		if(flag){
		   primeNumber++;	
		}
	     }
	     
	     return primeNumber;
	}
	
 	public static void main(String[] args){
            SY2022bit058 s = new SY2022bit058();  
            
            long[] arr = s.getNumbers(100000);
            long startTime = System.currentTimeMillis();
            
            int c = s.countPrime(arr);
        	
            long endTime = System.currentTimeMillis();
        	
            System.out.println("Prime Numbers = "+c);
            System.out.println("Non - Prime Numbers = "+ (arr.length - c));
            System.out.println("Time Taken(ms) = "+ (endTime - startTime));
	}
}
