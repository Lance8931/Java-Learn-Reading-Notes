# 卷一 第三章(5)

## 3.6 字符串

1. 概念上，Java字符串就是**Unicode字符序列**。

2. Java没有内置的字符串类型，而是标准Java类库中的一个**预定义类**，叫**String**。

3. **每个**用**双引号括起来**的**字符串**都是String类的**一个实例**。

### 3.6.1 子串

1. 使用substring可以从一个较大的字符串提取一个子串。

2. substring方法的第二个参数是**不想复制**的第一个位置。

3. 提取的子串也是一个String类的一个实例。
### 3.6.2 拼接
1. Java语言允许使用 + 号连接两个字符串。

2. 当一个字符串与一个非字符串的值进行拼接时，后者被转换成字符串。任何一个Java对象都可以转换成字符串。

### 3.6.3 不可变字符串
1. String类没有提供用于修改字符串的方法。如果要改变，那么可以先提取子串，再拼接需要的字符串。

2. 由于不能修改Java字符串中的字符，所以在Java文档中将**String类对象**称为**不可变字符串**。如同数字3永远是数字3一样，字符串“Hello”永远包含字符H、e、l、l、o这五个代码单元序列。

3. 不可变字符串有一个有点：编译器可以让**字符串共享**。其工作方式可以想象成将各种字符串放在**公共的存储池**中。而**字符串变量指向**存储池中相应的**位置**。如果复制一个字符串变量，原始字符串与复制的字符串共享相同的字符。

### 3.6.4 检测字符串是否相等
1. 可以使用**equals**方法检测两个字符串是否相等。s.equals(t).
2. **一定不要用 == 运算符**检测两个字符串是否相等。该运算符只能判断两个字符串的**是否放置在同一个位置上**，即该运算符只能判断两个字符串变量所指向的位置是否相同。如果字符串放置在同一个位置上，它们必然相等。但是，完全有可能将**内容相同的多个字符串的拷贝放置在不同的位置上**。例如：
```java
String greeting1 = "hello";
if (greeting1 == "hello") {
    System.out.println("true");
} else {
    System.out.println("false");
}
if (greeting1.substring(0, 3) == "hel") {
    System.out.println("true");
} else {
    System.out.println("false");
}
// 输出：
// true
// false
```
3. 实际上只有字符串*常量*(使用final修饰)是共享的，而 + 或substring等操作产生的结果并不是共享的。因此千万不要使用 == 运算符测试字符串的相等性。

### 3.6.5 空串与Null串
1. 空串 "" 是长度为0的字符串。空串是一个Java对象，有自己的串长度(0)和内容(空)。
2. String变量可以存储一个特殊的值，null。表示目前没有任何对象与该变量关联。
3. 检查一个字符串既不能是null也不为空串，可以使用： if (str != null && str.length() != 0)
### Q & A
Q: 
```java
String expletive = "Expletive";
String PG13 = "deleted";
String message = expletive + PG13;
```

在以上运算中，一共产生了几个String类的实例？

A： 3个。"Expletive"、"deleted"、"Expletivedeleted"。