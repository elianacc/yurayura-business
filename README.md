# YuraYura-Business



## 简介

> 本项目为网站B端部分，旨在为B端页面展示部分提供数据查看及操作接口等支持
>
> 项目内代码分布按照分布式多模块设计，易于编写及修改，API设计规范参考RESTful风格
>
> B端页面展示部分-Vue CLI 4项目地址：https://github.com/elianacc/yurayura-business-vue

## 项目目录介绍

```apl
yurayura-business
├── yurayura-business-api-commons（通用entity、vo、dto等整合）
├── yurayura-business-codegenerator（代码生成器）
├── yurayura-business-core（自定义组件、切面、配置等整合）
└── yurayura-business-service（controller-service-dao）
```

## 项目技术构成

- ​    总体： SpringBoot2.x
- ​    数据库持久层： mybatis + mybatis plus
- ​    自动生成代码工具： mybatis plus generator（mpg）
- ​    分页工具： mybatis pagehelper
- ​    权限认证授权框架： shiro
- ​    分布式锁：lock4j
- ​    日志： logback
- ​    项目构建： Maven
- ​    代码简化工具： lombok
- ​    数据库连接池： HikariCP
- ​    数据库： MySQL80
- ​    NoSQL数据库： Redis
- ​    在线接口文档生成： knife4j（swagger2增强）
- ​    JSON处理工具： fastjson
- ​    测试工具： junit5

## 常用功能实现

- ​    全局捕获异常处理
- ​    AOP统一处理Web请求日志
- ​    防止重复提交表单数据
- ​    分布式session共享
- ​    外部静态资源访问处理
- ​    通用接口返回信息处理
- ​    发送Email服务
- ​    跨域处理
- ​    系统数据字典
- ​    系统菜单设置
- ​    系统管理员角色分配
- ​    系统角色分配权限
- ​    系统权限管理

## 开发工具

- ​    开发环境： JDK 1.8
- ​    编码： IntelliJ IDEA（idea）
- ​    数据库可视化： Navicat Premium
- ​    Redis可视化： RedisDesktopManager
- ​    maven本地私服工具： Nexus
- ​    页面访问及调试： Google Chrome
- ​    markdown： Typora
- ​    截图： Snipaste

