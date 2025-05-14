package com.toy.core.`69-inlinefunction`

/**
 * 고차함수 (인자로 전달되는 함수, 반환되는 함수) 의 경우 내부적으로 객체를 생성(메모리할당) 하는 오버헤드 발생 방지 위함
 */
fun main() {
  val data = "data"
  someFunc { println("lambda data=$data") }
}

private inline fun someFunc(func: () -> Unit) {
  println("someFunc...")
  func()
}

/**
 * // non-inline
 * public final class InlineFunctionSampleKt {
 *    public static final void main() {
 *       someFunc(InlineFunctionSampleKt::main$lambda$0);
 *    }
 *
 *    private static final void someFunc(Function0 func) {
 *       System.out.println("someFunc...");
 *       func.invoke();
 *    }
 *
 *    // $FF: synthetic method
 *    public static void main(String[] args) {
 *       main();
 *    }
 *
 *    private static final Unit main$lambda$0() {
 *       System.out.println("1");
 *       return Unit.INSTANCE;
 *    }
 * }
 *
 */

/**
 * // inline
 * public final class InlineFunctionSampleKt {
 *    public static final void main() {
 *       int $i$f$someFunc = 0;
 *       System.out.println("someFunc...");
 *       int var1 = 0;
 *       System.out.println("1");
 *    }
 *
 *    private static final void someFunc(Function0 func) {
 *       int $i$f$someFunc = 0;
 *       System.out.println("someFunc...");
 *       func.invoke();
 *    }
 *
 *    // $FF: synthetic method
 *    public static void main(String[] args) {
 *       main();
 *    }
 * }
 *
 */
