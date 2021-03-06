# 卷一 第三章(8)

## 3.10 数组

1. **数组**是一种数据结构，用来存储**同一类型**值的集合。通过一个**整型**下标可以访问数组中的每一个值，下标可以是负数，但是所指向的内存地址不正确，运行时会报错。

2. 在声明数组变量时，需要指出数组类型(数据元素类型紧跟[])和数组变量的名字。例如：```int[] a;```

3. 初始化应该用new运算符创建数组。例如：```int[] a = new int[n];```。n为数组长度，n可以是表达式，可以不要求是常量，但必须结果是整型，n可以等于负数，编译可以通过，但是运行后会出错。例如：```int[] a = new int[1+1.3];```，这个语句会编译不通过。

4. 创建一个数字(byte,short,int,long,float,double)数组时，所有元素初始化为0。boolean数组的元素初始化为false。char数组的元素初始化为**空(?)**，对象(Byte,Short,Integer,Long,Float,Double,String,Character等)元素数组初始化为null，表示这些元素还未存放任何对象。例如：

   ```java
   byte[] b1 = new byte[1];
   short[] s1 = new short[1];
   int[] i1 = new int[1];
   long[] l1 = new long[1];
   float[] f1 = new float[1];
   double[] d1 = new double[1];
   char[] c1 = new char[1];
   boolean[] booleans = new boolean[1];
   Byte[] b12 = new Byte[1];
   Short[] s12 = new Short[1];
   Integer[] i12 = new Integer[1];
   Long[] l12 = new Long[1];
   Float[] f12 = new Float[1];
   Double[] d12 = new Double[1];
   Character[] c12 = new Character[1];
   Boolean[] booleans2 = new Boolean[1];
   String[] strings = new String[1];
   for (int i = 0; i < b1.length; i++) {
       System.out.println(b1[i]);
   }
   for (int i = 0; i < s1.length; i++) {
       System.out.println(s1[i]);
   }
   for (int i = 0; i < i1.length; i++) {
       System.out.println(i1[i]);
   }
   for (int i = 0; i < l1.length; i++) {
       System.out.println(l1[i]);
   }
   for (int i = 0; i < f1.length; i++) {
       System.out.println(f1[i]);
   }
   for (int i = 0; i < d1.length; i++) {
       System.out.println(d1[i]);
   }
   for (int i = 0; i < c1.length; i++) {
       System.out.println(c1[i]);
   }
   for (int i = 0; i < booleans.length; i++) {
       System.out.println(booleans[i]);
   }
   for (int i = 0; i < b12.length; i++) {
       System.out.println(b12[i]);
   }
   for (int i = 0; i < s12.length; i++) {
       System.out.println(s12[i]);
   }
   for (int i = 0; i < i12.length; i++) {
       System.out.println(i12[i]);
   }
   for (int i = 0; i < l12.length; i++) {
       System.out.println(l12[i]);
   }
   for (int i = 0; i < f12.length; i++) {
       System.out.println(f12[i]);
   }
   for (int i = 0; i < d12.length; i++) {
       System.out.println(d12[i]);
   }
   for (int i = 0; i < c12.length; i++) {
       System.out.println(c12[i]);
   }
   for (int i = 0; i < booleans2.length; i++) {
       System.out.println(booleans2[i]);
   }
   for (int i = 0; i < strings.length; i++) {
       System.out.println(strings[i]);
   } 
   ```

5. 一旦创建了数组，就**不能**再改变它的大小。

### 3.10.1 for each循环
1. for(variable : collection) statement
2. 用来一次处理数组中的每个元素。
3. collection这一集合表达式必须是一个数组或者一个实现了Iterable接口的类对象。例如ArrayList。

### 3.10.2 数组初始化以及匿名数组
```java
int[] smallPrimes = { 2, 3, 4, 5, 6, 7, 11, 13 };// 1.
new int[] {2, 3, 5, 7, 8};// 2.
smallPrimes = new int[] {2, 3, 5, 7, 8};// 3.
```

第一条语句为Java提供的一种创建数组对象并同时赋予初始值的简化书写形式，这种方式不需要调用new。

第二条语句为初始化一个匿名的数组(没有变量名的数组)，但是编译会出错。

第三条语句就是利用初始化匿名数组在不创建新变量的情况下重新初始化一个数组。

<span style="color:red">注意：</span>在Java中，允许数组长度为0。

### 3.10.3 数组拷贝

1. 允许一个**数组变量拷贝**给另一个数组变量。此时，两个变量将**引用同一个**数组。

   ```java
   int[] i1 = new int[1];
   int[] i13 = i1;
   System.out.println(i13[0]);
   i1[0]++;
   System.out.println(i13[0]);
   ```

   此时，i1[0] = i13[0] = 7;且引用的同一个地址里存放的值。

2. 如果希望将一个数组中的所有值拷贝到一个新的数组中去，使用Arrays类的copyof方法。

   ```java
   int[] i1 = new int[1];
   int[] i14 = Arrays.copyOf(i1, i1.length);
   i14[0]++;
   System.out.println(i1[0]);
   System.out.println(i14[0]);
   ```

   此时，i[0] ≠ i14[0] = 1;且引用的不同一个地址里存放的值。

   Arrays.copyOf(需要copy的数组，新数组的长度);

   如果数组元素是数值型，那么多余的元素将被赋值0；如果是布尔型，将赋值false；如果小于原数组长度，只拷贝最前面的数据元素。

### 3.10.4 命令行参数
main方法的入参为String类型的数组，使用命令行 java Message -g kkk yyy，那么将传进三个字符串，值分别为："-g"、"kkk"、"yyy"

### 3.10.5 数组排序

1. 数值型数组排序，可以使用Arrays类中的sort方法。

2. static void fill(type[], type v)：将数组的**所有**元素都设置为v。

3. static boolean equals(type[] a, type[] b)：两个数组**大小相同**，且**下标相同的元素都对应相等**，才会返回true。

### 3.10.6 多维数组(略)
### 3.10.7 不规则数组(略)
