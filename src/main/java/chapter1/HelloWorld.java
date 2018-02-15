package chapter1;

import io.reactivex.Observable;

public class HelloWorld {

    /**
     * Observable: 데이터의 변화가 발생하는 DataSource(?)
     * just: Observable을 선언하는 가장 단순한 방법(?) / 데이터를 실제 발행함.
     * subscribe: Observable을 구독(?) / 감시(?) 함.
     *
     * emit: RxJava 발행 / 보냄 / 배출 등의 의미로 표현됨.
     */
    public void emit() {
        Observable
                .just("Hello", "RxJava2", "World!")
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
        HelloWorld instance = new HelloWorld();
        instance.emit();
    }
}
