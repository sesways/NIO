package Buffer;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @Description：
 * 在java的nio中负责数据的存取；缓冲区的底层就是数组，根据数据类型的不同，
 * java提供相应的buffer，例如：ByteBuffer，CharBuffer，IntBuffer等；
 * 这些缓冲区的管理方式几乎一致；
 *
 * 属性介绍：
 * capacity：缓冲区的长度
 * limit：缓冲区的界限，即可以读取的位置；
 * position：缓冲区指针的位置；
 * mark：记录position的位置；reset()
 *
 * @Author：ZC
 * @Email: chao_actor@163.com
 * @TIME: 2018/12/30 20:32
 */
public class TestBuffer {
    
    public static void testBuffer(){
        String str = "abcde";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
//        1、查看buffer中的属性值；
        System.out.println("<===========buffer属性=============>");
        System.out.println("capacity:" + buffer.capacity());
        System.out.println("limit:" + buffer.limit());
        System.out.println("position:" + buffer.position());
//        2、写入数据后查看buffer中的属性值；
        System.out.println("<===========put()=============>");
        buffer.put(str.getBytes());
        System.out.println("capacity:" + buffer.capacity());
        System.out.println("limit:" + buffer.limit());
        System.out.println("position:" + buffer.position());
//        3、切换读取模式后，查看buffer中的属性值；
        System.out.println("<===========flip()=============>");
        buffer.flip();
        System.out.println("capacity:" + buffer.capacity());
        System.out.println("limit:" + buffer.limit());
        System.out.println("position:" + buffer.position());
//        4、读取数据后，查看buffer中的属性值；
        System.out.println("<===========get()=============>");
        byte[] dst = new byte[10];
        buffer.get(dst,0,buffer.limit());
        System.out.println("结果：" + Arrays.toString(dst));
        System.out.println("数据结果：" + new String(dst,0,buffer.limit()));

        System.out.println("capacity:" + buffer.capacity());
        System.out.println("limit:" + buffer.limit());
        System.out.println("position:" + buffer.position());
//        5、重读模式后，查看buffer中的属性值；
        System.out.println("<===========rewind()=============>");
        buffer.rewind();
        System.out.println("capacity:" + buffer.capacity());
        System.out.println("limit:" + buffer.limit());
        System.out.println("position:" + buffer.position());
//        6、清除缓存后，查看buffer中的属性值；
//        注意此时缓冲区中的内容还存在。
        System.out.println("<===========clear()=============>");
        buffer.clear();
        System.out.println("capacity:" + buffer.capacity());
        System.out.println("limit:" + buffer.limit());
        System.out.println("position:" + buffer.position());
    }
}
