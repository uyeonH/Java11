# Stream

이전에는 데이터를 다룰 때 컬렉션이나 배열에 데이터를 담고 for문과 Interator를 이용했다.

Collection, Iterator 인터페이스로 컬렉션을 추상화 하기는 했지만 
각 컬렉션 클래스에는 같은 기능의 메서드들이 중복해있다. 

배열을 정렬 할 때는 Arrays.sort(), List를 정렬 할 때는 Collections.sort()를 사용한다.

이 문제를 해결하기 위해 스트림이 만들어졌다. 스트림은 데이터 소스를 추상화시켜 데이터에 상관 없이 같은 방식으로 다룰 수 있게 했다.

- 배열과 List
```java
String[] strArr = {"aaa", "bbb", "ccc"};
List<String> strList = Arrays.asList(strArr);
```

- 스트림 생성
```java
Stream<String> strStream1 = strList.stream();
Stream<String> strStream2 = Arrays.stream(strArr); 
```

```java
strStream1.sorted().forEach(System.out::println);
strStream2.sorted().forEach(System.out::println);
```

- 스트림은 데이터 소스를 변경하지 않는다.
- 스트림은 일회용이다.
- 스트림은 작업을 내부 반복으로 처리한다.

### 스트림 연산
- 스트림 연산은 DB 쿼리문과 비슷하다.
- 중간 연산과 최종 연산이 있다. 중간 연산은 스트림으로 반환하기 때문에 계속 연결시킬 수 있다. 최종 연산은 스트림 요소를 소모하며 연산을 수행하여 
한 번만 연산 가능하다.
  

## 스트림 만들기

#### 컬렉션
컬렉션의 최고 조상인 Collection에 `stream()`이 정의되어있다. Collection의 자손은 모두 `stream()`으로 스트림을 생성할 수 있다. 
```java
List<String> list = new ArrayList<>();
list.stream();
```
#### 배열 
배열을 소스로 하는 스트림을 생성하는 메서드는 Stream과 Arrays에 static 메서드로 정의되어 있다.

```java
Stream<String> strStream = Stream.of(new String[] {"a","b","c"});
Stream<String> strStream = Arrays.stream(new String[]{"a","b","c"})
```

## 스트림 중간연산

### 스트림 자르기
```java
Stream<T> skip(long n)
STream<T> limit(long maxSize)
```
- 예시
```java
skip(3) // 처음 세 개를 건너뜀
limit(5) // 스트림 요소를 5개로 제한
```

### 스트림 요소 걸러내기
```java
Stream<T> filter(Predicate<? super T> predicate)
Stream<T> distinct()
```
- 예시
```java
stream.distinct()
stream.filter(i->i%2==0).filter(i->i%3==0)
```
### 스트림 정렬
```java
Stream<T> sorted()
Stream<T> sorted(Comparator<? super T> comparator)
```
- 예시
```java
stream.sorted()
stream.sorted(Comparator.naturalOrder())
```

### 변환
```java
Stream<R> map(Function<? super T,? extends R> mapper)
```
- 예시
```java
Stream<String> fileNameStream = filterStream.map(File::getName); // File -> String
```
```java
filterStream.map(File::getName)
.filter(s->s.indexOf(".")!=-1) // 확장자 없는 것 제외
.map(String::toUpperCase)
.distinct()
.forEach(System.out::println);
```

### 조회
연산과 연산 사이에 올바르게 처리되었는지 확인할 때 사용
요소를 소모하지 않으므로 연산 사이에 여러번 넣어도 괜찮음

```java
filterStream.map(File::getName)
.filter(s->s.indexOf(".")!=-1) 
.peek(s->System.out.printf("filename=%s%n",s))
```

### mapToInt(), mapToLong(), mapToDouble()
map()은 연산의 결과로 Stream<T> 타입의 스트림을 반환하는데, 스트림의 요소를 숫자로 반환하는 경우 기본형 스트림 변환이 유용하다.

```java
DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)
IntStream mapToInt(ToIntFunction<? super T> mapper)
LongStream mapToLong(ToLongFunction<? super T> mapper)
```

Stream<T>는 count()만 지원하지만 IntStream 같은 기본형 스트림에서는 다음과 같은 메서드들을 제공한다.

```java
int sum() // 스트림의 모든 요소 총합
OptionalDouble averate() // sum()/(double)count()
OptionalInt max() // 스트림의 요소 중 제일 큰 값
OptionalInt min() // 스트림의 요소 중 제일 작은 값
```

위 메서드들은 최종 연산이기 때문에 호출 후에 스트림이 닫힌다.
`sum()`과 `average()`를 연속해서 사용할 수 없는 점을 보완한 summaryStatics()라는 메서드도 있다.


### flatMap() - Stream<T[]>를 Stream<T>로 변환
스트림 요소가 배열이거나 map()의 연산 결과가 배열인 경우 flatMap()을 사용하면 된다.

