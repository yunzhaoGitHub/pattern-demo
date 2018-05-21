package com.yunzhao.proxy.custom;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyProxy {

    // 换行
    private static final String ln = "\r\n";


    // 获取实例的过程
    public static Object newProxyInstance(MyClassLoader classLoader,Class<?> [] interfaces,MyInvocationHandler h){

        try {
            // 1.动态生成.java文件
            String src = generateSrc(interfaces);

            // 2.java文件输出到磁盘上
            String filePath = MyProxy.class.getResource("").getPath();
            System.out.println(filePath);
            File f = new File(filePath + "$proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();

            // 3.将java文件编译程.class文件
            // 获取java编译器
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            // 4.将编译生成的.class文件加载到JVM中
            Class proxyClass =  classLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(MyInvocationHandler.class);
            f.delete();

            // 5.返回字节码重组以后的代理对象
            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {

        // 写java文件
        StringBuffer sb = new StringBuffer();

        // 包名
        sb.append("package com.yunzhao.proxy.custom;" + ln);
        //依赖包
        sb.append("import com.yunzhao.proxy.custom.CustomPerson;" + ln);
        sb.append("import java.lang.reflect.Method;" + ln);
        // 类名
        sb.append("public class $proxy0 implements " + interfaces[0].getName() + "{" + ln);

            sb.append("MyInvocationHandler h;" + ln);

            // 构造方法
            sb.append("public $proxy0(MyInvocationHandler h) { " + ln);

                sb.append("this.h = h;");

            sb.append("}" + ln);

            for (Method m : interfaces[0].getMethods()){
                sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "() {" + ln);
                    sb.append("try{" + ln);
                        sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + ln);
                        sb.append("this.h.invoke(this,m,null);" + ln);
                            sb.append("}catch(Throwable e){" + ln);
                            sb.append("e.printStackTrace();" + ln);
                            sb.append("}");
                sb.append("}");
            }

        sb.append("}");

        return sb.toString();
    }
}
