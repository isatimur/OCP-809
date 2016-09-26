package com.isatimur.ocp.design_patterns_principals.functional.interfaces;

import com.isatimur.ocp.generics_collections.comparable.Animal;

/**
 * While it is a good practice to mark a functional interfaces with the @FunctionalInterface
 * annotation for clarity, it is not required with functional programming. The Java compiler
 * implicitly assumes that any interfaces that contains exactly one abstract method is
 * a functional interfaces. Conversely, if a class marked with the @FunctionalInterface
 * annotation contains more than one abstract method, or no abstract methods at all, then
 * the compiler will detect this error and not compile.
 * One problem with not always marking your functional interfaces with this annotation is
 * that another developer may treat any interfaces you create that has only one method as
 * a functional interfaces. If you later modify the interfaces to have other abstract methods,
 * suddenly their code will break since it will no longer be a functional interfaces.
 * Therefore, it is recommend that you explicitly mark the interfaces with the
 *
 * @FunctionalInterfaceannotation so that other developers know which interfaces they
 * can safely apply lambdas to without the possibility that they may stop being functional
 * interfaces down the road.
 * The exam writers aren’t likely to use this annotation, as they expect you to be able to
 * determine whether an interfaces is a functional interfaces on your own.
 */
@FunctionalInterface
public interface Sprint {
    void sprint(Animal animal);
}