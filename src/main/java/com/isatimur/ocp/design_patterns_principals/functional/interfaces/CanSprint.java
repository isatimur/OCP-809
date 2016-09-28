package com.isatimur.ocp.design_patterns_principals.functional.interfaces;

public interface CanSprint extends /*CanWalk,*/ CanRun {
    // не может наследовать от интерфейсов с такими же методами по умолчанию
    void sprint();
}