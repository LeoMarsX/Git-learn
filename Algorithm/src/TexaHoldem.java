import java.util.Arrays;

public class TexaHoldem {
    private int[] blackDigit=new int[5];
    private int[] whiteDigit=new int[5];
    private char[] blackColor=new char[5];
    private char[] whiteColor=new char[5];
    public TexaHoldem(String a,String b){
        char[] black = a.toCharArray();
        char[] white = b.toCharArray();
        int j = 0, k =  0;
        for (int i = 0; i < black.length; i++) { // 提取花色和数值
            if (i % 2 == 0) {
                if(black[i] == 'T')
                    blackDigit[j] = 10;
                if(white[i] == 'T')
                    whiteDigit[j] = 10;
                if(black[i] == 'J')
                    blackDigit[j] = 11;
                if(white[i] == 'J')
                    whiteDigit[j] = 11;
                if(black[i] == 'Q')
                    blackDigit[j] = 12;
                if(white[i] == 'Q')
                    whiteDigit[j] = 12;
                if(black[i] == 'K')
                    blackDigit[j] = 13;
                if(white[i] == 'K')
                    whiteDigit[j] = 13;
                if(black[i] == 'A')
                    blackDigit[j] = 14;
                if(white[i] == 'A')
                    whiteDigit[j] = 14;
                if(black[i] <= '9' && black[i] >='0')
                    blackDigit[j] = black[i] - '0';
                if(white[i] <= '9' && white[i] >='0')
                    whiteDigit[j] = white[i] - '0';
                j++;
            }
            else {
                blackColor[k] = black[i];
                whiteColor[k] = white[i];
                k++;
            }
        }
        Arrays.sort(blackDigit); //排序后很方便比较
        Arrays.sort(whiteDigit);
    }
    public int digitCompare(){
        for(int i=5;i>0;i--){
            if(blackDigit[i]==whiteDigit[i]){
                i--;
                if(i==0){
                    return 3;
                }
            }
            else if(blackDigit[i]>whiteDigit[i]){
                return 1;
            }
            else if(blackDigit[i]<whiteDigit[i]){
                return 2;
            }
        }
        return 4; //impossible
    }
    public boolean isRoyalFlush(int[]digit,char[]color){ //皇家同花顺
        if(digit[0]==10){
            for (int i = 1; i < digit.length; i++) {

                if (digit[i] - digit[i-1] != 1)
                    return false;

            }
            for (int i = 1; i < color.length; i++) {
                if (color[i] != color[i-1])
                    return false;
            }
            return true;
        }
        else {
            return false;
        }



    }
    public boolean isStraightFlush(int[]digit,char[]color){  //同花顺
        for (int i = 1; i < digit.length; i++) {

            if (digit[i] - digit[i-1] != 1)
                return false;

        }
        for (int i = 1; i < color.length; i++) {
            if (color[i] != color[i-1])
                return false;
        }
        return true;
    }

    public boolean isFourofaKind(int[]digit){  //四条
        if(digit[0]!=digit[1]){
            for(int i=2;i<digit.length;i++){
                if(digit[i]!=digit[i-1]){
                    return false;
                }
            }
            return true;
        }
        else {
            for(int i=2;i<digit.length-1;i++){
                if(digit[i]!=digit[i-1]){
                    return false;
                }
            }
            return true;
        }
    }

    public boolean isFlush(char[] color) {   // 同花
        for (int i = 1; i < color.length; i++) {
            if (color[i] != color[i-1])
                return false;
        }
        return true;
    }

    public boolean isStraight(int[] digit) { // 顺子
        for (int i = 1; i < digit.length; i++) {
            if (digit[i] - digit[i-1] != 1) return false;
        }
        return true;
    }

    public boolean isThreeofaKind(int[] digit) { //三条
        int[] judge = new int[15];
        for (int i = 0; i < digit.length; i++) {
            judge[digit[i]]++;
            if (judge[digit[i]] == 3)
                return true;
        }
        return false;
    }

    public boolean isTwoPair(int[] digit) {  // 两对
        int[] judge = new int[15];
        int flag = 0;
        for (int i = 0; i < digit.length; i++) {
            judge[digit[i]]++;
            if (judge[digit[i]] == 2)
                flag++;
            if (flag == 2)
                return true;
        }
        return false;
    }
    public boolean isOnePair(int[] digit ) { //一对
        int[] judge = new int[15];
        for (int i = 0; i < digit.length; i++) {
            judge[digit[i]]++;
            if (judge[digit[i]] == 2)
                return true;
        }
        return false;
    }








    public String compare(){
        if(isRoyalFlush(blackDigit,blackColor)){
            if(!isRoyalFlush(blackDigit,blackColor)){
                return "BlackWin";
            }
            else{
                return "Tie";
            }
        }
        else if(isRoyalFlush(whiteDigit,whiteColor)){
            return "WhiteWin";
        }
        else if(isStraightFlush(blackDigit,blackColor)){
            if(!isStraightFlush(whiteDigit,whiteColor)){
                return "BlackWin";
            }
            else{
                if(digitCompare()==1){
                    return "BlackWin";
                }
                else if(digitCompare()==2){
                    return "WhiteWin";
                }
                else{
                    return "Tie";
                }
            }
        }
        else if(isStraightFlush(whiteDigit,whiteColor)){
            return "WhiteWin";
        }
        else if(isFourofaKind(blackDigit)){
            if(!isFourofaKind(whiteDigit)){
                return "BlackWin";
            }
            else{
                int black,white;
                if(blackDigit[0]!=blackDigit[1]){
                    black=blackDigit[1];
                }
                else{
                    black=blackDigit[0];
                }
                if(whiteDigit[0]!=whiteDigit[1]){
                    white=whiteDigit[1];
                }
                else{
                    white=whiteDigit[0];
                }
                if(black>white){
                    return "BlackWin";
                }
                else if(black==white){
                    return "Tie";
                }
                else if(black<white){
                    return "WhiteWin";
                }
            }
        }
        else if(isFourofaKind(whiteDigit)){
            return "WhiteWin";
        }
        else if(isFlush(blackColor)){
            if(!isFlush(whiteColor)){
                return "BlackWin";
            }
            else {
                return "Tie";
            }
        }
        else if(isFlush(whiteColor)){
            return "WhiteWin";
        }
        else if(isStraight(blackDigit)){
            if(!isStraight(whiteDigit)){
                return "BlackWin";
            }
            else{
                if(digitCompare()==1){
                    return "BlackWin";
                }
                else if(digitCompare()==2){
                    return "WhiteWin";
                }
                else{
                    return "Tie";
                }
            }
        }
        else if(isStraight(whiteDigit)){
            return "WhiteWin";
        }
        else if(isThreeofaKind(blackDigit)){
            if(!isThreeofaKind(whiteDigit)){
                return "BlackWin";
            }
            else{
                int []judge1=new int[15];
                int []judge2=new int[15];
                int black = 0,white=0;
                for(int i=0;i<blackDigit.length;i++){
                    judge1[blackDigit[i]]++;
                    judge2[whiteDigit[i]]++;
                    if(judge1[blackDigit[i]]==3){
                        black=blackDigit[i];
                    }
                    if (judge2[whiteDigit[i]]==3){
                        white=whiteDigit[i];
                    }


                }
                if(black>white){
                    return "BlackWin";
                }
                else if(black==white){
                    return "Tie";
                }
                else if(black<white){
                    return "WhiteWin";
                }
            }
        }
        else if(isThreeofaKind(whiteDigit)){
            return "WhiteWin";
        }
        else if(isTwoPair(blackDigit)){
            if(!isTwoPair(whiteDigit)){
                return "BlackWin";
            }
            else{
                int []judge1=new int[15];
                int []judge2=new int[15];
                int []black=new int[2];
                int []white=new int[2];
                int j=0,k=0;
                for(int i=0;i<blackDigit.length;i++){
                    judge1[blackDigit[i]]++;
                    judge2[whiteDigit[i]]++;
                    if(judge1[blackDigit[i]]==3){
                        black[j]=blackDigit[i];
                        j++;
                    }
                    if (judge2[whiteDigit[i]]==3){
                        white[k]=whiteDigit[i];
                        k++;
                    }


                }
                Arrays.sort(black);
                Arrays.sort(white);
                if(black[1]>white[1]){
                    return "BlackWin";
                }
                else if(black[1]==white[1]){
                    if(black[0]>white[0]){
                        return "BlackWin";
                    }
                    else if(black[0]==white[0]){
                        return "Tie";
                    }
                    else if(black[0]<white[0]){
                        return "WhiteWin";
                    }

                }
                else if(black[1]<white[1]){
                    return "WhiteWin";
                }

            }
        }
        else if(isTwoPair(whiteDigit)){
            return "WhiteWin";
        }
        else if(isOnePair(blackDigit)){
            if(!isOnePair(whiteDigit)){
                return "BlackWin";
            }
            else{
                int []judge1=new int[15];
                int []judge2=new int[15];
                int black = 0,white=0;
                for(int i=0;i<blackDigit.length;i++){
                    judge1[blackDigit[i]]++;
                    judge2[whiteDigit[i]]++;
                    if(judge1[blackDigit[i]]==2){
                        black=blackDigit[i];
                    }
                    if (judge2[whiteDigit[i]]==2){
                        white=whiteDigit[i];
                    }


                }
                if(black>white){
                    return "BlackWin";
                }
                else if(black==white){
                    return "Tie";
                }
                else if(black<white){
                    return "WhiteWin";
                }

            }
        }
        else if(isOnePair(whiteDigit)){
            return "WhiteWin";
        }
        else{
            if(digitCompare()==1){
                return "BlackWin";
            }
            else if(digitCompare()==2){
                return "WhiteWin";
            }
            else{
                return "Tie";
            }
        }
        return "Test";

    }



}
