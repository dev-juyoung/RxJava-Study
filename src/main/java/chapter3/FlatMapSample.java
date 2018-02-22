package chapter3;

import io.reactivex.Observable;

import java.util.Scanner;

public class FlatMapSample {

    public void marbleDiagram() {
        String[] dataSet = {"RED", "GREEN", "BLUE"};
        Observable<String> dataSource =
                Observable
                        .fromArray(dataSet)
                        .flatMap(data -> Observable.just(data + " <>", data + " <>"));

        dataSource.subscribe(System.out::println);
    }

    public int requestInputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("실행한 단을 입력하세요.");
        String userInput = scanner.nextLine();
        int dan = 0;

        try {
            dan = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        scanner.close();

        return dan;
    }

    public void basicJava(int dan) {
        System.out.println("========== Basic Java START ==========");

        for (int row = 1; row <= 9; row++) {
            System.out.println(dan + " * " + row + " = " + (dan * row));
        }

        System.out.println("========== Basic Java END ==========");
    }

    public void simpleRxJava(int dan) {
        System.out.println("========== Simple START ==========");

        Observable<Integer> dataSource = Observable.range(1, 9);
        dataSource.subscribe(row -> System.out.println(dan + " * " + row + " = " + (dan * row)));

        System.out.println("========== Simple END ==========");
    }

    public void usingFlatMap(int dan) {
        System.out.println("========== FlatMap START ==========");

        Observable<String> dataSource =
                Observable
                        .just(dan)
                        .flatMap(num -> Observable
                                .range(1, 9)
                                .map(row -> num + " * " + row + " = " + (num * row)));

        dataSource.subscribe(System.out::println);

        System.out.println("========== FlatMap END ==========");
    }

    public void usingFlatMapResultSelector(int dan) {
        System.out.println("========== FlatMap Result Selector START ==========");

        Observable<String> dataSource =
                Observable
                        .just(dan)
                        .flatMap(num -> Observable
                                        .range(1, 9),
                                (num, row) -> num + " * " + row + " = " + (num * row));

        dataSource.subscribe(System.out::println);

        System.out.println("========== FlatMap Result Selector END ==========");
    }

    public static void main(String[] args) {
        FlatMapSample instance = new FlatMapSample();
        instance.marbleDiagram();

        int dan = instance.requestInputData();

        if (dan == 0) {
            System.out.println("입력한 데이터가 숫자가 아닙니다.\n프로그램을 종료합니다.");
            return;
        }

        System.out.println(String.valueOf(dan) + "단의 연산을 실행합니다.");

        instance.basicJava(dan);
        System.out.println();
        instance.simpleRxJava(dan);
        System.out.println();
        instance.usingFlatMap(dan);
        System.out.println();
        instance.usingFlatMapResultSelector(dan);
    }
}
