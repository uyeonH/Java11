# Lambda

람다식 도입으로 자바는 객체지향 언어인 동시에 함수형 언어가 되었다.

람다식은 메서드를 하나의 식으로 표현한 것이다.

메서드에서 메서드 이름을 지우고 -> 를 추가하면 된다.

```java
int max(int a, int b){
    return a > b ? a : b;
}
```

```java
(int a, int b) -> {
    return a > b ? a : b;
}
```

- 매개변수가 하나이면 ()를 생략할 수 있다.
- 매개변수에 타입이 있으면 괄호를 생략할 수 있다.
```java
a -> a * a
int a -> a * a // error
```

- 매개변수가 없을 때는 ()를 작성해야한다.
```java
() -> { return 3;}
```

## 함수형 인터페이스

람다식은 메서드가 아닌 익명 클래스의 객체와 동등하다. 

참조변수가 있어야 객체의 메서드를 호출할 수 있으니 익명 객체의 주소를 f라는 참조 변수에 저장한다.

```java
타입 f = (int a, int b) -> a > b ? a : b;
```
참조변수 f의 타입은 클래스또는 인터페이스가 가능하다. 그리고 람다식과 동등한 메서드가 정의되어 있어야 한다. 
그래야 참조변수로 익명 객체의 메서드를 호출할 수 있기 때문이다.

- 인터페이스
```java
interface MyFunction{
    public abstract int max(int a, int b);
}
```

- 인터페이스를 구현한 익명 클래스 객체
```java
MyFunction f = new MyFunction(){
    public int max(int a, int b){
        return a > b ? a : b;
        }
};
```
인터페이스의 `max()`는 람다식 `(int a, int b) -> a > b ? a : b`와 선언부가 일치한다. 
그래서 다음과 같이 대체할 수 있다.

```java
MyFunction f  = (int a, int b) -> a > b ? a : b;
```

### MyFunction을 구현한 익명 객체를 람다식으로 대체 가능한 이유 
- 람다식도 익명 객체이다.
- MyFunction 구현 익명 객체의 max()와 람다식의 매개변수 타입, 갯수, 반환값이 일치한다. 

 하나의 메서드가 선언된 인터페이스를 정의하고 람다식을 다루는 것이 기존의 자바 규칙을 어기지 않으며 자연스럽다.
그래서 인터페이스를 통해 람다식을 다루기로 결정되었고 이를 <b>'함수형 인터페이스'</b>라고 한다.
따라서 함수형 인터페이스에는 <b>하나의 추상 메서드만 정의</b>되어야 람다식과 인터페스가 메서드가 1:1 매칭이 될 수 있다. 

- 람다식을 메서드를 주고받을 수 있다. 




### 람다식의 타입과 형변환
함수형 인터페이스의 타입과 람다식 타입이 일치하는 것은 아니다.
람다식은 익명 객체이고 익명 객체는 타입이 없다.
(타입이 있지만 컴파일러가 임의로 정해서 알 수 없음)

람다식은 인터페이스를 직접 구현하지 않았지만 인터페이스 구현 클래스의 객체와 완전히 동일하기 때문에 형변환을 허용한다.

```java
MyFunction f = (MyFunction) (()-> {}); 
```
람다식은 오직 함수형 인터페이스로만 형변환이 가능하다. 

### 외부 변수를 참조하는 람다식

람다식 내에서 참조하는 지역변수는 final이 붙지 않았어도 상수로 간주된다.

```java
void method(int i){ // final int i와 같음
    int val = 30; // final int val과 같음
    int i = 3; // 에러
        MyFunction f = (i) -> { // 에러 외부 지역변수와 이름 중복
            
        };
}
```




## java.util.function 패키지

java.util.function에는 일반적으로 많이 쓰이는 형식의 메서드를 함수형 인터페이스로 정의해 두었다. 


|함수형 인터페이스|메서드|설명|
|------|---|---|
|java.lang.Runnable|void run()|매개변수도 없고 반환값도 없음|
|Supplier <T,>|T get()|매개변수는 없고 반환값만 있음|
|Consumer <T,> |void accept(T t)|Supplier와 반대로 매개변수만 있고 반환값이 없음|
|Function<T,R>|R apply(T t)|일반적인 함수. 하나의 매개변수를 받아서 결과를 반환|
|Predicate <T,>|boolean test(T t)|조건식을 표현하는데 사용됨. 매개변수는 하나, 반환 타입은 boolean|

- 매개변수와 반환값 유무에 따라 4개의 함수형 인터페이스 정의 됨



#### Predicate
Predicate은 Function의 변형으로 반환값이 boolean이라는 것만 제외하고 Function과 동일하다.

조건식을 람다식으로 표현하는데 사용된다.
```java
Predicate<String> isEmptyStr = s -> s.length()==0;
if (isEmptyStr.test(""))
    System.out.println("empty!");

```

#### 매개변수가 두 개인 함수형 인터페이스
|함수형 인터페이스|메서드|설명|
|------|---|---|
|BiConsumer<T,U>|void accept(T t, U u)|두 개의 매개변수만 있고, 반환 값이 없음|
|BiPredicate<T,U>|boolean test(T t, U u)|조건식을 표현하는데 사용됨. 매개변수는 둘, 반환값은 boolean|
|BiFunction<T,U,R>|R apply(T t, U u)|두 개의 매개변수를 받아서 하나의 결과를 반환|


#### 컬렉션 프레임웍과 함수형 인터페이스
|인터페이스|메서드|설명|
|------|---|---|
|Collection |boolean removeIf(Predicate<E> filter) |조건에 맞는 요소를 삭제|
|List |void replaceAll(UnaryOperator<E> operator) |모든 요소를 반환하여 대체|
|Iterable |void forEach(Consumer<E> action) |모든 요소에 작업 action을 수행|
