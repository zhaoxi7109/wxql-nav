# 万相千络导航网站

## 前言简介

为什么会想着做一个导航网站呢？其实任何一项技术一项工具的出现都是为了解决某些问题，万相千络的出现也不例外。在平时我们时常会访问各种各样的网站，书签就是一种很好记录网站位置的方法，但是书签使用起来并不是太好，没有较好的分类，也不太好展示。在我的个人博客网站就已经实现了网站导航这一功能，但是却有着一个最大的弊端就是网站是静态的，没有后台用来动态添加和修改各个导航网站的信息，于是就有了万相千络。最大的理想是做成iTab插件的那样，但是奈何自己的能力太低，那也就成了一种奢想。

为什么要叫万相千络呢？其实光看名字本身就差不多知道了，万相与千络都有一种许多繁杂事物汇聚、交织的感觉，而导航网的作用也就是将各种自己中意的网站放到一起统一管理，由此不谋而合便有了万相千络命名来源。

万相千络源码可以说完全来源于格姗导航，主要涵盖了Spring Boot、MyBatis Plus、Vue3、Element Plus 等技术，由于我个人技术水平较有限，仅在原基础上作了略微的修改请。详情可以查看文章底部的更新日志。

在线演示地址：https://zhaoxi.icu/wxql-nav。

本地导航首页：http://127.0.0.1:8023

本地登录地址：[http://127.0.0.1:8023/login](http://127.0.0.1:8023.login)

默认用户：admin   默认密码：123456

个人QQ：2997605126

码云下载地址（国内推荐）：https://gitee.com/zhaoxi7109/wxql-nav

Github 下载地址：https://github.com/zhaoxi7109/wxql-nav

前端端口8023，后端端口8083

## 技术选型

前端：

| 说明                   | 官网                                        |
| ---------------------- | ------------------------------------------- |
| 前端框架               | https://vuejs.org                           |
| 路由框架               | https://router.vuejs.org                    |
| 全局状态管理框架       | https://vuex.vuejs.org                      |
| 前端 Element Plus 框架 | https://element-plus.gitee.io               |
| 前端 Http 框架         | https://github.com/axios/axios              |
| 富文本编辑器           | https://www.wangeditor.com                  |
| 代码语法高亮插件       | https://github.com/highlightjs/highlight.js |

后端：

| 技术            | 说明                       | 官网链接                                   |
| --------------- | -------------------------- | ------------------------------------------ |
| Spring Boot     | MVC 框架                   | https://spring.io/projects/spring-boot     |
| Spring Security | 认证和授权安全框架         | https://spring.io/projects/spring-security |
| MyBatis Plus    | ORM 框架                   | https://mp.baomidou.com                    |
| Knife4j         | 接口文档管理框架           | https://doc.xiaominfo.com                  |
| Redis           | 缓存框架                   | https://redis.io                           |
| Lombok          | 对象封装工具               | https://github.com/projectlombok/lombok    |
| Nginx           | Http 和反向代理 Web 服务器 | http://nginx.org                           |

## 内置功能

1. 用户管理：用户是整个系统操作人，主要完成系统用户配置
2. 角色管理：配置角色菜单、分配用户角色等。
3. 菜单管理：配置系统菜单、按钮权限标识、关联 API 等。
4. 数据字典：系统中经常使用的一些较为固定的数据进行维护。
5. API 管理：后端所有接口地址、请求方式等。
6. 参数配置：系统动态配置常用参数。
7. 登录日志：系统登录日志记录查询。
8. 操作日志：系统操作日志记录和查询。
9. 导航管理：分类管理、网站管理、评论管理



1. 后台管理支持加载动态权限菜单，权限修改立即生效，不用再退出重新登录。
2. 高效率开发，只需要简单的 @Query 注解即可实现分页和列表接口。

## 项目结构

```yml
wxql-nav-admin: 后台管理模块
    wxql-nav-admin-application: 后台管理应用启动和导航业务
    wxql-nav-admin-system: 后台管理的系统管理模块
wxql-nav-common: 通用模块
    wxql-nav-common-core: 核心通用模块，包含一些通用工具类
    wxql-nav-common-framework: 通用框架模块
    wxql-nav-common-rate-limiter: 通用限流模块
    wxql-nav-common-log: 通用日志模块
    wxql-nav-common-redis: 通用缓存模块
    wxql-nav-common-security: 通用安全框架模块
    wxql-nav-common-swagger: 通用接口文档模块
wxql-nav-ui: 前端模块
```

## 开发运行

前端：

- 需要搭建 Vue 脚手架环境，如：安装 Node.js、Vue-cli 。

后端：

- 需要搭建 Java 开发环境。此外，还需要安装 MySQL 数据库（推荐 MySQL 8）、Redis。

**相关环境版本**：

| 软件名称 | 版本号    |
| -------- | --------- |
| Node     | 16.16.0   |
| NPM      | 6.14.15   |
| JDK      | 1.8.0_202 |
| MySQL    | 8.0.17    |
| Redis    | 5.0.9     |
| Nginx    | 1.9.9     |

### 前端运行

```bash
# 进入项目目录
cd vue-wxql-nav

# 安装依赖
npm install

# 直接运行以上命令可能会报错，可以尝试运行下面这条命令
npm install --legacy-peer-deps

# 建议不要直接使用 cnpm 安装依赖，会有各种诡异的 bug。可以通过如下操作解决 npm 下载速度慢的问题
npm install --registry=https://registry.npm.taobao.org

# 启动服务
npm run serve
```

浏览器访问 http://127.0.0.1:8023

### 后端运行

新建数据库（数据库名wxql_nav），导入 `sql/wxql_nav.sql` 数据库脚本

在 `wxql-nav/wxql-nav-admin/wxql-nav-admin-application`应用启动模块下，有三个配置文件：

| application.yml            | application-dev.yml                               | application-prod.yml                              |
| -------------------------- | ------------------------------------------------- | ------------------------------------------------- |
| 主要配置文件，配置公共信息 | 开发环境，配置 MySQL 数据库、Redis 缓存、文件路径 | 生产环境，配置 MySQL 数据库、Redis 缓存、文件路径 |

修改上述配置完成后，启动后台管理 `wxql-nav-admin-application` 应用

在开发环境的 application-dev.yml 配置文件中，配置 MySQL 数据库连接信息、Redis 缓存、网站初始化图片位置。

![QQ截图20230913194429](C:\Users\昭晞\Desktop\yun\wxql-nav-images\QQ截图20230913194429.png)

![QQ截图20230913194455](C:\Users\昭晞\Desktop\yun\wxql-nav-images\QQ截图20230913194455.png)

![QQ截图20230913194510](C:\Users\昭晞\Desktop\yun\wxql-nav-images\QQ截图20230913194510.png)

**注：** 需要把目录【网站图片】下的 profile.zip 解压到配置文件的文件路径中，否则内置的网站数据加载不出图片。比如我的是：`D:/myproject/wxql-nav/images`，解压后的文件路径如图所示，如果网站图片加载失败，请检查图片路径是否正确。

![QQ截图20230913194738](C:\Users\昭晞\Desktop\yun\wxql-nav-images\QQ截图20230913194738.png)

**生产环境**

在 application.yml 配置文件中，把 dev 改为 prod；并在 application-prod.yml 配置对应的 MySQL 数据库、Redis 环境、文件路径。

导航首页：http://127.0.0.1:8023

登录地址：[http://127.0.0.1:8023/login](http://127.0.0.1:8023.login)

默认用户：admin

默认密码：123456

## 项目演示

各导航的小组件

![QQ截图20230913193823](C:\Users\昭晞\Desktop\yun\wxql-nav-images\QQ截图20230913193823.png)

编辑个人展示资料

![QQ截图20230913193849](C:\Users\昭晞\Desktop\yun\wxql-nav-images\QQ截图20230913193849.png)

![QQ截图20230913193910](C:\Users\昭晞\Desktop\yun\wxql-nav-images\QQ截图20230913193910.png)

修改个人信息

![QQ截图20230913193923](C:\Users\昭晞\Desktop\yun\wxql-nav-images\QQ截图20230913193923.png)

![QQ截图20230913193940](C:\Users\昭晞\Desktop\yun\wxql-nav-images\QQ截图20230913193940.png)

![QQ截图20230913193953](C:\Users\昭晞\Desktop\yun\wxql-nav-images\QQ截图20230913193953.png)

## 项目部署

这里介绍Docker方式部署，也是我最常用的一种方式

### Nginx 代理配置

为了保证前端和后端不存在跨域问题，需要部署在 Nginx 进行配置：

```nginx
server {
    listen       80;
    server_name  localhost;
    
    # 前端项目配置
    location / {
        # root 后面为项目存在目录
        root /data/project/wxql-nav/dist;
        index index.html index.htm;
        try_files $uri $uri/ /index.html;
   }
    
   # 后端项目配置
   location /wxql-nav-api/ {
        # 项目 IP 地址和端口，如果不在一台服务器，请填写对应的 IP；如果后端端口修改后，请填写修改后的端口
        proxy_pass http://127.0.0.1:8083//wxql-nav-api/;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header REMOTE-HOST $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
  } 
}
```

## 感谢

蘑菇博客：[mogu_blog](https://gitee.com/moxi159753/mogu_blog_v2)

格姗导航：https://gitee.com/geshanzsq/geshanzsq-nav

## 更新日志

- 头部搜索框也增加圆角
- 删除了大部份不太需要的网站，简化了网站内容

