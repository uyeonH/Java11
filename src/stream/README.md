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

#### 배열 