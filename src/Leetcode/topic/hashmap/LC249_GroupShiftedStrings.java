package Leetcode.topic.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC249_GroupShiftedStrings {
    public static void main(String[] args) {
        /*new LC249_GroupShiftedStrings().groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z",
                "mike"})
                .forEach(k-> System.out.println(k));*/
        new LC249_GroupShiftedStrings().groupStrings(new String[]{"aa", "bb", "b"})
                .forEach(k-> System.out.println(k));
    }
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String,List<String>> strMap = new HashMap<>();
        for (String str : strings)
        {
            String key = getKey(str);
            if (strMap.containsKey(key))
                strMap.get(key).add(str);
            else
            {
                List list = new ArrayList<>();
                list.add(str);
                strMap.put(key, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        strMap.forEach((key, value) -> System.out.println(key + ":" + value));

        res.addAll(strMap.values());
        return res;
    }
    public String getKey(String str)
    {
        if (str.charAt(0) == 'a')
            return str;
        int diff = str.charAt(0)-'a';

        StringBuilder sb = new StringBuilder();
        sb.append('a');
        for ( int i=1;i<str.length();i++)
        {
            char c =  (char) (str.charAt(i) - diff);
            if ( c< 'a')
                sb.append((char)(c+26));
            else
                sb.append(c);
            //else
              //  sb.append( (char)(c- 'z'+'a'-1));
        }
        return sb.toString();
    }
}
