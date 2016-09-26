package leetcode161_170;

/**Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 Here is an example of version numbers ordering:
 0.1 < 1.1 < 1.2 < 13.37
 * Created by eugene on 16/3/17.
 */
public class CompareVersionNumbers {

    //简洁
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int len = Math.max(ver1.length, ver2.length);
        for (int i=0; i<len; i++) {
            Integer v1 = i < ver1.length ? Integer.parseInt(ver1[i]) : 0;
            Integer v2 = i < ver2.length ? Integer.parseInt(ver2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public int compareVersion1(String version1, String version2) {
        String[] ver1s = version1.split("\\.");
        String[] ver2s = version2.split("\\.");
        int len = Math.min(ver1s.length, ver2s.length);
        for (int i=0; i<len; i++){
            int v1 = Integer.valueOf(ver1s[i]);
            int v2 = Integer.valueOf(ver2s[i]);
            if (v1<v2) return -1;
            else if (v1>v2) return 1;
        }
        if (ver1s.length>ver2s.length) {
            for (int i=ver2s.length; i<ver1s.length; i++){
                if (Integer.valueOf(ver1s[i])>0) return 1;
            }
        } else if (ver1s.length<ver2s.length){
            for (int i=ver1s.length; i<ver2s.length; i++){
                if (Integer.valueOf(ver2s[i])>0) return -1;
            }
        }
        return 0;
    }

}
