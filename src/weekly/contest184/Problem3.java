package weekly.contest184;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {
    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        for(Map.Entry<String, String> entry : map.entrySet()){
            text = text.replaceAll(entry.getKey(), entry.getValue());
        }


        return text;
    }

    public static void main(String[] args) {
        Problem3 p = new Problem3();
        System.out.println(p.entityParser("and I quote: &quot;...&quot;"));
    }
}
