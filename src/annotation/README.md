# Annotation

소스코드의 주석 /** ~ */에 소스코드에 대한 정보를 저장하고 소스코드 주석으로부터 html 문서를 생성하는 프로그램을 만들어 사용했다. 
주석 안에 소스코드에 대한 설명이 있고 그 안에 @이 붙은 태그들을 이용해 주석 안에 정보를 저장한다.
javadoc.exe 프로그램이 이 정보를 읽어 문서를 작성하는데 사용한다. 이 기능을 응용하여 프로그램의 소스코드 안에 다른 프로그램을 위한 정보를 미리 약속된 형식으로 포함시킨 것이 어노테이션이다. 
주석처럼 프로그래밍 언어에 영향을 미치지 않으면서도 다른 프로그램에게 유용한 정보를 제공할 수 있다. 

<b> java.lang.annotation </b>

```java
package java.lang.annotation;
public interface Annotation {
  
    boolean equals(Object obj);    
    int hashCode();   
    String toString();    
    Class<? extends Annotation> annotationType();
}
```

모든 어노테이션의 조상은 Annotation이다. 상속은 허용되지 않는다. 모든 어노테이션 객체에 대해 `equals()`, `hashCode()`, `toString()` 호출이 가능하다.  

### 표준 어노테이션

`@Override`
 
컴파일러에게 오버라이딩하는 메서드라는 것을 알린다.

`@Deprecated` 

앞으로 사용하지 않을 것을 권항하는 대상에 붙인다.

`@SuppressWarnings`

컴파일러의 특정 경고메시지가 나타나지 않게 한다.

`@FunctionalInterface`

함수형 인터페이스라는 것을 알린다.

`@SafeVarargs`

제네릭스 타입의 가변인자에 사용한다.

`@Native`

native 메서드에서 참조되는 상수 앞에 붙인다. 네이티브 메서드는 jvm이 설치된 os의 메서드를 말한다. 네이티브 메서드는 보통 C언어로 작성되어 있는데,
자바에서는 메서드의 선언부만 정의하고 구현하지 않는다. 그래서 추상메서드처럼 선언부만 있고 몸통이 없다. 모든 클래스의 조상인 Object 클래스의 메서드들은 대부분 네이티브 메서드이다.

#### 메타 어노테이션
어노데이션을 위한 어노테이션, 즉 어노테이션에 붙이는 어노테이션으로 어노테이션 정의 시 적용 대상이나 유지기간을 지정하는데 사용된다. 

`@Target`

어노테이션이 적용 가능한 대상을 지정하는데 사용한다.

```java
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
@Retention(RetentionPolicy.SOURCE)
public @interface SuppressWarnings {
    /**
     * The set of warnings that are to be suppressed by the compiler in the
     * annotated element.  Duplicate names are permitted.  The second and
     * successive occurrences of a name are ignored.  The presence of
     * unrecognized warning names is <i>not</i> an error: Compilers must
     * ignore any warning names they do not recognize.  They are, however,
     * free to emit a warning if an annotation contains an unrecognized
     * warning name.
     *
     * <p> The string {@code "unchecked"} is used to suppress
     * unchecked warnings. Compiler vendors should document the
     * additional warning names they support in conjunction with this
     * annotation type. They are encouraged to cooperate to ensure
     * that the same names work across multiple compilers.
     * @return the set of warnings to be suppressed
     */
    String[] value();
}
```
@Target으로 지정할 수 있는 어노테이션 적용 대상

    - ANNOTATION_TYPE 어노테이션
    
    - CONSTRUCTOR 생성자
    
    - FIELD 필드(멤버변수, ENUM 상수) - 기본형
    
    - LOCAL_VARIABLE 지역변수
    
    - METHOD 메서드
    
    - PACKAGE 패키지
    
    - PARAMETER 매개변수
    
    - TYPE 타입(클래스, 인터페이스, ENUM)
    
    - TYPE_PARAMETER 타입 매개변수
    
    - TYPE_USE 타입이 사용되는 모든 곳 - 참조형

`@Documented`

어노테이션 정보가 javadoc으로 작성된 문서에 포함되게 한다.
자바에서 제공하는 기본 어노테이션 중 `@Override`나 `@SuppressWarnings`를 제외하고 모두 붙어있다.


`@Inherited`

어노테이션이 자손 클래스에 상속되도록 한다.

`@Retention`

어노테이션이 유지되는 범위를 지정하는데 사용한다.

- SOURCE 
    - 소스 파일에만 존재. 클래스파일에는 존재하지 않음.
    - `@Override`나 `@SuppressWarnings`처럼 컴파일러가 사용하는 어노테이션 유지정책이다.
    - 컴파일러 직접 작성할 것 아니면 사용x

- CLASS 클래스 파일에 존재. 실행시에 사용불가. 기본값
  - 컴파일러가 어노테이션 정보를 클래스파일에 저장하게는 하지만 클래스파일이 jvm에 로딩 될 때는 어노테이션 정보가 무시되어
    실행시에 정보를 얻을 수 없다.
  

- RUNTIME 클래스 파일에 존재. 실행시 사용 가능
    - 실행시에 리플렉션을 통해 클래스 파일에 저장된 어노테이션의 정보를 읽어 처리할 수 있다. 
    


`@Repeatable`

어노테이션을 반복해서 적용할 수 있게 한다.

```java
import java.lang.annotation.Repeatable;

@Repeatable(ToDos.class) // 여러개의 ToDo 애너테이션을 담을 컨테이녀 애너테이션 ToDos
@interface ToDo{
    String value();
}

```

```java
@ToDo("todo1")
@ToDo("todo2")
class MyClass{
    ...
}
```


### 어노테이션 타입 정의하기

```java
@interface 어노테이션이름{
    타입요소이름();
}
```

#### 애너테이션 요소
```java
@interface TestInfo{
    int count(); // 어노테이션 요소
    String testedBy(); // 어노테이션 요소
    
}
```

어노테이션 요소는 반환 타입이 있고 매개변수는 없는 추상 메서드 형태이지만, 상속을 통해 구현하지 않아도 된다.

다만 어노테이션을 적용할때 이 요소들의 값을 모두 지정해주어야 한다.