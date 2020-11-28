package runtime;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 强、软、弱、虚引用
 * @Author: mengchao
 * @Date: 2020/11/28 22:55
 */
public class Reference {
    public static void main(String[] args) throws InterruptedException {
        //softRef();
        phantomAndRefQueue();
    }

    /**
     * 软引用
     * 使用场景:缓存，使用时从内存获取，没有则重新构建（这不就是缓存吗）
     */
    private static void softRef() {
        List<Integer> list = getAllData();
        SoftReference<List> softReference = new SoftReference<>(list);
        //使用list的时候，先判断引用有没有被回收
        if (softReference.get() == null) {
            list = getAllData();
            softReference = new SoftReference<>(list);
        }
        System.out.println(softReference.get());
    }

    private static void phantomAndRefQueue(){
        List<Integer> list = getAllData();
        ReferenceQueue<List> referenceQueue = new ReferenceQueue<>();
        PhantomReference<List> phantomReference = new PhantomReference<>(list, referenceQueue);

        // 切断str引用和"疯狂Java讲义"字符串之间的引用
        list = null;
        // 取出虚引用所引用的对象，并不能通过虚引用获取被引用的对象，所以此处输出null。这就是虚引用的"虚"
        System.out.println(phantomReference.get());

        //实测不但要gc还要runFinalization才可以，都是建议gc，为啥？
        System.gc();
        System.runFinalization();

        //true
        System.out.println(referenceQueue.poll()==phantomReference);
    }


    private static List<Integer> getAllData(){
        return Arrays.asList(1, 2, 3);
    }
}
