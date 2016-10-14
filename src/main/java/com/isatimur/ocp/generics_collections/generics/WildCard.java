package com.isatimur.ocp.generics_collections.generics;

class WildCard {
    static void foo(C<? super DI> arg) {

    }

    public static void main(String[] args) {
        foo(new C<BI>());
// ONE
        foo(new C<DI>());
// TWO
//        foo(new C<DDI>());
// THREE
        foo(new C());
// FOUR
    }

    interface BI {
    }

    interface DI extends BI {
    }

    interface DDI extends DI {
    }

    static class C<T> {
    }
}