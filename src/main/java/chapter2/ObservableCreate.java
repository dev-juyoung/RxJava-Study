package chapter2;

import io.reactivex.Observable;

public class ObservableCreate {
    private Observable<Integer> dataSource = Observable.create(
            emitter -> {
                emitter.onNext(100);
                emitter.onNext(200);
                emitter.onNext(300);
                emitter.onComplete();
            }
    );

    public void emit() {
        dataSource.subscribe(System.out::println);
    }

    public static void main(String[] args) {
        ObservableCreate instance = new ObservableCreate();
        instance.emit();
    }
}
