package com.hmtmcse.advanced.fileio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserDefinedFileAttributeView;

/**
 * Created by Touhid Mia on 03/03/2016.
 */
public class MyAttribute {


    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Touhid Mia\\Desktop\\asd\\genrey.png";
        Path path1 = Paths.get(path);
        BasicFileAttributes basicAttributes =
                Files.readAttributes(path1, BasicFileAttributes.class);

        System.out.println("Creation Time: "+basicAttributes.creationTime());
        System.out.println("Directory? "+basicAttributes.isDirectory());
        System.out.println("File? "+basicAttributes.isRegularFile());
        System.out.println("Last accessed on: "+basicAttributes.lastAccessTime());
        System.out.println("Last modified on: "+basicAttributes.lastModifiedTime());
        System.out.println("File size: "+basicAttributes.size()+"bytes");


        Path pathx = Paths.get(path);

        UserDefinedFileAttributeView view = Files.getFileAttributeView(pathx,UserDefinedFileAttributeView.class);
        view.write("license", Charset.defaultCharset().encode("Platinum"));
        view.write("createBy", Charset.defaultCharset().encode("Touhid"));
        view.write("appVersion", Charset.defaultCharset().encode("2.1.6"));
//        System.out.println("Publishable set");

        String name = "publishable";
        int size = view.size(name);
        ByteBuffer buffer = ByteBuffer.allocate(view.size(name));
        view.read(name, buffer);
        buffer.flip();
        String value = Charset.defaultCharset().decode(buffer).toString();
        System.out.println(value);

    }


}
