package chapter2;

import io.reactivex.subjects.BehaviorSubject;

public class BehaviorSubjectSample {

    private void emit() {
        BehaviorSubject<String> subject = BehaviorSubject.createDefault("Not Found");
        subject.subscribe(data -> System.out.println("Subscriber#1 => " + data));
        subject.onNext("MacOS");
        subject.onNext("Linux");
        subject.subscribe(data -> System.out.println("Subscriber#2 => " + data));
        subject.onNext("Windows");
        subject.onComplete();
    }

    public static void main(String[] args) {
        BehaviorSubjectSample instance = new BehaviorSubjectSample();
        instance.emit();
    }
}
