package reflection;

import java.lang.reflect.Field;

public class ReflectionTest {
    public static void main(String[] args) throws Exception{
        TestClass testClass = new TestClass();
        testClass.setSuperString("Father");
        testClass.setSonString("Son");
        Field son = getSuperClass(testClass,"sonString");
        // 可以通过 field.getType() 获取字段类型
        System.out.println(son.get(testClass));
        Field father = getSuperClass(testClass,"superString");
        System.out.println(father.get(testClass));
        try {
            getSuperClass(testClass, "noExist");
        }catch (NoSuchFieldException e){
            System.out.println("没找到字段");
        }
    }

    public static Field getSuperClass(Object object,String key) throws Exception{
        // 通过反射获取字段，递归到父类
        Class clazz = object.getClass();
        return getFeild(clazz,key);
    }

    public static Field getFeild(Class clazz,String key) throws Exception {
        try{
            Field field = clazz.getDeclaredField(key);
            // 设置字段可访问， 否则无法访问private修饰的变量值
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e){
            // 递归到没有父类还找不到字段则抛出异常
            if(clazz.getSuperclass() != null) {
                return getFeild(clazz.getSuperclass(), key);
            }else{
                throw e;
            }
        }
    }
}
