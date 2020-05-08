## 1 通信方式演进：

一对一，点对点（集中式通讯方式）：

 <img src="C:\Users\Administrator\Desktop\java\计算机网络\image\5da957580001373104200384.png" alt="图片描述" style="zoom:33%;" /> 

达到多人之间的通信（网状通信形式，一个节点出问题可以走其他节点）：

 <img src="C:\Users\Administrator\Desktop\java\计算机网络\image\5da957670001bc8303330302.png" alt="图片描述" style="zoom:33%;" /> 

## 2 OSI七层模型及作用简介：

![New Mockup 1](C:\Users\Administrator\Desktop\java\计算机网络\image\New Mockup 1.png)

## 3 物理层（Physical）

### 3.1 传输介质：

![物理层的传输介质](C:\Users\Administrator\Desktop\java\计算机网络\image\物理层的传输介质.png)

### 3.2 网络拓扑

网络拓扑其实有好几种，但一般来说分为三种：

总线拓扑：BusTopology。bus是“总线，公共汽车”的意思。总线拓扑中信息流的形式就很像公共汽车来回开动、到站停靠，每台连接总线的机器就像站台上等车的乘客；

 <img src="C:\Users\Administrator\Desktop\java\计算机网络\image\5da95a0100017ae404540346.png" alt="图片描述" style="zoom:33%;" /> 

环型拓扑：RingTopology。ring是“环，指环，环型的”的意思；

 <img src="C:\Users\Administrator\Desktop\java\计算机网络\image\5da95a090001284104980406.png" alt="图片描述" style="zoom:33%;" /> 

星型拓扑（当今用得最多的）：StarTopology。Star是“星星，星型的”的意思；

 <img src="C:\Users\Administrator\Desktop\java\计算机网络\image\5da95a120001101c04880432.png" alt="图片描述" style="zoom:33%;" /> 

3.3 CSMA/CD

CSMA/CD 是 Carrier Sense Multiple Access / Collision Detection 的缩写，表示“带有冲突检测的载波侦听多路存取”。

## 4 数据链路层

### 4.1 mac地址

 MAC（Media Access Control, [介质访问控制](https://baike.baidu.com/item/介质访问控制/10081534)）地址是识别[LAN](https://baike.baidu.com/item/LAN)（局域网）节点的标识。网卡的物理地址通常是由网卡生产厂家烧入网卡的EPROM（一种[闪存芯片](https://baike.baidu.com/item/闪存芯片/10365487)，通常可以通过程序擦写），它存储的是传输数据时真正赖以标识发出数据的电脑和接收数据的[主机](https://baike.baidu.com/item/主机/455151)的地址。 

### 4.2 以太网协议

### 4.3 传输数据格式——数据帧

 ![图片描述](C:\Users\Administrator\Desktop\java\计算机网络\image\5dc0f0990001c8ef16640166.png) 

最小长度：64B

最大长度：1515B

最小数据帧的设计原因和以太网电缆长度有关,为的是让两个相距最远的站点能够感知到双方的数据发生了碰撞;最远两端数据的往返时间就是争用期,以太网的争用期是51.2微妙,正好发送64byte数据。 