package org.example;

import java.util.ArrayList;
import java.util.List;

interface Animal {
    String talk () ;
}
class Bird implements Animal {
    public boolean flies() {
        return true ;
    }

    @Override
    public String talk() {
        return null;
    }
}
class Raven extends Bird {
    public String talk () {
    return "kraa" ;
    }
}
class Penguin extends Bird {
    public boolean flies () {
        return false ;} }