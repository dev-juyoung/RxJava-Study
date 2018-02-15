package chapter2;

import io.reactivex.Observable;

public class ObservableFromArray {
    /**
     * 배열에 대한 Observable 생성.
     * int 등, unboxing 된 데이터형은 사용이 불가능함.
     * Java8의 toIntagerArray()와 같은 스트림 API를 이용하여, Boxing 처리 하여야 함.
     */
    private Integer[] usableData = {100, 200, 300};
    private Observable<Integer> dataSource = Observable.fromArray(usableData);

    public void emit() {
        dataSource.subscribe(System.out::println);
    }

    public static void main(String[] args) {
        ObservableFromArray instance = new ObservableFromArray();
        instance.emit();
    }
}
