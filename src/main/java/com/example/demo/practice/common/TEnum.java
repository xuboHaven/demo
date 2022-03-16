package com.example.demo.practice.common;

public enum TEnum {
    RED(1,"red"){
        public void show(){
            System.out.println("watch out");
        }
    },
    YELLOW(1,"red"),
    BLUE(1,"red"),
    BLACK(1,"red"),
    WHITE(1,"red"),
    ORANGE(1,"red"),
    PINK(1,"red");

    private int order;
    private String name;

    TEnum(int i, String red) {
        this.order=i;
        this.name=red;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
