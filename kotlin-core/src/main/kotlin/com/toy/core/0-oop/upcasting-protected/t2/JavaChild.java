package com.toy.core.t2;

import com.toy.core.t1.JavaParent;

public class JavaChild extends JavaParent {

    @Override
    protected void f1() {
        System.out.println("c");
    }
}
