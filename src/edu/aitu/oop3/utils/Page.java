package edu.aitu.oop3.utils;

import java.util.List;

public class Page<T> {
    private final List<T> content;
    private final int totalElements;
    private final int pageNumber;
    private final int pageSize;

    public Page(List<T> content, int totalElements, int pageNumber, int pageSize) {
        this.content = content;
        this.totalElements = totalElements;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public List<T> getContent() {
        return content;
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) totalElements / pageSize);
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void printPageDetails() {
        System.out.println("\n======= PAGE " + pageNumber + " OF " + getTotalPages() + " =======");
        System.out.println("Total records found: " + totalElements);
        System.out.println("---------------------------------");

        if (content.isEmpty()) {
            System.out.println("No items found on this page.");
        } else {
            for (T item : content) {
                System.out.println(item.toString());
            }
        }
        System.out.println("=================================\n");
    }
}