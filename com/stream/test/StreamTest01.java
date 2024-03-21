import java.util.List;

/**
 *
 * @author liuhongxu2000
 * @date 2024/3/19
 */
public class StreamTest01 {
    public static void main(String[] args) {
        List<String> list = List.of("l", "i", "u", "h","o","n","g");
        for (String s : list) {
            System.out.println("s = " + s);
        }
        //不可改
        list.set(0, "a");
        //不可增
        list.add(0, "a");
        //不可删
        list.remove(0);
    }
}
