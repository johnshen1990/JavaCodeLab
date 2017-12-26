package io.github.johnshen1990.javacodelab.javabasic.bit;

/**
 * Author: zhun.shen
 * Date: 2016-11-14 11:19
 * Description:
 */
public class BitTest {
    private static final long READ = 1;
    private static final long WRITE = 1<<1;
    private static final long EXECUTE = 1<<2;

    public static long setFlag(long... permissionList){
        long flag = 0L;
        for(long permission : permissionList){
            flag |= permission;
        }
        return flag;
    }

    public static void printFlag(long flag){
        if(flag == 0){
            System.out.println("Flag hasn't any permission!");
            return;
        }
        if((flag & READ) == READ){
            System.out.println("Flag has READ permission!");
        }
        if((flag & WRITE) == WRITE){
            System.out.println("Flag has WRITE permission!");
        }
        if((flag & EXECUTE) == EXECUTE){
            System.out.println("Flag has EXECUTE permission!");
        }
    }

    public static void main(String[] args) {
        long flag = setFlag(READ, EXECUTE);
        printFlag(flag);
    }
}
