package onlinealgo;

/**
 * Created by eugene on 16/4/8.
 */
public class Solution1 {

    public static void main(String[] args) {
        System.out.println("*****RESULT*****");
        String S = "A2Le";
        String T = "2pL1";
        System.out.println(solution(S, T));
    }

    public static boolean solution(String S, String T) {
        int i=0, j=0;
        int sGap=0, tGap=0;
        for (i=0; i<S.length(); ){
            char s = S.charAt(i);
            char t = T.charAt(j);

            if (!isNum(s)){ //s为字母
                if (!isNum(t)){ //t为字母
                    if (tGap!=0){
                        i++; tGap--;
                        continue;
                    }
                    if (s==t) {
                        i++; j++;
                    } else return false;
                } else {    //t为数字
                    int jstart = j;
                    while (j+1<T.length() && isNum(T.charAt(j+1))){
                        j++;
                    }
                    j++;
                    tGap += Integer.valueOf(T.substring(jstart, j));
                }
            } else {    //s为数字
                int istart = i;
                while (i+1<S.length() && isNum(S.charAt(i+1))){
                    i++;
                }
                i++;
                sGap += Integer.valueOf(S.substring(istart, i));
                if (!isNum(t)){ //t为字母
                    if (sGap!=0){
                        j++; sGap--;
                        continue;
                    }
                    if (s==t){
                        i++; j++;
                    } else return false;
                } else {    //t为数字
                    int jstart = j;
                    while (j+1<T.length() && isNum(T.charAt(j+1))){
                        j++;
                    }
                    j++;
                    tGap += Integer.valueOf(T.substring(jstart, j));
                    if (sGap!=0){
                        if (sGap>tGap){
                            sGap -= tGap;
                            tGap = 0;
                        } else {
                            tGap -= sGap;
                            sGap = 0;
                        }
                    }
                }
            }
        }
        return true;
    }
    private static boolean isNum(char c){
        if ('0'<=c && c<='9') return true;
        else return false;
    }

}
