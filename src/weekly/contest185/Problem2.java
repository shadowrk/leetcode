package weekly.contest185;

import java.util.*;

public class Problem2 {

    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer, HashMap<String, Integer>> orderMap = new HashMap<>();
        for (List<String> order : orders) {
            int tableId = Integer.parseInt(order.get(1));
            if(orderMap.containsKey(tableId)){
                HashMap<String, Integer> temp = orderMap.get(tableId);
                if(temp.containsKey(order.get(2))){
                    temp.put(order.get(2), temp.get(order.get(2))+1);
                }else{
                    temp.put(order.get(2), 1);
                }
            }
            else{
                HashMap<String, Integer> temp = new HashMap<>();
                temp.put(order.get(2), 1);
                orderMap.put(tableId, temp);
            }
        }
        Set<Integer> tableIdsSet = orderMap.keySet();
        ArrayList<Integer> tableIds = new ArrayList<>(tableIdsSet);
        Collections.sort(tableIds);
        Set<String> headerSet = new HashSet<>();

        for (Integer tableId : tableIds) {
            HashMap<String, Integer> temp = orderMap.get(tableId);
            temp.keySet().forEach(i -> headerSet.add(i));
        }
        List<List<String>> result = new ArrayList<>();
        ArrayList<String> header = new ArrayList<>(headerSet);
        Collections.sort(header);
        header.add(0, "Table");
        result.add(header);
        for (Integer tableId : tableIds) {
            HashMap<String, Integer> temp = orderMap.get(tableId);
            List<String> col = new ArrayList<>();
            for (String item : header) {
                if(item.equals("Table")){
                   col.add(String.valueOf(tableId));
                }else{
                    if(temp.keySet().contains(item)){
                        col.add(String.valueOf(temp.get(item)));
                    }else{
                        col.add(String.valueOf(0));
                    }
                }
            }
            result.add(col);
        }

        return result;

    }
}
