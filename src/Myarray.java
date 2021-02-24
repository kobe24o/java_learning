import java.util.Arrays;

public class Myarray {
    public static void main(String[] args)
    {
        // 一维数组声明
        int arr1 [] = new int[3];
        int [] arr2 = {4,5,6};
        arr1[0] = 0;
        arr1[1] = 1;
        arr1[2] = 2;
        for(int i = 0; i < arr1.length; ++i) {
            System.out.println(arr1[i]);
            System.out.println(arr2[i]);
        }

        // API arraycopy
        int source [] = {1,2,3}, dest [] = {4,5,6,7};
        System.arraycopy(source, 1, dest, 2, 2);
        // 从source 的 pos 1 开始 拷贝到 dest 的 pos 2， 复制 len = 2 个
        for(int i : dest)
            System.out.println(i);// 4,5,2,3

        // sort
        Arrays.sort(dest);
        for(int i : dest)
            System.out.println(i);// 2,3,4,5

        // 二维数组
        int arr2d1 [][] = {{1,2},{3},{4,5}};//可以每行不一样长
        for(int i = 0; i <arr2d1.length; ++i)
        {
            for(int v : arr2d1[i])
                System.out.print(v);
            System.out.print("\n");
        }
        int [][] arr2d2 = new int [2][3];//2行3列
        for(int i = 0; i <arr2d2.length; ++i)
        {
            for(int v : arr2d2[i])
                System.out.print(v);
            System.out.print("\n");
        }

        // 多维数组
        int arr3d1 [][][] = {{{1,2},{3}},{{4,5},{6,7},{8}}};
        int [][][] arr3d2 = new int [2][3][4];
    }
}
