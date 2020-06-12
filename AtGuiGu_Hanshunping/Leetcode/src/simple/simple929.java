package simple;

import java.util.HashMap;
import java.util.Map;

public class simple929 {
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        int i = numUniqueEmails(emails);
        System.out.println(i);
    }
    public static int numUniqueEmails(String[] emails) {
        Map<String,Integer> map = new HashMap<>();
        for (int i =0 ;i <emails.length;i++){
            String[] split = emails[i].split("@");
            String[] split1 = split[0].split("\\+");
            map.put(split1[0].replaceAll("\\.","")+"@"+split[1],0);
        }
        return map.size();
    }
}
