package chapter2;

import io.reactivex.Observable;

public class ObservableCreate {
    /**
     * just()와는 다르게,
     * onNext(), onError(), onComplete() 를 개발자가 직접 구현해주어야 함.
     */
    private Observable<Integer> dataSource = Observable.create(
            emitter -> {
                emitter.onNext(100);
                emitter.onNext(200);
                emitter.onNext(300);
                emitter.onComplete();
            }
    );

    public void emit() {
        // subscribe()를 호출하지 않으면, 구독을 하지 않으므로, 데이터를 만들어두고 실제 발행은 하지 않음.
        dataSource.subscribe(System.out::println);
    }

    public static void main(String[] args) {
        ObservableCreate instance = new ObservableCreate();
        instance.emit();
    }
}
