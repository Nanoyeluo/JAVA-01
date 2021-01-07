# 学习笔记

#### 心得：

通过字节码，发现变量没调用，照样会在字节码上占位子，所以如果不调用的字节码 可以舍去

类加载器，通过加载.class将其转化为二进制文件，使jvm可以运行。

使用 jconsole + pid 可以看运行java文件的状况

Xmx: 指定最大堆内存,这个内存不包括栈内存，也不包括堆外使用的内存。

Xms: 指定堆内存空间的初始大小

Xmn: 设置堆中年轻代堆的初始化大小和最大大小

Meta： 元数据区

DirectMemory: 堆外内存 影响NIO的直接缓存分配

Xss: 设置每个线程栈的字节数



jstack : 可以用来看进程运行中的栈

https://docs.oracle.com/javase/8/docs/technotes/tools/windows/toc.html

这个网站不错mark