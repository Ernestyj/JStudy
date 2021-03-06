package leetcode11_20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**Given a digit string, return all possible letter combinations that the number could represent.
 A mapping of digit to letters (just like on the telephone buttons) is given below.
 https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note: Although the above answer is in lexicographical order, your answer could be in any order you want.
 * Created by eugene on 16/6/1.
 */
public class LetterCombinationsOfPhoneNumber {

    static String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    //简洁, 广度(队列) https://leetcode.com/discuss/24431/my-java-solution-with-fifo-queue
    public List<String> letterCombinations(String digits) {
        LinkedList<String> q = new LinkedList<>();
        if (digits==null || digits.length()==0) return q;
        q.add("");
        for(int i=0; i<digits.length(); i++){
            int k = Character.getNumericValue(digits.charAt(i));
            while(q.peek().length()==i){
                String old = q.remove();
                for(char c : mapping[k].toCharArray())
                    q.offer(old+c);
            }
        }
        return q;
    }

    //易于理解(速度稍微更快),广度
    public List<String> letterCombinations1(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits==null || digits.length()==0) return result;
        result.add("");
        for (int i=0; i<digits.length(); i++){
            String strs = mapping[Character.getNumericValue(digits.charAt(i))];
            result = combine(result, strs);
        }
        return result;
    }
    private ArrayList<String> combine(List<String> list, String strs){
        ArrayList<String> result = new ArrayList<>();
        for (int i=0; i<list.size(); i++){
            for (int j=0; j<strs.length(); j++){
                result.add(list.get(i)+strs.charAt(j));
            }
        }
        return result;
    }

}
