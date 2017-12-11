#### Upload Public file

```java        
public class CephS3Test {

    public static void main(String[] args) {
        CephS3 cephS3 = new CephS3();
        ResponseData responseData = cephS3.uploadPublicFile(new File("C:\\Users\\touhid\\Desktop\\temp\\logo.jpg"),"images/screen/logo.jpg");
        if (responseData.isSuccess){
            System.out.println("Success");
        }else {
            System.out.println("Error: " + responseData.getMessage());
        }
    }

}
```


#### Upload Restrict file
```java
public class CephS3Test {

    public static void main(String[] args) {
        CephS3 cephS3 = new CephS3();
        ResponseData responseData = cephS3.uploadRestrictFile(new File("C:\\Users\\touhid\\Desktop\\temp\\logo.jpg"),"images/screen/logo.jpg");
        if (responseData.isSuccess){
            System.out.println("Success");
        }else {
            System.out.println("Error: " + responseData.getMessage());
        }
    }

}
```


#### Upload Restrict file
```java
public class CephS3Test {

    public static void main(String[] args) {
        CephS3 cephS3 = new CephS3();
        ResponseData responseData = cephS3.uploadRestrictFile(new File("C:\\Users\\touhid\\Desktop\\temp\\logo.jpg"),"images/screen/logo.jpg");
        if (responseData.isSuccess){
            System.out.println("Success");
        }else {
            System.out.println("Error: " + responseData.getMessage());
        }
    }

}
```

#### Delete File

```java
public class CephS3Test {

    public static void main(String[] args) {
        CephS3 cephS3 = new CephS3();
        cephS3.deleteObject("images/screen/logo.jpg");
    }
}
```

#### is Exist object

```java
public class CephS3Test {

    public static void main(String[] args) {
        CephS3 cephS3 = new CephS3();
         cephS3.isObjectExists("images/screen/logo.jpg");
    }
}
```

#### get public URL

```java
public class CephS3Test {

    public static void main(String[] args) {
        CephS3 cephS3 = new CephS3();
        System.out.println(cephS3.getPublicFileURL("images/screen/logo.jpg"));
    }
}
```

#### get restrict URL

```java
public class CephS3Test {

    public static void main(String[] args) {
        CephS3 cephS3 = new CephS3();
        System.out.println(cephS3.getRestrictFileURL("images/screen/logo.jpg"));
    }
}
```