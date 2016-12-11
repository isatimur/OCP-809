package com.isatimur.ocp.package_4;

import java.io.Serializable;

class Boo implements Serializable {
    transient int ti = 10;
    static int si = 20;
}