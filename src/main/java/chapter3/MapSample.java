package chapter3;

import io.reactivex.Observable;

public class MapSample {

    public void marbleDiagram() {
        String[] dataSet = {"RED", "GREEN", "BLUE"};

        Observable<String> dataSource = Observable.fromArray(dataSet).map(data -> data + " <>");
        dataSource.subscribe(System.out::println);
    }

    public void mappingType() {
        String[] dataSet = {"RED", "GREEN", "BLUE"};
        Observable<Integer> dataSource = Observable
                .fromArray(dataSet)
                .map(data -> {
                    switch (data) {
                        case "RED":
                            return 1;
                        case "GREEN":
                            return 2;
                        case "BLUE":
                            return 3;
                        default:
                            return -1;
                    }
                });

        dataSource.subscribe(System.out::println);
    }

    public static void main(String[] args) {
        MapSample instance = new MapSample();
        instance.marbleDiagram();
        instance.mappingType();
    }
}
