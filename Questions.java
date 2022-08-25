public class Questions {

        public static int Kadanes(int n[]){
            // approach to remove the maxsubarray sum
         int currsum = 0;
         int maxsum =Integer.MIN_VALUE;

         for(int i= 0; i<n.length; i++){
            currsum += n[i];
            if(currsum < 0){
                currsum = 0;
            }
            else{
                maxsum = Math.max(currsum, maxsum);
            }
         }
         return maxsum;

        }

        public static int rain_water_trapped(int height[]){
            int n = height.length;
            int lmax[] =new int[n];
            lmax[0] = height[0];
            for(int i= 0;i<n; i++){
                lmax[i] = Math.max(height[i], lmax[i-1]);
            }
            
            int rmax[] =new int[n];
            rmax[n-1]= height[n-1];
            for(int i = n-2; i>0; i--){
                rmax[i]= Math.max(height[i], rmax[i+1]);
            }

            int trapped_water = 0;
            int water_level = 0;

            for(int i =0;i<n; i++){
                water_level  = Math.min(rmax[i], lmax[i]);
                trapped_water += water_level -height[i]; 
            }
            return trapped_water;
        }



        public static boolean repeatedValues(int nums[]){
            
            boolean status = false;
          

            for(int i =0; i<nums.length; i++){
                
               for(int j = i+1; j<nums.length; j++){
                    if(nums[i] == nums[j]){
                        status = true;
                    }
               }
            }
           
            return status;
           
        }

        public static int find_target(int rotated[], int target){
            //applying binary search
            int s = 0; 
            int e = rotated.length-1;

            while(s<=e){
                int mid  = (s+e)/2;
                if(rotated[mid] == target ){
                    return mid;
                }else if(rotated[mid] < target){
                    s = mid+1;
                }else{
                    s=0;
                    e = mid-1;
                }
            }
            return -1;

        }

        
    

        public static void main(String args[]){
            // int height[] = {2,6,1,5,9,3};
            // System.out.println(Buy_sell_stocks(height));
            int n[] = {1,5,7,8,33};
            // System.out.println(repeatedValues(n));
            System.out.println(find_target(n, 7));
        }

}
