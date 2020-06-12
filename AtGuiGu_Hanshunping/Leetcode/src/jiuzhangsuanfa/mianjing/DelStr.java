package jiuzhangsuanfa.mianjing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DelStr {
    @Test
    public void test(){
        List<String> list = new ArrayList<>();
        list.add("1_dasd");
        list.add("dasd");
        list.add("dasd");
        list.add("1_dasd");
        System.out.println(del(list));
    }

    //间断数

    //删除字符串
    public List<String> del(List<String> list){
        List<String> res = new ArrayList<>();
        for(String str : list){
            if(!str.substring(0,2).equals("1_")){
                res.add(str);
            }
        }
        return res;
    }
}
