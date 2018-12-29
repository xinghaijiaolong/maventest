package com.sr;

public class Test {
    public static void main(String[] args) {
//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 13};
//        System.out.print("元素位置为： " + middleSearch(array, 11));

    }

    //二分法查询
    public static int middleSearch(int[] array, int x) {
        int low = 0, high = array.length - 1;
        //三种情况的判定
        while (low <= high) {
            int mid = (low + high) / 2;
            if (x < array[mid]) {
                high = mid - 1;
            } else if (x > array[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //冒泡排序法
    public static void order() {
        int arr[] = {1, 6, 0, -1, 9};
        int temp = 0;//中间值
        //-------冒泡排序法
        //外层循环,它决定一共走几趟
        for (int i = 0; i < arr.length - 1; i++) {
            //内层循环,开始逐个比较
            //如果我们发现前一个数比后一个数大,则交换
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //换位
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
        //输出结果
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }

    //选择
    public static void selectSort(int[] arr) {
        /*
         * 同理两个for循环，外面的for是几轮，因为最后一个不需要比较，所以是长度的m-1轮
         * 里面的for是指每一轮比较的过程，一个就是起始位随着轮数后移，另外比较的次数也随着减少
         * 规律同冒泡
         */
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }

        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    //快速排序

    public static void quickSort(int[] arr, int low, int high) {
        int l = low;
        int h = high;
        //基数
        int povit = arr[low];
        //一趟快速排序，即l = h，这时povit的位置就固定了，左边都是小于它的值，右边都是大于它的值。
        while (l < h) {
            //从右边开始，通过高位角标h的自减，从最右位向低位逐一取出数组中的值。l < h排除了l=h情况
            while (povit < arr[h] && l < h) {
                h--;
            }
            //如果上面的循环结束，且l != h，说明右边出现小于povit元素，需要互换位置
            if (l < h) {
                swap(arr, l, h);
                l++;//从后一位开始读取数组
            }
            //从左边开始，通过低位角标l的自增，从最左边向高位逐一取出数值中的值。
            while (povit > arr[l] && l < h) {
                l++;
            }
            //如果上面的循环结束，且l != h，说明左边出现大于povit元素，需要互换位置
            if (l < h) {
                swap(arr, l, h);
                h++;
            }
            //向下继续最外面的while循环，直到l = h
        }
        //递归，povit左边继续调用quickSort
        if (l > low) quickSort(arr, low, l - 1);
        //递归，povit右边继续调用quickSort
        if (h < high) quickSort(arr, l + 1, high);

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
