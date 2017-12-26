package io.github.johnshen1990.javacodelab.javabasic.fileDelete;

import java.util.*;

public class File {
    private String name;

    private boolean directoryFlag;

    private List<File> subFiles;

    private File parent;

    public File(String name, boolean directoryFlag, List<File> subFileList) {
        this.name = name;
        this.directoryFlag = directoryFlag;
        this.subFiles = subFileList;
    }

    public boolean isDirectory() {
        return directoryFlag;
    }

    public List<File> getSubFiles() {
        return subFiles;
    }
    public void setParent(File parent) {
        this.parent = parent;
    }

    public void delete() {
        if(this.directoryFlag && !this.subFiles.isEmpty()) {
            return;
        }
        if(this.parent != null) {
            List<File> siblings = this.parent.subFiles;
            List<File> newList = new ArrayList<>();
            for(File file : siblings) {
                if(!file.equals(this)) {
                    newList.add(file);
                }
            }
            this.parent.subFiles = newList;
            this.parent = null;
        }
        System.out.println(this.name + " deleted");
    }

    /**
     * File.isDirectory() 是否为目录
     * File.delete() 文件或空目录直接删除，非空目录跳过
     * File.getSubFiles() 文件返回null，空目录返回空集，非空目录返回子文件和目录的集合
     */


    /**
     * recusive delete the target and all subFiles of target
     */
    public static void recusiveDelete(File target) {
        if(target == null) {
            return;
        }

        // dir
        if(target.isDirectory()) {
            // delete all subFiles
            List<File> subFileList = target.getSubFiles();
            for(File file : subFileList) {
                recusiveDelete(file);
            }
            // delete empty dir itself
            target.delete();
            return;
        }

        // file
        target.delete();
    }

    /**
     * recusive delete the target and all subFiles of target with stack
     */
    public static void recusiveDeleteWithStack(File target) {
        if(target == null) {
            return;
        }

        Stack<File> stack = new Stack<>();
        stack.push(target);

        while(!stack.isEmpty()) {
            File file = stack.pop();
            // file or empty dir
            if(!file.isDirectory() || (file.isDirectory() && file.getSubFiles().isEmpty())) {
                file.delete();
                continue;
            }
            // non-empty dir
            stack.push(file);
            for(File child : file.getSubFiles()) {
                stack.push(child);
            }
        }
    }

    /**
     * - dir1
     *      - dir2
     *      - dir3
     *          - file1
     *          - file2
     *          - dir4
     * @param args
     */
    public static void main(String[] args) {
        File file1 = new File("file1", false, null);
        File file2 = new File("file2", false, null);
        File dir4 = new File("dir4", true, Collections.EMPTY_LIST);

        File dir2 = new File("dir2", true, Collections.EMPTY_LIST);
        File dir3 = new File("dir3", true, Arrays.asList(file1, file2, dir4));


        File dir1 = new File("dir1", true, Arrays.asList(dir2, dir3));

        file1.setParent(dir3);
        file2.setParent(dir3);
        dir4.setParent(dir3);

        dir3.setParent(dir1);
        dir2.setParent(dir1);

        dir1.setParent(null);

        recusiveDelete(dir1);
//        recusiveDeleteWithStack(dir1);
        System.out.println();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return Objects.equals(name, file.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
