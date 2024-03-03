### 损失函数

损失函数（Loss Function）的作用就是计算神经网络每次迭代的**前向计算**结果（预测值）与真实值（标签值）的差距，从而指导下一步的训练向正确的方向进行。

m是样本数，a是预测值，y是样本标签值，loss是单个样本的误差值，J是损失函数值。

1. 0-1损失函数

$$
J= \sum_{i=1}^m loss, \quad
loss=
\begin{cases}
0 & a = y \\
1 & a \ne y
\end{cases}
$$

2. 绝对值损失函数

$$
J= \sum_{i=1}^m loss, \quad loss = |y-a|
$$

3. 铰链/折页损失函数或最大边界损失函数，主要用于SVM（支持向量机）中

$$
J= \sum_{i=1}^m loss, \quad loss=\max(0,1-y \cdot a),y=\pm 1
$$

4. 对数损失函数，又叫交叉熵损失函数

$$
J= \sum_{i=1}^m loss, \quad loss=-[y \cdot \ln (a) + (1-y) \cdot \ln (1-a)],
y=
\begin{cases}
0 \\
1
\end{cases}
$$

5. 均方差损失函数

$$
J= \sum_{i=1}^m loss, \quad loss=(a-y)^2
$$

6. 指数损失函数

$$
J= \sum_{i=1}^m loss, \quad loss = e^{-(y \cdot a)}
$$


#### 神经网络中常用的损失函数

- 均方差函数，主要用于**回归**

- 交叉熵函数，主要用于**分类**

二者都是非负函数，极值在底部，用梯度下降法可以求解。