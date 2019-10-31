package lianxi.demo01;

import java.io.File;

/**
 *
 */
public class DemoAPI {
    public static void main(String[] args) {
        // indexof
      /*  String str = "thank you";
        int row = str.indexOf("y");
        int row2 = str.lastIndexOf("y");
        System.out.println(row);
        //charAt
        String str2 =  "上海自来水来自海上";
        for (int i = 0 ; i < str2.length(); i++){
            char start = str2.charAt(i);
            char end = str2.charAt(str2.length()-1-i);
            if(start != end){
                System.out.print("不");
                break;
            }
        }
        System.out.println("是回文");

        String str3 = "&nbsp;等级的佛&dkj;";
        System.out.println(str3.matches(""));*/

        File file = new File("./src/main/java/demo01/DemoArrays.java");
        System.out.println(file);
        System.out.println(file.isFile());
        System.out.println(row(100));

        "".equals("");
    }

    public static int row(int a) {
        int sum = 0;
       if( a == 1){
           return 1;
       }else{
           return sum = row(a-1)+a;
       }
    }
}
