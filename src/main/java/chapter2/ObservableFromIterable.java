package chapter2;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ObservableFromIterable {
    private Observable<String> dataSource1 = Observable.fromIterable(generateListData());
    private Observable<Integer> dataSource2 = Observable.fromIterable(generateSetData());

    private void emit() {
        System.out.println("========== This List Type Iterable ==========");
        dataSource1.subscribe(System.out::println);

        System.out.println("========== This Set Type Iterable ==========");
        dataSource2.subscribe(System.out::println);
    }

    private List<String> generateListData() {
        List<String> data = new ArrayList<>();
        data.add("MacOS");
        data.add("Linux");
        data.add("Windows");

        return data;
    }

    private Set<Integer> generateSetData() {
        Set<Integer> data = new HashSet<>();
        data.add(100);
        data.add(200);
        data.add(300);

        return data;
    }

    public static void main(String[] args) {
        ObservableFromIterable instance = new ObservableFromIterable();
        instance.emit();
    }
}
