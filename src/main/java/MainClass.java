import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {
        Map<Integer,Long> map1;
        Map<Integer,Long> map2;
        


        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();



        list1.add(2);
        list1.add(1);list1.add(1);list1.add(1);list1.add(1);list1.add(1);list1.add(1);list1.add(1);list1.add(1);list1.add(2);list1.add(6);list1.add(8);list1.add(9);list1.add(9);list1.add(9);list1.add(22);list1.add(43);list1.add(23);list1.add(6);


        list2.add(5);
        list2.add(4);list2.add(6);list2.add(8);list2.add(2);list2.add(2);list2.add(2);list2.add(2);list2.add(2);list2.add(2);list2.add(2);list2.add(2);list2.add(2);list2.add(9);list2.add(9);list2.add(9);list2.add(53);list2.add(8);list2.add(2);list2.add(2);


        long startTime = System.currentTimeMillis();

        map1=list1.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));


        map2=list2.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        map1.entrySet().forEach(System.out::println);
        System.out.println(".....................");
        map2.entrySet().forEach(System.out::println);

        Map<Integer,Long> map3=new HashMap<>();

        map1.entrySet().stream().filter(i->map2.containsKey(i.getKey())).map(
                i->{
                    if(i.getValue()>map2.get(i.getKey())){
                        return map3.put(i.getKey(),map2.get(i.getKey()));
                    }
                    else{
                        return map3.put(i.getKey(),i.getValue());
                    }
                }
        ).forEach(System.out::println);
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        map3.entrySet().forEach(System.out::println);
        System.out.println(totalTime);

    }
}
