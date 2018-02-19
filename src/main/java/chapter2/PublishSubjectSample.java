package chapter2;

import io.reactivex.subjects.PublishSubject;

public class PublishSubjectSample {

    public void emit() {
        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(data -> System.out.println("Subscriber#1 => " + data));
        subject.onNext("Hello");
        subject.onNext("World");
        subject.subscribe(data -> System.out.println("Subscriber#2 => " + data));
        subject.onNext("This is RxJava2");
        subject.onComplete();
    }

    public static void main(String[] args) {
        PublishSubjectSample instance = new PublishSubjectSample();
        instance.emit();
    }
}
