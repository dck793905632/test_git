package xuefenji;

import java.util.Arrays;

public class Avg {
    public static void main(String[] args) {
        //int[] kecheng = {87,83,86,81,100,83,85,86,88,97,95,87,85,97,84};
        int[] kecheng = {86,75,90,87,76,70,86,80,93,70,83,80,81,87,87,73,89};
        //float[] xuefen = {1,1,2,1,2,2,2,2,2,2, (float) 1.5,2, (float) 1.5,1, (float) 1.5};
        float[] xuefen = {1,1,1,2,1,2,2,2,2,2, 2,2,2, (float) 1.5, (float) 1.5, (float) 1.5, (float) 1.5};
        System.out.println(kecheng.length==xuefen.length);
        float[] jidian=new float[kecheng.length];
        for (int i = 0; i < kecheng.length; i++) {
            if(kecheng[i]>=80 && kecheng[i]<=84.9){
                jidian[i]= (float) 3.0;
            }else if(kecheng[i]>=85 && kecheng[i]<=89.9){
                jidian[i]= (float) 3.5;
            }else if(kecheng[i]>=90 && kecheng[i]<=94.9){
                jidian[i]= (float) 4.0;
            }else if(kecheng[i]>=95 && kecheng[i]<=100){
                jidian[i]= (float) 4.5;
            }else if(kecheng[i]>=75 && kecheng[i]<=79.9){
                jidian[i]= (float) 2.5;
            }else if(kecheng[i]>=70 && kecheng[i]<=74.9){
                jidian[i]= (float) 2.0;
            }
        }
        System.out.println(Arrays.toString(kecheng));
        System.out.println(Arrays.toString(jidian));
        float avg =0;
        float f1=0;
        float f2=0;
        for (int i = 0; i < kecheng.length; i++) {
            f1+=jidian[i]*xuefen[i];
            f2+=xuefen[i];
        }
        avg=f1/f2;
        System.out.println(avg);
    }
}
