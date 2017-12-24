package com.hmtmcse.mixin

class MixinTest {

    static void main(String[] args) {

        ParentMixinClass parentMixinClass = new ParentMixinClass()

        // Mixin Parent With Child Class
        parentMixinClass.metaClass.mixin(ChildMixinClass)


        // Called Child Method to which calling mixing parent method
        parentMixinClass.callToMixin()

        println("")
        // Called Child Method from mixin class
        parentMixinClass.childMixinMethod()


        println("")
        // Called Base Class Method
        parentMixinClass.parentMixinMethod()
    }

}
