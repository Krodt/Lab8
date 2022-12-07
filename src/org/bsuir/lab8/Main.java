package org.bsuir.lab8;


import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public final static MethodsToWork METHODS = new MethodsToWork();

    public static void main(String[] args) throws IOException {

        MyList myList = new MyList(5);
        myList.add("Hello");
        myList.add("Bye");
        myList.add("Hello");
        myList.add("Hello");
        myList.add("Hey");
        MyList mySecondList = METHODS.readFileToSuperListAndPrint("ListSource.txt");
        myList.add("Hello");
        myList.add("Bye");
        myList.add("Hello");
        myList.add("Hello");
        myList.add("Hey");

        System.out.println("The list is: " + myList);
        System.out.println("Removing by index: ");
        myList.remove(4);
        System.out.println(myList);
        System.out.println("Counting duplicates:");
        METHODS.showDuplicatesWithCount(myList);
        System.out.println("Writing into XML");
        try {
            FileOutputStream fos=new FileOutputStream(new File("writeintoXML.xml"));
            XMLEncoder encoder=new XMLEncoder(fos);
            encoder.writeObject(myList);
            encoder.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Reversing:");
        METHODS.reverseAll(myList);
        System.out.println(myList);
        System.out.println("Some info:");
        METHODS.showCharsStatistic(myList);
        System.out.println("The element 'eyB' is " + (METHODS.findStrIdBySubstring(myList, "eyB")+1));
        System.out.println("The second list is: " +mySecondList);
        System.out.println("Comparing first and second elements of 2'nd list:" + mySecondList.compareInnerObjects(1,2));
        System.out.println("The elements lengths are: ");
        METHODS.showStringLengths(mySecondList);
    }
}