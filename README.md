# EasyLibrary

一个简单的工具依赖库

## 使用步骤

### 一、添加依赖

Step 1. 项目工程的build.gradle，添加jitpack库

```groovy
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
```
  
Step 2. 模块的build.gradle，添加EasyLibrary依赖库

```groovy
dependencies {
	implementation 'com.github.lilongweidev:EasyLibrary:1.0.2'
}
```

Step 3. 初始化EasyLibrary依赖库，建议在Application中的onCreate中进行

```java
    //Easy初始化
    Easy.initialize(this);
```

### 二、功能介绍

陆续增加工具类、API方法中，多提意见和需求，谢谢。


 API      | 功能描述     
 -------- | :-----------:  
 EasyAnimation     | 简单动画使用
 EasyDate     | 日期时间星期使用
 EasySize     | dp、px转换
 EasySP     | 本地缓存使用
 EasyToast  | Toast使用  
     


