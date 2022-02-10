package ByronProblems.DuckHunt;

public class DuckHunt {
    public int score(String[] ducksHit){
        if(ducksHit.length == 0) return 0;
        int[] duckValList = new int[ducksHit.length];
        int score = 0; 

        for(int i = 0; i < ducksHit.length; i++){
            String temp = ducksHit[i];
            try{
                int num = Integer.parseInt(ducksHit[i]);
                duckValList[i] = num;
            } catch(Exception e){
                if(temp == "X"){
                    if(i == 0){
                        duckValList[i] = 0;
                    }else if(i == 1){
                        int num1 = duckValList[0];
                        duckValList[i] = num1 + 0;
                    }else{

                    int prev1 = duckValList[i-1];
                    int prev2 = duckValList[i-2];
                    duckValList[i] = prev1 + prev2;
                    }
                }
                if(temp == "Z"){
                    if(i == 0) duckValList[i] = 0;
                    int prevt2 = duckValList[i-1] * 2;
                    duckValList[i] = prevt2;
                }
                if(temp == "Q"){
                    if(i == 0) duckValList[i] = 0;
                    int prev = duckValList[i-1];
                   int negNum = prev * -1;
                   duckValList[i] =  negNum;
                }
            }
        }
        /*
        FIRST TRY...But we can do better 
        for(int i = 0; i < ducksHit.length; i++){
            String tempVal = ducksHit[i];
            try{
                int num = Integer.parseInt(tempVal);
                score += num;
            } catch (NumberFormatException e){
                if(tempVal == "X"){
                    int prev1 = Integer.parseInt(ducksHit[i-1]);
                    int prev2 = Integer.parseInt(ducksHit[i-2]);
                    score = prev1 + prev2;
                }
                if(tempVal == "Z"){
                    int prevt2 = Integer.parseInt(ducksHit[i-1]) * 2;
                    score += prevt2;
                }
                if(tempVal == "Q"){
                    int prev = Integer.parseInt(ducksHit[i-1]);
                    score -= prev;
                }
            }
        }  
        */
        score = sumArray(duckValList);
        return score;
    }
    public int sumArray(int[] list){
        int sum = 0;
        for(int i = 0; i < list.length; i++){
            sum += list[i];
        }
        return sum;
    }


    public static void main(String[] args){
        String[] ducks = {"4","2","Q","5","X","2","Q","Z"};
                        //{4,2,-2,5,3,2,-2,-4}
        DuckHunt d1 = new DuckHunt();

        
        System.out.println(d1.score(ducks));
    }


}
