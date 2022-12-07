package org.bsuir.lab8;

import java.io.IOException;

public class MethodsToWork {

    private final Reader reader = new Reader();

    public void reverseAll(MyList list){
        for (int i = 0; i < list.size(); i++) {
            list.set(i, new String((new StringBuilder(list.get(i)).reverse())));
        }
    }

    public void showDuplicatesWithCount(MyList list){
        MyList cloneList = new MyList(list);
        while(cloneList.size()>0){
            String elem = cloneList.get(0);
            int oldSize = cloneList.size();
            while(cloneList.remove(elem));
            System.out.println(elem+" - appears "+ (oldSize - cloneList.size()) + " times in the list");
        }
    }

    public void showCharsStatistic(MyList list){
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(stringBuilder::append);
        String str = new String(stringBuilder).replaceAll("\\s+", "");
        while(str.length()>0){
            String ch = str.substring(0, 1);
            String oldStr = str;
            str = str.replaceAll(ch, "");
            System.out.println("<< " + ch + ">>" + " symbol appears "+ (oldStr.length() - str.length()) + " times");
        }
    }

    public int findStrIdBySubstring(MyList list, String str){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).contains(str)){
                return i;
            }
        }
        return -1;
    }

    public void showStringLengths(MyList list) {
        for (String s : list) {
            System.out.println(s.length());
        }
    }

    public MyList readFileToSuperListAndPrint(String fileName) throws IOException{
        MyList myList = new MyList();
        myList.addAll(reader.readFileToList(fileName));
        System.out.println("String from "+fileName);
        myList.forEach(System.out::println);
        return myList;
    }
}


