class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer>st = new HashSet<>();
        List<Integer>res = new ArrayList<>();
        for(int num:nums){
            if(st.contains(num)){
                res.add(num);
            }      
            else{
                st.add(num);
            }
        }
        return res;
        
    }
}
