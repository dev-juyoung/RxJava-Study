package chapter2;

import io.reactivex.Observable;
import org.reactivestreams.Publisher;

public class ObservableFromPublisher {
    private Publisher<String> publisher = s -> {
        s.onNext("MacOS");
        s.onNext("Linux");
        s.onNext("Windows");
        s.onComplete();
    };

    private Observable<String> dataSource = Observable.fromPublisher(publisher);

    public void emit() {
        dataSource.subscribe(System.out::println);
    }

    public static void main(String[] args) {
        ObservableFromPublisher instance = new ObservableFromPublisher();
        instance.emit();
    }
}
