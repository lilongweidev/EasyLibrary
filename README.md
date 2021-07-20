# EasyLibrary

一个简单的工具依赖库，提供App开发过程中的简单功能使用。

## 使用步骤

### 一、添加依赖

Step 1. 项目工程的build.gradle，添加jitpack库。

```groovy
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
```
  
Step 2. 模块的build.gradle，添加EasyLibrary依赖库。

```groovy
dependencies {
	implementation 'com.github.lilongweidev:EasyLibrary:1.0.4'
}
```

Step 3. 初始化EasyLibrary依赖库，建议在Application中的onCreate中进行。

```java
    //Easy初始化
    Easy.initialize(this);
```

## 网址下载

点击下载[EasyLibrary](http://d.cc53.cn/1pgd)<br>

## 扫码下载
![下载图片](https://github.com/lilongweidev/EasyLibrary/blob/master/picture/code.png)<br>

### 二、功能介绍

陆续增加工具类、API方法中，多提意见和需求，谢谢。


 API      | 功能描述     
 -------- | :-----------:  
 EasyAnimation     | 简单动画使用 位移动画、眨眼动画
 EasyDate     | 日期时间星期使用 获取年月日、时分秒、星期、
 EasySize     | dp、px转换  简化使用
 EasySP     | 本地缓存使用  简化使用
 EasyToast  | Toast使用 自定义Toast，可以修改圆角、背景、文字颜色
 EasyRegex  | 正则表达式验证工具，手机号、身份证号、QQ、邮箱、密码、账号的验证，用于注册居多
 EasyAppInfo  | App信息工具，读取包名、版本号、版本名、安装后第一次启动判断、每天第一次启动判断、读取手机上App应用列表
 EasyLog    | 日志打印工具，定位到类名、方法名、打印日志的代码行数，可以自由控制是否打印日志。
     


