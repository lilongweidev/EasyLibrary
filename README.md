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
	implementation 'com.github.lilongweidev:EasyLibrary:1.0.1'
}
```

### 二、功能介绍

目前库中有EasyToast、EasyDate、EasyAnimation，陆续增加工具类中，敬请期待。
