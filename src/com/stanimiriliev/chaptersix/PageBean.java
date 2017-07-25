package com.stanimiriliev.chaptersix;

import java.util.ArrayList;
import java.util.List;

/**
 * This class receive list and divide it to pages
 * @author Stanimir Iliev
 * @since 24.07.2017
 */
public class PageBean <T>{

    private final List<T> src;
    public final int pageSize;
    private int upIndex = -1;
    private int downIndex;
    private int pageIndex = -1;
    private boolean hasNext = true, hasPrevious = false;
    private List<T> list;

    public PageBean(List<T> src, int pageSize){
        if(src == null || src.size() == 0 || pageSize <= 0)
            throw new IllegalArgumentException("This error may occur because of several things:\n" +
                    "Source list is null\nSource list is empty\nPage size is less than or equal to zero");
        this.src = src;
        this.pageSize = pageSize;
    }

    /**
     * Check if the downIndex or upIndex has reached the its limits
     * and updates hasPrevious and hasNext variables
     */
    private void check(){
        if(downIndex == 0)
            hasPrevious = false;
        if(upIndex == src.size() - 1)
            hasNext = false;
        if(upIndex < src.size() - 1 && downIndex > 0){
            hasNext = true;
            hasPrevious = true;
        }
    }

    /**
     * Reverses order of the elements of the list
     * @param list -> The list which will be reversed
     * @return reversed list
     */
    private List<T> reverseList(List<T> list){
        List<T> temp = new ArrayList<>();
        for(int i = list.size() - 1; i >= 0; i--)
            temp.add(list.get(i));
        return temp;
    }

    /**
     * Go to the next page
     * @return list with the next n elements of the source list (n -> page size)
     */
    public List<T> next(){
        if(hasNext){
            list = new ArrayList<>();
            for(int i = downIndex = upIndex + 1; i < src.size() && i < upIndex + 1 + pageSize; i++)
                list.add(src.get(i));
            upIndex = downIndex + list.size() - 1;
            check();
            pageIndex++;
            return list;
        }
        System.out.println("There is no next page!");
        return new ArrayList<T>();
    }

    /**
     * Go to the previous page
     * @return list with the previous n elements of the source list (n -> page size)
     */
    public List<T> previous(){
        if(this.hasPrevious){
            this.list = new ArrayList<>();
            for(int i = upIndex = downIndex - 1; i >= 0 && i > downIndex - 1 - pageSize; i--)
                list.add(src.get(i));
            downIndex = upIndex - list.size() + 1;
            check();
            pageIndex--;
            return reverseList(list);
        }
        System.out.println("There is no previous page!");
        return new ArrayList<T>();
    }

    public boolean hasNext(){
        return hasNext;
    }

    public boolean hasPrevious(){
        return hasPrevious;
    }

    /**
     * Returns first page and make it current page
     * @return list with the first n elements of the source list (n -> page size)
     */
    public List<T> firstPage(){
        hasNext = true;
        list = new ArrayList<>();
        for(int i = downIndex = 0; i < src.size() && i < pageSize; i++)
            list.add(src.get(i));
        upIndex = downIndex + list.size() - 1;
        pageIndex = 0;
        check();
        return list;
    }

    /**
     * Returns last page and make it current page
     * @return list with the last n elements of the source list (n -> page size)
     */
    public List<T> lastPage(){
        hasPrevious = true;
        upIndex = src.size() - 1;
        if(src.size() % pageSize == 0){
            if(upIndex > pageSize)
                downIndex = upIndex - pageSize + 1;

        }
        else{
            downIndex = upIndex - src.size() % pageSize + 1;
        }
        list = new ArrayList<>();
        for(int i = upIndex; i >= 0 && i >= downIndex; i--)
            list.add(src.get(i));
        pageIndex = src.size() / pageSize;
        if(src.size() % pageSize == 0)
            pageIndex--;
        check();
        return reverseList(list);
    }

    public int getCurrentPageNumber(){
        return pageIndex + 1;
    }
}