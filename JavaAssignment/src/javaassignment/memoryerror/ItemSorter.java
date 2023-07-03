
package javaassignment.memoryerror;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ItemSorter {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("A", "X", 10.0));
        items.add(new Item("B", "Y", 11.0));
        items.add(new Item("C", "Z", 12.0));
        items.add(new Item("E", "K", 10.0));
        items.add(new Item("F", "R", 11.0));
        items.add(new Item("D", "S", 12.0));
        System.out.println(items);
        List<Item> naturallySortedList = sortByCategory(items);
        System.out.println("Sorted with category");
        naturallySortedList.forEach(x->System.out.println(x.getCategory()));
        List<Item> explicitlySortedList = sorteByPriceAndName(items);
        explicitlySortedList.forEach(x->System.out.println(x.getName() + " And "+x.getPrice()));
        
    }

    private static List<Item> sortByCategory(ArrayList<Item> items) {
        List<Item> sortedList = items.stream()
                .sorted(Comparator.comparing(Item::getCategory, Comparator.naturalOrder())).collect(Collectors.toList());
        return sortedList;
                

    }

    private static List<Item> sorteByPriceAndName(ArrayList<Item> items) {
         List<Item> sortedList = items.stream()
                .sorted(Comparator.comparing(Item::getPrice).thenComparing(Item::getName)).collect(Collectors.toList());
        return sortedList;
    }
    
}
