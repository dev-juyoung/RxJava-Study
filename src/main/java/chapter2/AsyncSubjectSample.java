package chapter2;

import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;

public class AsyncSubjectSample {
    /**
     * AsyncSubject는 가장 마지막의 데이터만 감시한다.
     */
    public void basic() {
        System.out.println("========== basic method ==========");
        AsyncSubject<String> subject = AsyncSubject.create();
        subject.subscribe(data -> System.out.println("Subscribe#1 => " + data));
        subject.onNext("Windows");
        subject.onNext("Linux");
        subject.subscribe(data -> System.out.println("Subscribe#2 => " + data));
        subject.onNext("MacOS");
        subject.onComplete();
    }

    public void subscriber() {
        System.out.println("========== subscriber method ==========");
        Float[] temperatures = { 10.1f, 13.4f, 12.5f };
        Observable<Float> dataSource = Observable.fromArray(temperatures);

        AsyncSubject<Float> subject = AsyncSubject.create();
        subject.subscribe(data -> System.out.println("Subscriber#1 => " + data));

        // Subject는 Observable의 구독자로 사용될 수 있다.
        dataSource.subscribe(subject);
    }

    public void afterCompleted() {
        System.out.println("========== afterCompleted method ==========");
        AsyncSubject<Integer> subject = AsyncSubject.create();
        subject.onNext(100);
        subject.onNext(200);
        subject.subscribe(data -> System.out.println("Subscribe#1 => " + data));
        subject.onNext(300);
        subject.subscribe(data -> System.out.println("Subscribe#2 => " + data));
        // onComplete() 이후에 onNext()로 변경된 데이터가 발행 되어도, 감시하지 않음.
        subject.onComplete();
        subject.onNext(500);
        subject.subscribe(data -> System.out.println("Subscribe#3 => " + data));
    }

    public static void main(String[] args) {
        AsyncSubjectSample instance = new AsyncSubjectSample();
        instance.basic();
        instance.subscriber();
        instance.afterCompleted();
    }
}
