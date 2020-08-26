package ListDemo;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//跳过泛型检测对list赋值
public class Demo1 {
    public static void main(String[] args) {
//        ArrayList<String > list = new ArrayList<String>();
//        //ArrayList list = new ArrayList();
//        //Class c = list.getClass();
//        //Test t = new Test();
//        Class c;
//
//        {
//            try {
//                c = list.getClass();
//                Method m = c.getMethod("add",Object.class);
//                m.invoke(list,2);
//                System.out.println(list);
//            } catch ( NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }

        Class c = null;
        c=Test.class;
        try {
            Method m = c.getDeclaredMethod("getInt", int.class);
            //获取方法返回类型
            Class[] type = m.getParameterTypes();
            for (int i=0;i<type.length;i++){
                System.out.println(type[i].getName());
            }
            m.setAccessible(true);
            System.out.println(m.invoke(c.newInstance(),1));
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


//        ClassLoader c1 = null;
//        try {
//            Class c2 = c1.loadClass("ListDemo.Test");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }


    }


}
