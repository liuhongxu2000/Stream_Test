import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 *
 * @author liuhongxu2000
 * @date 2024/3/19
 */
public class StreamTest02 {
    public static void main(String[] args) {

/*
    单列集合        default stream<E> stream()                             Collection中的默认方法
    双列集合        无                                                     无法直接使用stream流
    数组           public static<T>Stream<T> stream(T[] array)            Arrays工具类中的静态方法
    一堆零散数据     public static<T>stream<T> of(T... values)               stream接口中的静态方法
*/

        ArrayList<Object> list = new ArrayList<>();
        Collections.addAll(list,"a","b","c","d","e");
        list.stream().forEach(s-> System.out.println(s+" "));
        System.out.println("-------------------------------------------------------------");


        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("liu",2000);
        hashMap.put("hong",05);
        hashMap.put("xu",19);

        //通过keyset获取stream
        hashMap.keySet().stream().forEach(s -> System.out.println(s));
        System.out.println("-------------------------------------------------------------");

        //通过entryset() 获取stream
        hashMap.entrySet().stream().forEach(stringIntegerEntry-> System.out.println(stringIntegerEntry));
        System.out.println("-------------------------------------------------------------");

        //注意:
        //stream接口中静态方法of的细节
        //方法的形参是一个可变参数，可以传递一堆零散的数据，也可以传递数组
        //但是数组必须是引用数据类型的，如果传递基本数据类型，是会把整个数组当做一个元素，放到stream当中。
        String[] arrString = {"a","b","c"};
        Stream.of(arrString).forEach(as -> System.out.println(as));
        System.out.println("-------------------------------------------------------------");


        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "a-10", "b-20", "c-30", "d-40", "e-50");
        list1.stream()
                .map(sTi -> Integer.parseInt(sTi.split("-")[1]))
                .forEach(sTi -> System.out.println(sTi));
        System.out.println("-------------------------------------------------------------");
    }
}
