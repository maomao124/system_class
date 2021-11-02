import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

/**
 * Project name(项目名称)：System类
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/11/2
 * Time(创建时间)： 20:15
 * Version(版本): 1.0
 * Description(描述)： System 类位于 java.lang 包，代表当前 Java 程序的运行平台，系统级的很多属性和控制方法都放置在该类的内部。
 * 由于该类的构造方法是 private 的，所以无法创建该类的对象，也就是无法实例化该类。
 * System 类提供了一些类变量和类方法，允许直接通过 System 类来调用这些类变量和类方法。
 * System 类有 3 个静态成员变量，分别是 PrintStream out、InputStream in 和 PrintStream err。
 * 1. PrintStream out
 * 标准输出流。此流已打开并准备接收输出数据。通常，此流对应于显示器输出或者由主机环境或用户指定的另一个输出目标。
 * 例如，编写一行输出数据的典型方式是：System.out.println(data);
 * 其中，println 方法是属于流类 PrintStream 的方法，而不是 System 中的方法。
 * 2. InputStream in
 * 标准输入流。此流已打开并准备提供输入数据。通常，此流对应于键盘输入或者由主机环境或用户指定的另一个输入源。
 * 3. PrintStream err
 * 标准的错误输出流。其语法与 System.out 类似，不需要提供参数就可输出错误信息。也可以用来输出用户指定的其他信息，包括变量的值。
 * System 类的成员方法
 * System 类中提供了一些系统级的操作方法，常用的方法有 arraycopy()、currentTimeMillis()、exit()、gc() 和 getProperty()。
 * 1. arraycopy() 方法
 * 该方法的作用是数组复制，即从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束。
 * public static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length)
 * 其中，src 表示源数组，srcPos 表示从源数组中复制的起始位置，dest 表示目标数组，destPos 表示要复制到的目标数组的起始位置，length 表示复制的个数。
 * 2. currentTimeMillis() 方法
 * 该方法的作用是返回当前的计算机时间，时间的格式为当前计算机时间与 GMT 时间（格林尼治时间）1970 年 1 月 1 日 0 时 0 分 0 秒所差的毫秒数。
 * 一般用它来测试程序的执行时间。例如：
 * long m = System.currentTimeMillis();
 * 3. exit() 方法
 * 该方法的作用是终止当前正在运行的 Java 虚拟机，具体的定义格式如下：
 * public static void exit(int status)
 * 其中，status 的值为 0 时表示正常退出，非零时表示异常退出。使用该方法可以在图形界面编程中实现程序的退出功能等。
 * 4. gc() 方法
 * 该方法的作用是请求系统进行垃圾回收，完成内存中的垃圾清除。至于系统是否立刻回收，取决于系统中垃圾回收算法的实现以及系统执行时的情况。
 * public static void gc()
 * 5. getProperty() 方法
 * 该方法的作用是获得系统中属性名为 key 的属性对应的值，具体的定义如下：
 * 纯文本复制
 * public static String getProperty(String key)
 */

public class test
{
    public static int getIntRandom(int min, int max)         //空间复杂度和时间复杂度更低
    {
        if (min > max)
        {
            min = max;
        }
        return min + (int) (Math.random() * (max - min + 1));
    }

    public static int getIntRandom1(int min, int max)          //获取int型的随机数
    {
        if (min > max)
        {
            min = max;
        }
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args)
    {
        System.out.print("请输入：");
        int c;
        try
        {
            InputStreamReader in = new InputStreamReader(System.in, StandardCharsets.UTF_8);
            c = System.in.read();
            while (c != '\n')
            {
                System.out.print((char) c);
                c = System.in.read();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println();
        int[] array1 = new int[10];
        for (int i = 0; i < 10; i++)
        {
            array1[i] = getIntRandom(20, 90);
        }
        int[] array2 = new int[10];
        System.arraycopy(array1, 2, array2, 1, 6);
        for (int s1 : array1)
        {
            System.out.print(s1 + " ");
        }
        System.out.println();
        for (int s1 : array2)
        {
            System.out.print(s1 + " ");
        }
        System.out.println();
        long time = System.currentTimeMillis();
        System.out.println(time);
        for (int i = 0; i < 10000000; i++)
        {
            int s = 2;
        }
        long time1 = System.currentTimeMillis();
        System.out.println(time1);
        System.out.println(time1 - time + "毫秒");
        Runtime r = Runtime.getRuntime();
        char[] ws = new char[5000000];
        ws = null;
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //r.gc();
        System.out.println("内存清理：");
        System.gc();
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        String javaversion = System.getProperty("java.version");
        String osName = System.getProperty("os.name");
        String user = System.getProperty("user.name");
        System.out.println("Java 运行时环境版本：" + javaversion);
        System.out.println("当前操作系统是：" + osName);
        System.out.println("当前用户是：" + user);
        String javahome = System.getProperty("java.home");
        System.out.println("java安装路径：" + javahome);
        String jiagou = System.getProperty("os.arch");
        System.out.println("操作系统架构：" + jiagou);
        String dir = System.getProperty("user.dir");
        System.out.println("工作路径：" + dir);
        String userdir = System.getProperty("user.home");
        System.out.println("用户主目录：" + userdir);
        System.out.println("7秒后退出");
        try
        {
            Thread.sleep(7000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.exit(0);
        System.out.println("hello word");
        try
        {
            Thread.sleep(7000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
