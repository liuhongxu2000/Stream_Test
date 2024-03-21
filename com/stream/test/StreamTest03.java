import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;

/**
 * Stream
 *
 * @Author liuhongxu2000
 * @date 2024/3/19
 **/
public class StreamTest03 {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"a-10", "b-20", "c-30", "d-40", "e-50");

        //toArray   无参方法
        Object[] array = list.toArray();
        System.out.println("array = " + Arrays.toString(array));
        System.out.println("-------------------------------------------------------------");


        //IntFunction的泛型:具体类型的数组
        //apply的形参:流中数据的个数，要跟数组的长度保持一致
        //apply的返回值:具体类型的数组
        //方法体:就是创建数组
        String[] arr = list.stream().toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("-------------------------------------------------------------");

        //toArray方法的参数的作用:负责创建一个指定类型的数组
        //toArray方法的底层，会依次得到流里面的每一个数据，并把数据放到数组当中
        //toArray方法的返回值:是一个装着流里面所有数据的数组
        list.stream().toArray(value -> new String[value]);
        System.out.println("-------------------------------------------------------------");
    }
}
