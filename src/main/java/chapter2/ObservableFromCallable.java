package chapter2;

import io.reactivex.Observable;

import java.util.concurrent.Callable;

public class ObservableFromCallable {
    private Callable<String> callable = () -> {
        Thread.sleep(1000);
        return "Hello Observable.fromCallable()";
    };

    private Observable<String> dataSource = Observable.fromCallable(callable);

    public void emit() {
        dataSource.subscribe(System.out::println);
    }

    public static void main(String[] args) {
        ObservableFromCallable instance = new ObservableFromCallable();
        instance.emit();
    }
}
