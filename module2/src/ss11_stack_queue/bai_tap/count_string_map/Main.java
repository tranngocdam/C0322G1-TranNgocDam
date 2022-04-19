package ss11_stack_queue.bai_tap.count_string_map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<String, Integer> map=new TreeMap<>();
        String string="Tôi yêu Việt Nam yêu con người Việt Nam";
        String[] str=string.toLowerCase().split(" ");
        for (String stri: str) {
            if(map.containsKey(stri)){
                map.put(stri, map.get(stri)+1);
            }else {
                map.put(stri, 1);
            }
        }
        Set<String>set=map.keySet();
        for (String s:set) {
            System.out.println(s+" "+map.get(s));
        }
    }
}
