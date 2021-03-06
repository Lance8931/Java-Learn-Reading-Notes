# 卷一 第三章(7)

## 3.8 控制流程

### 3.8.1 块作用域

1. 块：即复合语句，由一对大括号括起来的若干条简单的Java语句。

2. 块确定了变量的作用域。

3. 一个块可以嵌套在另一个块中。

4. 不能在嵌套的两个块中声明同名的变量。
### 3.8.2 条件语句

if (condition) statement

### 3.8.3 循环语句

1. while (condition) statement
   1. 当条件为true时，while循环执行一条语句或一个语句块。
   2. 当条件为false时，while循环体一次也不执行。

2. do statement while (condition)
   1. 先执行语句或一个语句块，再检测循环条件。

   2. 循环体至少执行一次。
### 3.8.4 确定循环
1. for(第一部分; 第二部分 ; 第三部分 )

   1. for循环语句是支持迭代的一种通用结构，利用每次迭代之后更新的计数器或类似的变量来控制迭代次数。

   2. 第一部分通常用于对计数器的初始化；第二部分给出每次新一轮循环执行前要检测的循环条件；第三部分指示如何更新计数器
       <span style="color:red">警告：</span> 在循环中，检测两个浮点数是否相等需要格外小心。因为舍入的误差，小数位可能得不到精确值。导致无限循环。

     ```java
     for(double x = 0; x!= 10; x+=0.1)
     ```

     其中的0.1无法精确地使用二进制表示。所以当x从9.999999加0.1时，此时x值将为10.09999998。导致无限循环。

### 3.8.5 多重选择：switch语句

```java
switch (key) {
    case value:
		......
        break;
    case value1:
		......
        break;
    default:
        ......
        break;
}
```

1. switch语句将从与选项值相匹配的case标签处开始执行直到遇到break语句，或者执行到switch语句的结束处为止。如果没有相匹配的case标签，而有default子句，就执行这个子句。

2. case标签可以是：

   - 类型为char、byte、short或int的常量表达式→char/byte/short/int的计算表达式：

     ```java
     final char c = 0;
     switch (c + 1){
     case c+4:
     	......
         break;
     default:
     	break;
     }
     ```

   - 枚举常量。判断的是枚举值的序列值。Enum.ordinal()。不必在每个标签中指明枚举名

     ```java
     enum Size {SMALL,MEDIUM,LARGE,EXTRA_LARGE};
     public class LoopTest {
     	public static void main(String[] args) {
     		Size k = Size.EXTRA_LARGE;
     		switch (k) {
     		case EXTRA_LARGE:
     			System.out.println(0);
     			break;
     		case LARGE:
     			System.out.println(1);
     			break;
     		case SMALL:
     			System.out.println(2);
     			break;
     		default:
     			break;
     		}
     	}
     }
     ```
   - 从Java SE 7 开始，case标签还可以是字符串字面量。判断的是字符串的hashcode值。

### 3.8.6 中断控制流程语句

1. 不带标签的break语句。它可以用于退出当前循环。

2. 带标签的break语句。可以用于跳出多重嵌套的循环语句。同时，标签必须放在希望跳出的最外层循环之前，并且必须紧跟一个冒号。

   ```java
   Scanner in = new Scanner(System.in);
   int n;
   read_data: while (1 > 0) {
       for (;;) {
           System.out.println("Enter a number >=0");
           n = in.nextInt();
           if (n < 0) {
               break read_data;
           }
       }
   }
   System.out.println("Finish");
   in.close();
   ```

   以上例子，在输入小于0的数字时，才会跳出循环。执行打印finish语句。

   <span style="color:blue">注释：</span>可以将标签应用到任何语句中，甚至可以应用到if语句或块语句中。

3. continue语句。中断正常的控制流程。

   1. 将控制转移到**最内层循环的首部**，即越过了当前循环体的剩余部分，立刻跳到循环体的首部。

   2. 如果是在for循环，则是跳到第三部分，“更新”部分。

## 3.9 大数值(BigInteger/BigDecimal)

1. 如果基本的整数和浮点数精度不能满足需求
2. 存在于java.math的包中。
3. 处理包含**任意长度数字序列的数值**
4. BigInteger任意精度的整数运算、BigDecimal任意精度的浮点数计算
5. 使用add/subtract/multiply/divide/mod代表了和、差、积、商、余数算法。
6. int compareTo(other)：相等返回0；小于返回负数；大于返回正数。
