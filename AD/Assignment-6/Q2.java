import java.util.ArrayList;
import java.util.List;
public class Q2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(2);
        list.add(3);
        list.add(8);
        list.add(1);
        list.add(4);
        list.add(6);
        list.add(5);

        List<Integer> duplicates = findDuplicates(list);

        if (!duplicates.isEmpty()) {
            System.out.println("Duplicates in the list: " + duplicates);
        } else {
            System.out.println("No duplicates found.");
        }
    }
    public static List<Integer> findDuplicates(List<Integer> list) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j)) && !duplicates.contains(list.get(i))) {
                    duplicates.add(list.get(i));
                    break;
                }
            }
        }
        return duplicates;
    }
}
