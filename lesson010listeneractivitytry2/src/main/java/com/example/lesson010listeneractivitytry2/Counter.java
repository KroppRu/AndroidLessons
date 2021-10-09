package com.example.lesson010listeneractivitytry2;



public class Counter {
    private int value;
    Counter(Integer _v){
        value = _v;
    }

    public void increase(){
        value += 1;
    }

    public void decrease(){
        value -= 1;
    }

    public int getValue(){
        int x = this.value;
        return x;
    }
}
