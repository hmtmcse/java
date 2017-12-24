package com.hmtmcse.mixin

class ChildMixinClass {

    void childMixinMethod(){
        println("Child Mixin Method.")
    }


    void callToMixin(){
        println("-------------------------------")
        parentMixinMethod()
        println("-------------------------------")
    }

}
