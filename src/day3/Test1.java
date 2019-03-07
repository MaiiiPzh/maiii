package day3;

import java.util.Arrays;

/**
 * Copyright (c),2016-2019,北京金地安华有限公司成都分公司
 * ClassName   :  Test1
 * Author      : MaMingze
 * Date        : 2019/3/6 16:23
 * Description : TODO
 * Version 1.0
 **/
public class Test1 {
    public static void main(String[] args){
       int num[]=new int[]{1,2,44,342,234,4,5,66,6344,2};
       //利用这个函数办法可以简单的对数组里面的数字进行排序
        /*Arrays.sort(num);
        for (int i:
             num) {
         System.out.println(i);
        }*/
        Test1 t=new Test1();
        t.aa123(num,666);
    }
/**
  * 功能描述:利用二分排序来对数组进行排序
  *  <>
  *  @param  : [num, count]
  *  @return : int[]
  *  @Author : MaMingze
  *  @Date   :  2019/3/6 16:40
  */
   private int[] aa123(int[] num,int count){
         Arrays.sort(num);
       //利用二分和的方式来对现有的值进行查找，判断这个集合里面有没有两个数加起来等于所需要的数字
         int left=0;
       int right=num.length-1;
       while (right>left) {
           if (num[right] + num[left] < count) {
                left++;
           }else if(num[right] + num[left] > count){
               right--;
           }else {
               System.out.println("有这样的数字第一个是"+num[left]+"第二个是"+num[right]+"和为"+count);
               return num;
           }

       }
       System.out.println("没有这样的数");
       return num;
   }

}
