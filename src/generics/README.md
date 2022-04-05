# 제네릭

## 제네릭 메서드

제네릭 메서드: 메서드 선언부에 제네릭 타입이 선언된 메서드

```java
static <T> void sort(List<T> list, Comparator<? super T> c)
```

제네릭 클래스의 T와 제네릭 메서드의 T는 별개의 것이다.
```java
class FruitBox<T> {
    ...
    static <T> void sort(List<T> list, Comparator<? super T> c){
        ...
    }
    ...    
}

```
메서드에 선언된 제네릭 타입은 지역 변수를 선언한 것과 같다고 생각하면 쉽다.

```java
static Juice makeJuice(FruitBox<? extends Fruit> box){
    String tmp="";
    for (Fruit f: box.getList()) tmp += f + " ";
    return new Juice(tmp);
}

```
```java
static <T extends Fruit> Juice makeJuice(FruitBox<T> box){
    String tmp="";
    for (Fruit f: box.getList()) tmp += f + " ";
    return new Juice(tmp);
}

```
매개변수의 타입이 복잡할 때 유용하다
```java
public static void printAll(ArrayList<? extends Product> list, ArrayList<? extends Product> list2){
    for(Unit u : list){
        System.out.println(u);
        }
        }
```

```java
public static <T extends Product> void printAll(ArrayList<T> list, ArrayList<T> list2){
    for(Unit u : list){
        System.out.println(u);
        }
}
```

