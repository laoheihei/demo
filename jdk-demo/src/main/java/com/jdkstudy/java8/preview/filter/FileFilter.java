package com.jdkstudy.java8.preview.filter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author llc
 * @description
 * @date 2019/12/31 15:52
 */
public class FileFilter {
    public List<File> filter(String dirPath, Predicate<File> p) {
        File[] files = new File(dirPath).listFiles();
        List<File> collect = Arrays.stream(files).filter(p).collect(Collectors.toList());
        return collect;
    }

    public static void main(String[] args) {
        String filepath = ".";
        List<File> filter = new FileFilter().filter(filepath, (File file) -> file.isHidden());
        List<File> filter1 = new FileFilter().filter(filepath, (File file) -> file.isHidden() && file.getName().endsWith(".xlsx"));


        List<File> fileList = new ArrayList<>();
        List<File> collect = fileList.stream().filter(file -> file.isFile() && file.getName().endsWith(".xlsx")).collect(Collectors.toList());


        Map<String, List<File>> filenameAndFileMap = Arrays.stream(new File(".").listFiles())
                .filter(file -> file.isFile()).collect(groupingBy(File::getName));



    }
}
