假设Bozo类的构造函数原型如下：

```c++
Bozo(const char * fname, const char * lname)
```

则有以下方法可以初始化对象：

```c++
Bozo bozetta = Bozo("Bozzeta", "Biggens");

Bozo fufu("Fufu", "O'Dweeb");

Bozo *popo = new Bozo("Popo", "Le peu");
```

如果编译器支持C++11，则可以使用列表初始化：

```c++
Bozo bozetta = {"Bozzeta", "Biggens"};

Bozo fufu{"Fufu", "O'Dweeb"};

Bozo *popo = new Bozo{"Popo", "Le peu"};
```

对于未被初始化的对象，程序将使用默认的构造函数来创建：

```c++
Bozo bubi;

Bozo *popo = new Bozo;
```


#### 成员初始化列表

```c++
BrassPlus::BrassPlus(const string & s, long an, double bal, double ml, double r) : Brass(s, an, bal)
{
    maxLoan = ml;
    owesBank = 0.0;
    rate = r;
}
```

> 作用域解析运算符 **::**

1. 使用对象调用函数
```c++
Brass dom("Dominic Banker", 11224, 2592.00);
dom.ViewAcct();
```

2. 使用引用调用函数
```c++
Brass dom("Dominic Banker", 11224, 2592.00);
Brass & b1_ref = dom;
b1_ref.ViewAcct();
```

3. 使用指针调用函数
```c++
BrassPlus ophelia;
Brass * bp;
bp = &ophelia;
bp->ViewAcct();
```

---

#### 虚函数和虚析构函数

基类应该包含一个虚析构函数，因为基类的指针指向一个派生类对象时，将调用派生类的析构函数，然后自动调用基类的析构函数。

---

#### 静态编联和动态编联

- [x] 静态编联: 指针类型在编译期可知，因此，编译器在编译时，可以将fun()函数关联到Class::fun()

- [x] 动态编联: 对象类型通常只有在程序运行时可知，因此，只有在程序运行的时候，才能根据对象类型将fun()函数关联到Class::fun()

虚函数的工作原理：
编译器为虚函数所属的类创建一个虚函数表，虚函数表中存储了虚函数的地址，编译器会为每个类的对象添加一个隐藏成员，该成员中保存了一个指向虚函数表的指针。

---


