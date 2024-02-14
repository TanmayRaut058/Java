class SY2022bit058 {

    public boolean isValid(String str){
        if(str.length() != 10){
            return false;
        }
        
        String year = str.substring(0 , 4);
        String branchId = str.substring(4 , 7);
        String seq = str.substring(7 , 10);
	
        if(Integer.parseInt(year) < 2000 || Integer.parseInt(year) > 2024){
            return false;
        }
        
        else if(!(branchId.equals("bit") || branchId.equals("bcs") || branchId.equals("bch") || branchId.equals("bme"))){
            return false;
        }
        
        else if(seq.equals("000")){
            return false;
        }
        
        char arr[] = seq.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(!Character.isDigit(arr[i])){
                return false;
            }
        }
        
        return true;
    }
    
    
    public int getValidRegistrationsCountLE50Apr1(String[] registrations){
        int count = 0;
        for(int i = 0; i < registrations.length; i++){
            String str = registrations[i];
            if(isValid(str)){
                String sequence = str.substring(7 , 10);
                int num = Integer.parseInt(sequence);
                if(num <= 50 ){
                   count++;
                }
            }
        }
        System.out.println(System.nanoTime());
        return count;
    }
    
    
    public int getValidRegistrationsCountLE50Apr2(String[] registrations){
        int count = 0;
        for(int i = 0; i < registrations.length; i++){
            String str = registrations[i];
            if(isValid(str)){
                String s = str.substring(7 , 9);
                if( s.equals("00") || s.equals("01") || s.equals("02") || s.equals("03") || s.equals("04") ){
                   count++;
                }
                else if( str.substring(7 , 10).equals("050")){
                   count++;
                }
            }
        }
        System.out.println(System.nanoTime());
        return count;
    }
    
    
    public int getValidRegistrationsCountLE50Apr3(String[] registrations){
        int count = 0;
        for(int i = 0; i < registrations.length; i++){
            String str = registrations[i];
            if(isValid(str)){
            	
            	char a = str.charAt(7), b = str.charAt(8), c = str.charAt(9);
            	if(Character.digit(a , 10) != 0){
            		continue;
            	}
            	else if(Character.digit(b , 10) < 5 && Character.digit(c , 10) <= 9){
            		count++;
            	}
            	else if(Character.digit(b , 10) == 5 && Character.digit(c , 10) == 0){
            		count++;
            	}
            }
        }
        System.out.println(System.nanoTime());
        return count;
    }
    
    
    public int getValidRegistrationsCountLE50Apr4(String[] registrations){
        int count = 0;
        for(int i = 0; i < registrations.length; i++){
            String str = registrations[i];
            if(isValid(str)){
            	char a = str.charAt(7), b = str.charAt(8), c = str.charAt(9);
                int n = Character.getNumericValue(a) * 100 + Character.getNumericValue(b) * 10 + Character.getNumericValue(c);
                if(n <= 50){
                   count++;
                }
            }
        }
        System.out.println(System.nanoTime());
        return count;
    }
    
    
    public int getValidRegistrationsCountLE50Apr5(String[] registrations){
        int count = 0;
        for(int i = 0; i < registrations.length; i++){
            String str = registrations[i];
            if(isValid(str)){
            	String s = str.substring(7 , 10);
            	int h = s.hashCode();
            	
            	if( (h >= 47665 && h <= 47673) || (h >= 47695 && h <= 47704) || (h >= 47726 && h <= 47735) || (h >= 47757 && h <= 47766) ||
            	     (h >= 47788 && h <= 47797) || (h == 47819) ){
            	     	count++;
            	     } 
            }
        }
        System.out.println(System.nanoTime());
        return count;
    }
    
    public static String[] generate(int n) {
        String[] registration = new String[n];

        for (int i = 0; i < n; i++) {
            String y = generateYear();
            String b = generateBranch();
            String seq = generateSequence();

            registration[i] = y + b + seq;
        }

        return registration;
    }

    public static String generateYear() {
        long year = System.nanoTime() % 10000;
        return String.format("%04d", year);
    }

    public static String generateBranch() {
        char[] arr = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        long t = System.nanoTime();
        int i = (int)(t % 10);
        t += 13;
        int j = (int)(t % 10);
        t += 13;
        int k = (int)(t % 10);
        String a = String.valueOf(arr[i]);
        String b = String.valueOf(arr[j]);
        String c = String.valueOf(arr[k]);
        return a+b+c;
    }

    public static String generateSequence() {
        long sequence = System.nanoTime() % 10000;
        return String.format("%03d", sequence);
    }
    
    public static void main(String[] args) {
        String[] arr = generate(5000);
        SY2022bit058 s = new SY2022bit058();    

        
        long start1 = System.nanoTime();
        int approach1 = s.getValidRegistrationsCountLE50Apr1(arr);
        long end1 = System.nanoTime();
        long gap1 = end1 - start1;
        System.out.println("Time taken to run first approach : "+ gap1);
        System.out.println("valid Registration : "+ approach1);
        System.out.println("-------------------------------------------------------------------------------------");

        
        long start2 = System.nanoTime();
        int approach2 = s.getValidRegistrationsCountLE50Apr2(arr);
        long end2 = System.nanoTime();
        long gap2 = end2 - start2;
        System.out.println("Time taken to run first approach : "+ gap2);
        System.out.println("valid Registration : "+ approach2);
        System.out.println("-------------------------------------------------------------------------------------");
        
        long start3 = System.nanoTime();
        int approach3 = s.getValidRegistrationsCountLE50Apr3(arr);
        long end3 = System.nanoTime();
        long gap3 = end3 - start3;
        System.out.println("Time taken to run first approach : "+ gap3);
        System.out.println("valid Registration : "+ approach3);
        System.out.println("-------------------------------------------------------------------------------------");
	
	long start4 = System.nanoTime();
        int approach4= s.getValidRegistrationsCountLE50Apr4(arr);
        long end4 = System.nanoTime();
        long gap4 = end4 - start4;
        System.out.println("Time taken to run first approach : "+ gap4);
        System.out.println("valid Registration : "+ approach4);
        System.out.println("-------------------------------------------------------------------------------------");
        
        long start5 = System.nanoTime();
        int approach5 = s.getValidRegistrationsCountLE50Apr5(arr);
        long end5 = System.nanoTime();
        long gap5 = end5 - start5;
        System.out.println("Time taken to run first approach : "+ gap5);
        System.out.println("valid Registration : "+ approach5);
        System.out.println("-------------------------------------------------------------------------------------");
    }

}
