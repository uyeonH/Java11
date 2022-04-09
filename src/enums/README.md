# Enum

열거형: 서로 관련된 상수를 편리하게 선언하기 위한 것

정의

```java
enum 열거형이름 {상수명1, 상수명2 ...}
```

- 상수끼리의 비교는 equals가 아닌 ==으로 가능

- switch문 조건식에 사용 가능
```java
switch(dir){
    case EAST: x++; break; // Direction.EAST라고 쓰면 안됨
    ...
        }
```

### 메서드

`String name()`

열거형 상수 이름을 문자열로 반환

`int ordinal()`

열거형 상수 정의된 순서 반환

`T valueOf(class<T> enumType, String name)`

지정된 열거형에서 name과 일치하는 열거형 상수 반환


### 열거형에 멤버 추가하기
```java
enum Direction {
    EAST(1, ">"), SOUTH(2, "V"), WEST(3, "<"), NORTH(4, "^");

    private final int value;
    private final String symbol;

    Direction(int value, String symbol) { // private 생략
        this.value=value;
        this.symbol = symbol;
    }
}

```

### 열거형에 추상메서드 추가하기

열거형에 추상메서드를 선언하면 각 열거형 상수가 반드시 구현해야한다.

```java

enum Transportation {
    BUS(100) {
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };
    protected final int BASIC_FARE;
    abstract int fare(int distance);

}

```


### java.lang.Enum 내부 구조
EnumEx4에서 직접 구현해보았다.

Comparable 인터페이스를 구현해서 열거형 상수간 비교가 가능하게 한다.

```java

public abstract class Enum<E extends Enum<E>>
        implements Comparable<E>, Serializable {

    private final String name;    
    public final String name() {
        return name;
    }
    
    private final int ordinal;
    public final int ordinal() {
        return ordinal;
    }

    protected Enum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }
    
    public String toString() {
        return name;
    }

    public final boolean equals(Object other) {
        return this == other;
    }
    
    public final int hashCode() {
        return super.hashCode();
    }
    
    protected final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    
    public final int compareTo(E o) {
        Enum<?> other = (Enum<?>) o;
        Enum<E> self = this;
        if (self.getClass() != other.getClass() && // optimization
                self.getDeclaringClass() != other.getDeclaringClass())
            throw new ClassCastException();
        return self.ordinal - other.ordinal;
    }
           
            .
            .
            .
}
```
