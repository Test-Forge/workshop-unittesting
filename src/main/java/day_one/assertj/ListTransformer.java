package day_one.assertj;

import java.util.List;

public class ListTransformer {

    public List<Item> containsLetter(CharSequence letter, List<Item> list) {
        return list.stream()
                .filter(item -> item.getDescription().contains(letter))
                .toList();
    }

    public List<Item> containsLetterAndSort(CharSequence letter, List<Item> list) {
        return list.stream()
                .filter(item -> item.getDescription().contains(letter))
                .sorted()
                .toList();
    }
}
