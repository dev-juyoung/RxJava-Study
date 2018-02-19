package chapter2;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class ConnectableObservableSample {

    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * publish(): 데이터의 발행을 유예 시킴.
     * connect(): 실제 데이터를 발행시킴.
     */
    public void emit() {
        String[] dataSet = { "RED", "GREEN", "BLUE" };
        Observable<String> observable = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(i -> dataSet[i])
                .take(dataSet.length);

        ConnectableObservable<String> dataSource = observable.publish();
        dataSource.subscribe(data -> System.out.println("Subscriber#1 => " + data));
        dataSource.subscribe(data -> System.out.println("Subscriber#2 => " + data));
        dataSource.connect();
        sleep(250);
        dataSource.subscribe(data -> System.out.println("Subscriber#3 => " + data));
        sleep(150);
    }

    public static void main(String[] args) {
        ConnectableObservableSample instance = new ConnectableObservableSample();
        instance.emit();
    }
}
