# Mybatis 和 ORM 框架介绍
MyBatis 是一个 ORM（Object Relational Mapping，对象 - 关系映射）框架。ORM 框架主要是根据类和数据库表之间的映射关系，帮助程序员自动实现对象与数据库中数据之间的互相转化。说得更具体点就是，ORM 负责将程序中的对象存储到数据库中、将数据库中的数据转化为程序中的对象。实际上，Java 中的 ORM 框架有很多，除了刚刚提到的 MyBatis 之外，还有 Hibernate、TopLink 等。

在项目中使用 MyBatis，除了需要引入 MyBatis 框架本身（mybatis.jar）之外，还需要引入 JDBC 驱动（比如，访问 MySQL 的 JDBC 驱动实现类库 mysql-connector-java.jar）。

# Mybatis-plus

## 一.优势
* 无侵入：只做增强不做改变，引入它不会对现有工程产生影响，如丝般顺滑
* 损耗小：启动即会自动注入基本 CURD，性能基本无损耗，直接面向对象操作
* 强大的 CRUD 操作：内置通用 Mapper、通用 Service，仅仅通过少量配置即可实现单表大部分 CRUD 操作，更有强大的条件构造器，满足各类使用需求
* 支持 Lambda 形式调用：通过 Lambda 表达式，方便的编写各类查询条件，无需再担心字段写错
* 支持主键自动生成：支持多达 4 种主键策略（内含分布式唯一 ID 生成器 - Sequence），可自由配置，完美解决主键问题
* 支持 ActiveRecord 模式：支持 ActiveRecord 形式调用，实体类只需继承 Model 类即可进行强大的 CRUD 操作
* 支持自定义全局通用操作：支持全局通用方法注入（ Write once, use anywhere ）
* 内置代码生成器：采用代码或者 Maven 插件可快速生成 Mapper 、 Model 、 Service 、 Controller 层代码，支持模板引擎，更有超多自定义配置等您来使用
* 内置分页插件：基于 MyBatis 物理分页，开发者无需关心具体操作，配置好插件之后，写分页等同于普通 List 查询
* 分页插件支持多种数据库：支持 MySQL、MariaDB、Oracle、DB2、H2、HSQL、SQLite、Postgre、SQLServer 等多种数据库
* 内置性能分析插件：可输出 Sql 语句以及其执行时间，建议开发测试时启用该功能，能快速揪出慢查询
* 内置全局拦截插件：提供全表 delete 、 update 操作智能分析阻断，也可自定义拦截规则，预防误操作

## 二.Spring Boot整合
### 1.依赖
```
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.4.2</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.20</version>
        </dependency>
```
### 2.yml配置
```
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: root
    password:
    url: jdbc:mysql://127.0.0.1:3306/mybatis_plus?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true

```

## 三.自定义配置
[https://mp.baomidou.com/config/#%E5%9F%BA%E6%9C%AC%E9%85%8D%E7%BD%AE](https://mp.baomidou.com/config/#%E5%9F%BA%E6%9C%AC%E9%85%8D%E7%BD%AE)

## 四.CURD

## 五.注解
### 1.IdType配置
```
public enum IdType {
    AUTO(0), 
    NONE(1), 
    INPUT(2),
    ASSIGN_ID(3), 
    ASSIGN_UUID(4),
    /** @deprecated */
    @Deprecated
    ID_WORKER(3),
    /** @deprecated */
    @Deprecated
    ID_WORKER_STR(3),
    /** @deprecated */
    @Deprecated
    UUID(4);
}
```
### 2.说明
|值|描述|
|:----:|----| 
|AUTO | 数据库ID自增|
|NONE|无状态,该类型为未设置主键类型(注解里等于跟随全局,全局里约等于 INPUT)|
|INPUT|insert前自行set主键值|
|ASSIGN_ID|分配ID(主键类型为Number(Long和Integer)或String)(since 3.3.0),使用接口IdentifierGenerator的方法nextId(默认实现类为DefaultIdentifierGenerator雪花算法)|
|ASSIGN_UUID|分配UUID,主键类型为String(since 3.3.0),使用接口IdentifierGenerator的方法nextUUID(默认default方法)|
|~~ID_WORKER~~|分布式全局唯一ID 长整型类型(please use ASSIGN_ID)|
|~~UUID~~|32位UUID字符串(please use ASSIGN_UUID)|
|~~ID_WORKER_STR~~|分布式全局唯一ID 字符串类型(please use ASSIGN_ID)|

## 六.自动填充
* insertFill
* updateFill







