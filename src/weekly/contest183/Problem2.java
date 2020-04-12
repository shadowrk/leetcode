package weekly.contest183;

public class Problem2 {

    public int numSteps(String s) {
        int step = 0;
        while(!s.equals("1")){
            if(s.charAt(s.length()-1) == '0'){
                s = s.substring(0, s.length()-1);
            }else{
                s = add(s);
                
            }
            step++;
        }
        

        return step;

    }

    private String add(String s) {
        StringBuilder str = new StringBuilder();
        int flag = 1;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == '1' && flag == 1){
                str.insert(0, "0");
                flag = 1;
            }else if(s.charAt(i) == '1' && flag == 0){
                str.insert(0, "1");
                flag = 0;
            }else if(s.charAt(i) == '0' && flag == 1){
                str.insert(0, "1");
                flag = 0; 
            }else{
                str.insert(0, "0");
                flag = 0;
            }

        }
        if(flag == 1){
            str.insert(0, "1");
            flag = 0;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Problem2 p = new Problem2();
        System.out.println(p.numSteps("1101"));
        
    }


}