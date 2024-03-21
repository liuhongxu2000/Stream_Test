import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Stream
 *
 * @Author liuhongxu2000
 * @date 2024/3/19
 **/
public class StreamTest04 {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList,"张无忌-男-15","周芷若-女-14","赵敏-女-13",
        "张强-男-20","张三丰-男-100","张翠山-男-40","张良-男-35","王二麻子-男-37","谢广坤-男-41");

        //收集到Collectors.toList()  list 当中不会去除重复数据
        Collection<String> collect = arrayList.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
        System.out.println("-------------------------------------------------------------");

        //收集到Collectors.toSet()  hashset当中会去除重复数据
        Collection<String> collect1 = arrayList.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toSet());
        System.out.println("collect1 = " + collect1);
        System.out.println("-------------------------------------------------------------");

       /* 参数一:
            Function泛型一:表示流中每一个数据的类型
                    泛型二:表示Map集合中键的数据类型
            方法apply形参:依次表示流里面的每一个数据
            方法体:生成键的代码
            返回值:已经生成的键
        参数二:
            Function泛型一:表示流中每一个数据的类型
                    泛型二:表示Map集合中值的数据类型
            方法apply形参:依次表示流里面的每一个数据
            方法体:生成值的代码
            返回值:已经生成的值
            */
        //收集到Collectors.toMap  map里面键不允许重复，方法体内，前后为生成键和值的方式
        Map<String, Integer> collect2 = arrayList.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.split("-")[0];//名字为键
                    }
                }, new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s.split("-")[2]);//年龄为值
                    }
                }));
        System.out.println("collect2 = " + collect2);
        System.out.println("-------------------------------------------------------------");

        //lambda 表达式满足map键值对生成关系
        Map<String, String> collect3 = arrayList.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(s -> s.split("-")[0], s -> s.split("-")[2]));
        System.out.println("collect3 = " + collect3);
        System.out.println("-------------------------------------------------------------");

    }
}
