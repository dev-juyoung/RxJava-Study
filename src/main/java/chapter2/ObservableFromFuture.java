package chapter2;

import io.reactivex.Observable;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ObservableFromFuture {
    private Future<String> future = Executors.newSingleThreadExecutor().submit(() -> {
        Thread.sleep(1000);
        return "Hello Observable.fromFuture()";
    });

    private Observable<String> dataSource = Observable.fromFuture(future);

    public void emit() {
        dataSource.subscribe(System.out::println);
    }

    public static void main(String[] args) {
        ObservableFromFuture instance = new ObservableFromFuture();
        instance.emit();
    }
}
