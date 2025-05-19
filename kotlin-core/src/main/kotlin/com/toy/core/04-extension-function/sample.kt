package com.toy.core.`04-extension-function`

//https://kotlinlang.org/docs/extensions.html
fun MutableList<Int>.swap(index1: Int, index2: Int) {
  val tmp = this[index1] // 'this' corresponds to the list
  this[index1] = this[index2]
  this[index2] = tmp
}

fun main() {
  val list = mutableListOf(1, 2, 3, 4)
  list.swap(0, 1)
  println(list)
}

/**
 *    public static final void swap(@NotNull List $this$swap, int index1, int index2) {
 *       Intrinsics.checkNotNullParameter($this$swap, "<this>");
 *       int tmp = ((Number)$this$swap.get(index1)).intValue();
 *       $this$swap.set(index1, $this$swap.get(index2));
 *       $this$swap.set(index2, tmp);
 *    }
 *
 *    public static final void main() {
 *       Integer[] var1 = new Integer[]{1, 2, 3, 4};
 *       List list = CollectionsKt.mutableListOf(var1);
 *       swap(list, 0, 1);
 *       System.out.println(list);
 *    }
 */
