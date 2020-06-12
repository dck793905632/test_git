package jiuzhangsuanfa.towpoints;

public class Fanzhuan {
    /**
     * 三步翻转法
     * [4, 5, 1, 2, 3]->[5,4,1,2,3]->[5,4,3,2,1]->[1,2,3,4,5]
     * 描述
     * 中文
     * 英语
     * 给定旋转的排序数组，将其恢复到原位排序数组。（升序）
     *
     * 您是否在一次真实采访中遇到了这个问题？
     * 澄清度
     * 什么是旋转阵列？
     *
     * 例如，原始数组为[1,2,3,4]，其旋转数组可以为[1,2,3,4]，[2,3,4,1]，[3,4,1 ，2]，[4,1,2,3]
     * 例
     * 示例1：
     * [4, 5, 1, 2, 3] -> 示例2 [1, 2, 3, 4, 5]
     * ：
     * [6,8,9,1,2] ->[1,2,6,8,9]
     *
     * 挑战
     * 就地，O（1）个额外空间和O（n）时间。
     *
     *
     * **/
    //字符串
    public boolean rotateString(String A, String B) {
        int offest=0;

        char[] chars = B.toCharArray();
        for(int i=0;i<chars.length-1;i++){
            if(chars[i]+1!=chars[i+1]){
                offest=i;
                break;
            }
        }
        System.out.println(offest);
        reverse(chars,0,offest);
        System.out.println(String.valueOf(chars));
        reverse(chars,offest+1,chars.length-1);
        System.out.println(String.valueOf(chars));
        reverse(chars,0,chars.length-1);
        System.out.println(String.valueOf(chars));
        return A.equals(String.valueOf(chars));

    }

    public void reverse(char[] chars,int start,int end){
        for(int i=start,j=end;i<j;i++,j--){
            char temp =chars[i];
            chars[i]=chars[j];
            chars[j]=temp;
        }
    }
}
