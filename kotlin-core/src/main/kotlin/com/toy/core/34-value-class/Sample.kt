package com.toy.core.`34-value-class`

/**
 * value class 는 인스턴스 자체를 만들지 않는다. (디컴파일 필요)
 * 원시값 wrapping 시 인스턴스 생성으로 힙 메모리를 차지하는 문제 해결을 위함 (객체 생성비용 절감)
 *
 * https://kotlinlang.org/docs/inline-classes.html
 *
 * - 프로퍼티로는 val 만 허용한다.
 * - 하나의 프로퍼티을 가질 수 있다.
 */

@JvmInline
value class EvenNumber(private val number: Int) {
    init { require(number % 2 == 0) { "number must be even. number=$number" } }
}

fun main() {
    val number1 = EvenNumber(2)
    val number2 = EvenNumber(2)
    println(number1 == number2) // true

    val number3 = EvenNumber(1) // IllegalArgumentException
}

// println(number1 === number2) // === 연산자(객체 동등성) 지원 x (객체 자체를 생성하지 않는다고 하니 의미없는 연산자임)

/*
// .java compile
public final class EvenNumber {
   private final int number;

   //.. toString(), equalsAndHashCode, ...

   public static int constructor_impl(int number) {
      if (number % 2 != 0) {
         int var2 = 0;
         String var3 = "number must be even. number=" + number;
         throw new IllegalArgumentException(var3.toString());
      } else {
         return number;
      }
   }
}

public final class SampleKt {
   public static final void main() {
      int number1 = EvenNumber.constructor-impl(2);
      int number2 = EvenNumber.constructor-impl(2);
      int number3 = EvenNumber.equals-impl0(number1, number2);
      System.out.println((boolean)number3);
      number3 = EvenNumber.constructor-impl(1);
   }

   public static void main(String[] args) {
      main();
   }
}
 */
