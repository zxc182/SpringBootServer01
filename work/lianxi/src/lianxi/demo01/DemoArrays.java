package lianxi.demo01;

import java.util.Arrays;

/**
 * 数组
 */
public class DemoArrays {

    public static void main(String[] args) {
        //冒泡排序
        int[] intArr = {5652, 45, 1, 154, 48, 12};
        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr.length - 1; j++) {
                if (intArr[j] > intArr[j + 1]) {
                    int temp = intArr[j];
                    intArr[j] = intArr[j + 1];
                    intArr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(intArr));
        //数组复制
        int[] intArr2 = new int[5];
        System.arraycopy(intArr, 1, intArr2, 0, 4);//（）
        System.out.println(Arrays.toString(intArr2));
        //扩容
        int[] intArr3 = Arrays.copyOf(intArr, intArr.length + 1);
        System.out.println(Arrays.toString(intArr3));
    }
}
