package chapter2;

import io.reactivex.subjects.ReplaySubject;

public class ReplaySubjectExample {

    /**
     * ReplaySubject의 경우, 차가운 Observable처럼 동작하므로, 주의 필요.
     */
    public void emit() {
        ReplaySubject<Integer> subject = ReplaySubject.create();
        subject.subscribe(data -> System.out.println("Subscriber#1 => " + data));
        subject.onNext(1);
        subject.onNext(3);
        subject.subscribe(data -> System.out.println("Subscriber#2 => " + data));
        subject.onNext(5);
        subject.onComplete();
    }

    public static void main(String[] args) {
        ReplaySubjectExample instance = new ReplaySubjectExample();
        instance.emit();
    }
}
