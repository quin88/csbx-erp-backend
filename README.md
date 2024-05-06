# 技术框架
* 核心框架：SpringBoot 2.0.0
* 持久层框架：Mybatis 1.3.2
* 日志管理：SLF4J 1.7
* 前端框架：Vue 2.6.10
* UI框架: Ant-Design-Vue 1.5.2
* 模板框架: Jeecg-Boot 2.2.0
* 项目管理框架: Maven 3.2.3

# 开发环境
* 创建MYSQL和redis数据库，运用docker，在ERP的项目中，进入jshERP-boot项目，运行以下command：
* docker-compose -f database.yml up -d
* 确保数据库运行起来了后
* 在jshERP-boot -> docs -> jsh_erp.sql 在数据库编辑器中（选择自己想用的数据库编辑器）运行这个sql文件
*	把后端的项目导入相对应的IDE中。
*	前端运行
*	打开VScode, 导入jshERP-web项目
*	运行以下command:
*	npm install
*	完成后 运行：
*	npm run serve
