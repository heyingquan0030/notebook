//brass.h

/**

在派生类和基类中，都定义了 Withdraw() 方法和 ViewAcct() 方法，使用关键字 virtual 修饰

基类版本的限定名为 Brass::ViewAcct()，派生类版本的限定名为 BrassPlus::ViewAcct()

如果使用了关键字 virtual， 通过引用或者是指针而不是对象调用方法时，程序将根据引用或指针指向的对象的类型来选择方法。

*/

#ifndef BRASS_H_
#define BRASS_H_
#include <string>

class Brass
{
private:
    std::string fullName;
    long aactNum;
    double balance;

public:
    Brass(const std::string & s = "Nullbody", long an = -1, double bal = 0.0);
    void Deposit(double amt);
    virtual void Withdraw(double amt);
    double Balance() const;
    virtual void ViewAcct() const;
    virtual ~Brass() {}
}

class BrassPlus : public Brass
{
private:
    double maxLoan;
    double rate;
    double owesbank;

public:
    BrassPlus(const std::string & s = "Nullbody", long an = -1, double bal = 0.0, double ml = 500.0, double r = 0.11125);
    BrassPlus(const Brass & ba, double ml = 500.0, double r = 0.11125);
    virtual void Withdraw(double amt);
    virtual void ViewAcct() const;

    void ResetMax(double m) { maxLoan = m; }
    void ResetRate(double r) { rate = r; }
    void ResetOwes() { owesbank = 0; }
}

#endif