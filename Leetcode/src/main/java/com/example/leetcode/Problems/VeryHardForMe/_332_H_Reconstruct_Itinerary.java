package com.example.leetcode.Problems.VeryHardForMe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _332_H_Reconstruct_Itinerary {

    public static void main(String[] args) {
//        System.out.println(findItinerary(new ArrayList<>(List.of(List.of("MUC","LHR"),List.of("JFK","MUC"),List.of("SFO","SJC"),List.of("LHR","SFO"))))); // ["JFK","MUC","LHR","SFO","SJC"]
//        System.out.println(findItinerary(new ArrayList<>(List.of(List.of("JFK","SFO"),List.of("JFK","ATL"),List.of("SFO","ATL"),List.of("ATL","JFK"),List.of("ATL","SFO"))))); //  ["JFK","ATL","JFK","SFO","ATL","SFO"]
        System.out.println(findItinerary(new ArrayList<>(List.of(List.of("JFK","KUL"),List.of("JFK","NRT"),List.of("NRT","JFK"))))); //  ["JFK","NRT","JFK","KUL"]
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        if (tickets.size() == 1)
            return tickets.get(0);

        List<String> result = new ArrayList<>();

        Map<String, List<String>> map = tickets.stream()
                .collect(Collectors.toMap(s -> s.get(0), list -> new ArrayList<>(List.of(list.get(1))), (o, o2) -> {
                    o.addAll(o2);
                    return o;
                }));

        List<String> to = map.get("JFK");
        result.add("JFK");
        tryToFind(to, result, map);
//        System.out.println();


//        System.out.println(map);

        return result;
    }

    //          ["JFK","ATL","JFK","SFO","ATL","SFO"]
    // result = ["JFK","ATL","JFK","SFO",
    // {ATL=[SFO], SFO=[ATL], JFK=[]}
    public static void tryToFind(List<String> to, List<String> result, Map<String, List<String>> map){
        if (to != null && !to.isEmpty()){
            String min = findMin(to, result, map);
            result.add(min);
            to.remove(min);
            to = map.get(min);
            tryToFind(to, result, map);
        }
    }

    public static String findMin(List<String> to, List<String> result, Map<String, List<String>> map){
        List<String> potentialTo = new ArrayList<>();
        String from = result.get(result.size()-1);
        for (String s: to){
            if (map.get(s) != null && map.get(s).contains(from)){
                potentialTo.add(s);
            }
        }
        String min;
        if (potentialTo.isEmpty())
            min = to.stream().min(String::compareTo).get();
        else min = potentialTo.stream().min(String::compareTo).get();
        return min;
    }

}
