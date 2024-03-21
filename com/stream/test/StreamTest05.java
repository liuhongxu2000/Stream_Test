import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream
 *
 * @Author liuhongxu2000
 * @date 2024/3/19
 **/
public class StreamTest05 {
    public static void main(String[] args) {

//        //test_01
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        Collections.addAll(arrayList,1,2,3,4,5,6,7,8,9,10);
//        List<Integer> collect = arrayList.stream().filter(s -> s % 2 == 0).collect(Collectors.toList());
//        System.out.println("collect = " + collect);

//        //test_02
//        ArrayList<String> arrayList = new ArrayList<>();
//        Collections.addAll(arrayList,"zhang,23","lisi,24","wangwu,25");
//        Map<String, String> collect = arrayList.stream()
//                .filter(s -> Integer.parseInt(s.split(",")[1]) >= 24)
//                .collect(Collectors.toMap(s -> s.split(",")[0], s -> s.split(",")[1]));
//        System.out.println("collect = " + collect);

        //test_03
        ArrayList<String> array1 = new ArrayList<>();
        ArrayList<String> array2 = new ArrayList<>();
        Collections.addAll(array1, "张三,21", "李四,23", "张无忌,24", "谢广坤,25", "张翠山,26", "王二麻子,27");
        Collections.addAll(array2, "杨四,14", "杨武第,16", "赵高,17", "玛丽莲梦,45", "杨婆,66", "迪丽热巴,16");

        Stream<String> nan = array1.stream()
                .filter(s -> (s.split(",")[0])
                .length() == 3).limit(2);


        Stream<String> nv = array2.stream()
                .filter(s -> s.split(",")[0]
                .startsWith("杨")).skip(1);



    }
}
